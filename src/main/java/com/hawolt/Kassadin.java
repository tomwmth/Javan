package com.hawolt;

import com.hawolt.api.MatchAPI;
import com.hawolt.data.routing.Platform;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.http.ratelimiter.RateLimitManager;

import java.io.IOException;

/**
 * Created: 07/02/2023 10:53
 * Author: Twitter @hawolt
 **/

public class Kassadin {

    public static RateLimitManager rateLimitManager = new RateLimitManager();
    private static String riotAPIKey;

    public static void setRiotAPIKey(String riotAPIKey) {
        Kassadin.riotAPIKey = riotAPIKey;
    }

    public static String getRiotAPIKey() {
        return riotAPIKey;
    }
}
