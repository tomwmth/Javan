package com.hawolt.http.ratelimit;

import com.hawolt.http.ratelimiter.RateLimitInsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Self-managed Strategy to deal with Rate Limits that initially reads the header
 * to inspect allowed requests and then counts requests itself rather than inspecting
 * the header for remaining requests
 **/

public class LocalCountingRateLimitStrategy extends AbstractRateLimitStrategy {
    private final long TEN_MINUTES_IN_MILLIS = TimeUnit.MINUTES.toMillis(10);
    private final long TEN_SECONDS_IN_MILLIS = TimeUnit.SECONDS.toMillis(10);

    /**
     * Contains paths to a resource and the associated Rate Limit that has to be respected
     */
    private final Map<String, RateLimitInsight> insights = new HashMap<>();
    /**
     * Contains paths of requested resources and the timestamps of requests that have been made towards it
     */
    private final Map<String, List<Long>> map = new HashMap<>();

    /**
     * Used to synchronize the Map holding Rate Limit data
     */
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
        long timestamp = System.currentTimeMillis() + 1;
        return (int) map.get(destination).stream().filter(o -> timestamp - o <= TEN_SECONDS_IN_MILLIS).count();
    }

    @Override
    public int getMajorRemaining(String destination) {
        long timestamp = System.currentTimeMillis() + 1;
        return (int) map.get(destination).stream().filter(o -> timestamp - o <= TEN_MINUTES_IN_MILLIS).count();
    }

    /**
     * Sleep until Rate Limit for the given path is available
     *
     * @param destination Endpoint with Rate Limit
     */
    @Override
    public void waitForQuota(String destination) {
        while (isQuotaReached(destination)) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
