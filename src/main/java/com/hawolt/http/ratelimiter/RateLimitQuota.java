package com.hawolt.http.ratelimiter;

/**
 * Rate Limit data
 */
public class RateLimitQuota {

    private final int value, interval;

    public RateLimitQuota(String data) {
        String[] quota = data.split(":");
        this.value = Integer.parseInt(quota[0]);
        this.interval = Integer.parseInt(quota[1]);
    }

    /**
     * @return Used or allowed amount of requests based on the provided data source
     */
    public int getValue() {
        return value;
    }

    /**
     * @return Amount in seconds that goes along with the amount of requests we are allowed to send
     */
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
