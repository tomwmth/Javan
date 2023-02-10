package com.hawolt.http.ratelimiter;

/**
 * Wrapper for ten-second and ten-minute Rate Limit
 *
 * @see RateLimitQuota
 */

public class RateLimitInsight {
    private RateLimitQuota minor, major;

    /**
     * @param info The value of the Rate Limit Header
     */
    public RateLimitInsight(String info) {
        String[] data = info.split(",");
        this.minor = new RateLimitQuota(data[0]);
        if (data.length == 1) return;
        this.major = new RateLimitQuota(data[1]);
    }

    /**
     * @return Rate Limit Quota available within ten-seconds
     */
    public RateLimitQuota getMinor() {
        return minor;
    }

    /**
     * Major Rate Limit will be null when dealing with RateLimitType.METHOD
     *
     * @return Rate Limit Quota available within ten-minutes
     * @see RateLimitType
     */
    public RateLimitQuota getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "RateLimitInsight{" +
                "minor=" + minor +
                ", major=" + major +
                '}';
    }
}
