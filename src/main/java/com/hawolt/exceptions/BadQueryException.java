package com.hawolt.exceptions;

import java.util.Map;

/**
 * Indicates that one or multiple bad Query parameters have been used
 */
public class BadQueryException extends RuntimeException {
    private final Map<String, String> queryParameterMap;

    public BadQueryException(Map<String, String> queryParameterMap) {
        this.queryParameterMap = queryParameterMap;
    }

    public Map<String, String> getQueryParameterMap() {
        return queryParameterMap;
    }
}
