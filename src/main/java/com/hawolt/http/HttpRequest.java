package com.hawolt.http;

import com.hawolt.Javan;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.exceptions.WrappedIOException;
import com.hawolt.http.ratelimiter.RateLimitManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * Used to send http requests
 */

public class HttpRequest {
    private final Map<String, String> headers, parameters;
    private final RateLimitManager rateLimitManager;
    private final List<PathSegment> pathSegments;
    private final String method, path, protocol;
    private final RoutingValue routingValue;
    private final byte[] payload;
    private String url;

    /**
     * @param builder Request builder containing data for the request
     */
    private HttpRequest(Builder builder) {
        this.rateLimitManager = builder.rateLimitManager;
        this.routingValue = builder.routingValue;
        this.parameters = builder.parameters;
        this.protocol = builder.protocol;
        this.pathSegments = builder.path;
        this.path = builder.path.stream()
                .filter(PathSegment::isPredefined)
                .map(PathSegment::getObject)
                .map(Object::toString)
                .collect(Collectors.joining("/"));
        this.headers = builder.headers;
        this.payload = builder.payload;
        this.method = builder.method;
        this.url = buildURL();
    }

    private String buildURL() {
        StringBuilder url = new StringBuilder();
        url.append(protocol).append("://").append(routingValue.getHost());
        String path = pathSegments.stream()
                .map(PathSegment::getObject)
                .map(Object::toString)
                .collect(Collectors.joining("/"));
        if (!path.isEmpty()) url.append("/").append(path);
        if (!parameters.entrySet().isEmpty()) url.append("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            char last = url.charAt(url.length() - 1);
            if (last != '?' && last != '&') url.append('&');
            try {
                String key = URLEncoder.encode(entry.getKey(), "UTF-8");
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                url.append(key).append("=").append(value);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return url.toString();
    }

    /**
     * @return Destination request path
     */
    public String getUrl() {
        return url;
    }

    public Map<String, String> getQueryParameterMap() {
        return parameters;
    }

    public void updateQueryParameter(String name, String value) {
        this.parameters.put(name, value);
        this.url = buildURL();
    }

    /**
     * @return Response to our request, may silently throw a WrappedIOException when failing to initialize
     * @see WrappedIOException
     */
    private HttpURLConnection connection() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod(method);
            connection.addRequestProperty("X-Riot-Token", Javan.getRiotAPIKey());
            for (String header : headers.keySet()) {
                connection.addRequestProperty(header, headers.get(header));
            }
            if (payload != null) {
                connection.setDoOutput(true);
                try (OutputStream stream = connection.getOutputStream()) {
                    stream.write(payload);
                }
            }
            return connection;
        } catch (IOException e) {
            throw new WrappedIOException(e);
        }
    }

    /**
     * @return Response to our request with a String body
     * @throws IOException
     */
    public HttpResponse<String> getAsString() throws IOException {
        return handleResponse(() -> new HttpResponse<>(bytes -> new String(bytes, StandardCharsets.UTF_8), connection()));
    }

    /**
     * @return Response to our request with a JSONObject body
     * @throws IOException
     */
    public HttpResponse<JSONObject> getAsJSONObject() throws IOException {
        return handleResponse(() -> new HttpResponse<>(bytes -> new JSONObject(new String(bytes, StandardCharsets.UTF_8)), connection()));
    }

    /**
     * @return Response to our request with a JSONArray body
     * @throws IOException
     */
    public HttpResponse<JSONArray> getAsJSONArray() throws IOException {
        return handleResponse(() -> new HttpResponse<>(bytes -> new JSONArray(new String(bytes, StandardCharsets.UTF_8)), connection()));
    }

    /**
     * @param supplier Supplier is used here to handle any Exceptions that can occur when constructing the response
     * @param <T>      Desired type of the response body
     * @return Response to a http request
     * @throws IOException
     * @see WrappedIOException
     */
    private <T> HttpResponse<T> handleResponse(Supplier<HttpResponse<T>> supplier) throws IOException {
        rateLimitManager.waitForQuota(routingValue, path);
        rateLimitManager.hit(routingValue, path);
        HttpResponse<T> response = supplier.get();
        try {
            rateLimitManager.report(routingValue, path, response);
        } catch (WrappedIOException wrappedRuntimeException) {
            throw wrappedRuntimeException.unwrap();
        }
        return response;
    }

    /**
     * Builder class for HttpRequest
     */
    public static class Builder {
        Map<String, String> parameters = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        List<PathSegment> path = new LinkedList<>();
        RateLimitManager rateLimitManager;
        RoutingValue routingValue;
        String method, protocol;
        byte[] payload;

        /**
         * @param rateLimitManager Manager to use for Rate Limit
         */
        public Builder(RateLimitManager rateLimitManager) {
            this.rateLimitManager = rateLimitManager;
        }

        /**
         * @param routingValue Hostname of the request
         * @return Our request Builder
         */
        public Builder host(RoutingValue routingValue) {
            this.routingValue = routingValue;
            return this;
        }

        /**
         * @param protocol http or https
         * @return Our request Builder
         */
        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * @param segments Path segments of the request
         * @return Our request Builder
         */
        public Builder path(PathSegment... segments) {
            this.path.addAll(Arrays.stream(segments).collect(Collectors.toList()));
            return this;
        }

        /**
         * @param segments Path segments of the request
         * @return Our request Builder
         */
        public Builder path(Object path, boolean predefined) {
            PathSegment segment = PathSegment.build(path, predefined);
            this.path.add(segment);
            return this;
        }

        /**
         * @param segments Path segments of the request
         * @return Our request Builder
         */
        public Builder path(String... path) {
            this.path.addAll(Arrays.stream(path).map(o -> new PathSegment(o, true)).collect(Collectors.toList()));
            return this;
        }

        /**
         * @param k Header key
         * @param v Header value
         * @return Our request Builder
         */
        public Builder addHeader(String k, String v) {
            headers.put(k, v);
            return this;
        }

        /**
         * @param k Query key
         * @param v Query value
         * @return Our request Builder
         */
        public Builder addQueryParameter(String k, Object v) {
            parameters.put(k, v.toString());
            return this;
        }

        /**
         * @return GET request based on the configured Builder
         */
        public HttpRequest get() {
            this.method = "GET";
            return new HttpRequest(this);
        }

        /**
         * @return POST request based on the configured Builder
         */
        public HttpRequest post(byte[] payload) {
            this.method = "POST";
            this.payload = payload;
            return new HttpRequest(this);
        }
    }
}
