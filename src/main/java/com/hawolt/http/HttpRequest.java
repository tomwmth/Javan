package com.hawolt.http;

import com.hawolt.Kassadin;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.exceptions.WrappedIOException;
import com.hawolt.http.ratelimiter.RateLimitManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created: 07/02/2023 12:47
 * Author: Twitter @hawolt
 **/

public class HttpRequest {
    private final RateLimitManager rateLimitManager;
    private final Map<String, String> headers;
    private final RoutingValue routingValue;
    private final String url, method, path;

    private HttpRequest(Builder builder) {
        StringBuilder url = new StringBuilder();
        url.append(builder.protocol).append("://").append(builder.routingValue.getHost());
        String path = String.join("/", builder.path);
        if (!path.isEmpty()) url.append("/").append(path);
        for (Map.Entry<String, String> entry : builder.parameters.entrySet()) {
            char separator = url.charAt(url.length() - 1) == '?' ? '&' : '?';
            try {
                String key = URLEncoder.encode(entry.getKey(), "UTF-8");
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                url.append(separator).append(key).append("=").append(value);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        this.path = path;
        this.url = url.toString();
        this.method = builder.method;
        this.headers = builder.headers;
        this.routingValue = builder.routingValue;
        this.rateLimitManager = builder.rateLimitManager;
    }

    public String getUrl() {
        return url;
    }

    private HttpURLConnection connection() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod(method);
            connection.addRequestProperty("X-Riot-Token", Kassadin.getRiotAPIKey());
            for (String header : headers.keySet()) {
                connection.addRequestProperty(header, headers.get(header));
            }
            return connection;
        } catch (IOException e) {
            throw new WrappedIOException(e);
        }
    }

    public HttpResponse<String> getAsString() throws IOException {
        return handleResponse(() -> new HttpResponse<>(String::new, connection()));
    }

    public HttpResponse<JSONObject> getAsJSONObject() throws IOException {
        return handleResponse(() -> new HttpResponse<>(bytes -> new JSONObject(new String(bytes)), connection()));
    }

    public HttpResponse<JSONArray> getAsJSONArray() throws IOException {
        return handleResponse(() -> new HttpResponse<>(bytes -> new JSONArray(new String(bytes)), connection()));
    }

    private <T> HttpResponse<T> handleResponse(Supplier<HttpResponse<T>> supplier) throws IOException {
        rateLimitManager.waitForQuota(routingValue, path);
        rateLimitManager.hit(routingValue, path);
        try {
            HttpResponse<T> response = supplier.get();
            rateLimitManager.report(routingValue, path, response);
            return response;
        } catch (WrappedIOException wrappedRuntimeException) {
            throw wrappedRuntimeException.unwrap();
        }
    }

    public static class Builder {
        Map<String, String> parameters = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        List<String> path = new LinkedList<>();
        RateLimitManager rateLimitManager;
        RoutingValue routingValue;
        String method, protocol;

        public Builder(RateLimitManager rateLimitManager) {
            this.rateLimitManager = rateLimitManager;
        }

        public Builder host(RoutingValue routingValue) {
            this.routingValue = routingValue;
            return this;
        }

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder path(Object... segments) {
            this.path.addAll(Arrays.stream(segments).map(Object::toString).collect(Collectors.toList()));
            return this;
        }

        public Builder addHeader(String k, String v) {
            headers.put(k, v);
            return this;
        }

        public Builder addQueryParameter(String k, Object v) {
            parameters.put(k, v.toString());
            return this;
        }

        public HttpRequest get() {
            this.method = "GET";
            return new HttpRequest(this);
        }
    }
}
