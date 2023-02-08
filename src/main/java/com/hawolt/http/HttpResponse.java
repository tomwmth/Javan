package com.hawolt.http;

import com.hawolt.util.StreamReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created: 07/02/2023 12:49
 * Author: Twitter @hawolt
 **/

public class HttpResponse<T> implements AutoCloseable {
    private final Map<String, List<String>> headers;
    private final HttpURLConnection connection;
    private final Function<byte[], T> function;
    private T body;
    private int code;

    public HttpResponse(Function<byte[], T> function, HttpURLConnection connection) {
        this.headers = connection.getHeaderFields();
        this.connection = connection;
        this.function = function;
    }

    public int code() throws IOException {
        if (code != 0) return code;
        return (this.code = connection.getResponseCode());
    }

    public T body() throws IOException {
        if (body != null) return body;
        return (this.body = function.apply(read(connection)));
    }

    public Map<String, List<String>> headers() {
        return headers;
    }

    public byte[] read(HttpURLConnection connection) throws IOException {
        try (InputStream stream = connection.getInputStream()) {
            return StreamReader.read(stream);
        } catch (IOException e1) {
            try (InputStream stream = connection.getErrorStream()) {
                return StreamReader.read(stream);
            }
        }
    }

    @Override
    public void close() {
        this.connection.disconnect();
    }
}
