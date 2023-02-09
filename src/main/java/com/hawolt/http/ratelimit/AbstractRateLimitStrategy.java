package com.hawolt.http.ratelimit;

import com.hawolt.http.ratelimiter.RateLimitInsight;

/**
 * Abstraction layer on the very basic RateLimitStrategy
 *
 * @see RateLimitStrategy
 **/

public abstract class AbstractRateLimitStrategy implements RateLimitStrategy {

    /**
     * @param destination Path of the resource
     * @param limit       Insight on Rate Limits provided in the response headers
     * @see RateLimitInsight
     */
    public abstract void setRateLimitInsight(String destination, RateLimitInsight limit);

    /**
     * Indicates that a specific path is being requested
     *
     * @param destination Path of the resource
     */
    public abstract void hit(String destination);
}
