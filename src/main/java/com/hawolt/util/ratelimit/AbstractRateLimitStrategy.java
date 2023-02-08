package com.hawolt.util.ratelimit;

import com.hawolt.http.ratelimiter.RateLimitInsight;

/**
 * Created: 07/02/2023 20:04
 * Author: Twitter @hawolt
 **/

public abstract class AbstractRateLimitStrategy implements RateLimitStrategy {

    public abstract void setRateLimitInsight(String destination, RateLimitInsight limit);
    public abstract void hit(String destination);
}
