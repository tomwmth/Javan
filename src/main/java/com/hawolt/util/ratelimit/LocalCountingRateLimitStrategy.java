package com.hawolt.util.ratelimit;

import com.hawolt.http.ratelimiter.RateLimitInsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created: 07/02/2023 15:30
 * Author: Twitter @hawolt
 **/

public class LocalCountingRateLimitStrategy extends AbstractRateLimitStrategy {
    private final long TEN_MINUTES_IN_MILLIS = TimeUnit.MINUTES.toMillis(10);
    private final long TEN_SECONDS_IN_MILLIS = TimeUnit.SECONDS.toMillis(10);

    private final Map<String, RateLimitInsight> insights = new HashMap<>();
    private final Map<String, List<Long>> map = new HashMap<>();
    private final Object lock = new Object();

    @Override
    public void setRateLimitInsight(String destination, RateLimitInsight insight) {
        this.insights.put(destination, insight);
    }

    @Override
    public void hit(String destination) {
        synchronized (lock) {
            if (!this.map.containsKey(destination)) this.map.put(destination, new ArrayList<>());
            this.map.get(destination).add(System.currentTimeMillis());
        }
    }

    @Override
    public boolean isUninitialized(String destination) {
        synchronized (lock) {
            return !this.insights.containsKey(destination);
        }
    }

    @Override
    public boolean isQuotaReached(String destination) {
        if (isUninitialized(destination)) return false;
        long timestamp = System.currentTimeMillis();
        synchronized (lock) {
            map.get(destination).removeIf(o -> timestamp - o >= TEN_MINUTES_IN_MILLIS);
            RateLimitInsight insight = insights.get(destination);
            int minorRemaining = getMinorRemaining(destination);
            int majorRemaining = getMajorRemaining(destination);
            boolean minorQuotaReached = minorRemaining >= insight.getMinor().getValue();
            boolean majorQuotaReached = insight.getMajor() != null && majorRemaining >= insight.getMajor().getValue();
            return minorQuotaReached || majorQuotaReached;
        }
    }

    @Override
    public int getMinorRemaining(String destination) {
        long timestamp = System.currentTimeMillis();
        return (int) map.get(destination).stream().filter(o -> timestamp - o <= TEN_SECONDS_IN_MILLIS).count();
    }

    @Override
    public int getMajorRemaining(String destination) {
        long timestamp = System.currentTimeMillis();
        return (int) map.get(destination).stream().filter(o -> timestamp - o <= TEN_MINUTES_IN_MILLIS).count();
    }

    @Override
    public void waitForQuota(String destination) {
        while (isQuotaReached(destination)) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
