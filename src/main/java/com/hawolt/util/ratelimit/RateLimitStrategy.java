package com.hawolt.util.ratelimit;

/**
 * Created: 07/02/2023 15:29
 * Author: Twitter @hawolt
 **/

public interface RateLimitStrategy {

    boolean isUninitialized(String origin);

    boolean isQuotaReached(String origin);

    int getMinorRemaining(String origin);

    int getMajorRemaining(String origin);

    void waitForQuota(String destination);
}
