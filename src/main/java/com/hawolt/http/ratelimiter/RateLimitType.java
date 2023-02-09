package com.hawolt.http.ratelimiter;

/**
 * A type of Rate Limit
 */
public enum RateLimitType {
    APP, METHOD;

    /**
     * @return Name of the type used in a response header
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
