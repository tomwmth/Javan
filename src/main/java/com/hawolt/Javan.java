package com.hawolt;

import com.hawolt.http.ratelimiter.RateLimitManager;

/**
 * Created: 07/02/2023 10:53
 * Author: Twitter @hawolt
 **/

public class Javan {

    public static RateLimitManager rateLimitManager = new RateLimitManager();
    private static String riotAPIKey;

    public static void setRiotAPIKey(String riotAPIKey) {
        Javan.riotAPIKey = riotAPIKey;
    }

    public static String getRiotAPIKey() {
        return riotAPIKey;
    }
}
