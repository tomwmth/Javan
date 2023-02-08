package com.hawolt.http.ratelimiter;

/**
 * Created: 07/02/2023 16:24
 * Author: Twitter @hawolt
 **/

public class RateLimitQuota {
    private final int value, interval;

    public RateLimitQuota(String data) {
        String[] quota = data.split(":");
        this.value = Integer.parseInt(quota[0]);
        this.interval = Integer.parseInt(quota[1]);
    }

    public int getValue() {
        return value;
    }

    public int getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "RateLimitQuota{" +
                "value=" + value +
                ", interval=" + interval +
                '}';
    }
}
