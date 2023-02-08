package com.hawolt.http.ratelimiter;

/**
 * Created: 07/02/2023 16:28
 * Author: Twitter @hawolt
 **/

public enum RateLimitType {
    APP, METHOD;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
