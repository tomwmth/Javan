package com.hawolt.http;

import com.hawolt.util.StreamReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Used to handle responses to a request
 *
 * @param <T> Type of the response body
 */

public class HttpResponse<T> implements AutoCloseable {
    private final Map<String, List<String>> headers;
    private final HttpURLConnection connection;
    private final Function<byte[], T> function;
    private T body;
    private int code;

    /**
     * @param function   Transformer from initial byte response to desired type
     * @param connection Response source
     */
    public HttpResponse(Function<byte[], T> function, HttpURLConnection connection) {
        this.headers = connection.getHeaderFields();
        this.connection = connection;
        this.function = function;
    }

    /**
     * @return Response code for our request
     * @throws IOException
     */
    public int code() throws IOException {
        if (code != 0) return code;
        return (this.code = connection.getResponseCode());
    }

    /**
     * @return Response body for our request
     * @throws IOException
     */
    public T body() throws IOException {
        if (body != null) return body;
        return (this.body = function.apply(read(connection)));
    }

    /**
     * @return Response headers for our request
     */
    public Map<String, List<String>> headers() {
        return headers;
    }

    /**
     * Attempts to read the InputStream and falls back to the Error Stream if required
     *
     * @param connection Source of data to read from
     * @return Response to our request
     * @throws IOException
     */
    public byte[] read(HttpURLConnection connection) throws IOException {
        try (InputStream stream = connection.getInputStream()) {
            return StreamReader.read(stream);
        } catch (IOException e1) {
            try (InputStream stream = connection.getErrorStream()) {
                return StreamReader.read(stream);
            }
        }
    }

    /**
     * Closes the initialized connection
     */
    @Override
    public void close() {
        this.connection.disconnect();
    }
}
