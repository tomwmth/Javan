package com.hawolt.http.ratelimit;

/**
 * Strategy to deal with Rate Limits
 */

public interface RateLimitStrategy {
    /**
     * @param origin Path of the resource to check the Rate Limit for
     * @return Whether Rate Limits to the given Path are configured or not
     */
    boolean isUninitialized(String origin);

    /**
     * @param origin Path of the resource to check the Rate Limit for
     * @return If we have used up our Rate Limit for the given Path
     */
    boolean isQuotaReached(String origin);

    /**
     * @param origin Path of the resource to check the Rate Limit for
     * @return Requests remaining before reaching the ten-second Rate Limit for the given Path
     */
    int getMinorRemaining(String origin);

    /**
     * @param origin Path of the resource to check the Rate Limit for
     * @return Requests remaining before reaching the ten-minute Rate Limit for the given Path
     */
    int getMajorRemaining(String origin);

    /**
     * Whenever Quota for another request to our given Path is available do nothing
     * otherwise sleep until we are allowed another request
     *
     * @param destination Endpoint with Rate Limit
     */
    void waitForQuota(String destination);
}
