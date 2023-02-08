package com.hawolt.http.ratelimiter;

/**
 * Created: 07/02/2023 16:12
 * Author: Twitter @hawolt
 **/

public class RateLimitInsight {
    private RateLimitQuota minor, major;

    public RateLimitInsight(String info) {
        String[] data = info.split(",");
        this.minor = new RateLimitQuota(data[0]);
        if (data.length == 1) return;
        this.major = new RateLimitQuota(data[1]);
    }

    public RateLimitQuota getMinor() {
        return minor;
    }

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
