package com.hawolt.http.ratelimiter;

import com.hawolt.data.routing.RoutingValue;
import com.hawolt.http.HttpResponse;
import com.hawolt.util.ratelimit.AbstractRateLimitStrategy;
import com.hawolt.util.ratelimit.LocalCountingRateLimitStrategy;

import java.util.List;
import java.util.Map;

/**
 * Created: 07/02/2023 18:52
 * Author: Twitter @hawolt
 **/

public class RateLimitManager {
    private AbstractRateLimitStrategy application = new LocalCountingRateLimitStrategy();
    private AbstractRateLimitStrategy method = new LocalCountingRateLimitStrategy();

    public void waitForQuota(RoutingValue routingValue, String path) {
        application.waitForQuota(routingValue.getHost());
        method.waitForQuota(String.join("/", routingValue.getHost(), path));
    }

    public void hit(RoutingValue routingValue, String path) {
        application.hit(routingValue.getHost());
        method.hit(String.join("/", routingValue.getHost(), path));
    }

    public void report(RoutingValue routingValue, String path, HttpResponse<?> response) {
        handleRateLimit(RateLimitType.APP, routingValue.getHost(), response.headers());
        handleRateLimit(RateLimitType.METHOD, String.join("/", routingValue.getHost(), path), response.headers());
    }

    private void handleRateLimit(RateLimitType type, String destination, Map<String, List<String>> map) {
        AbstractRateLimitStrategy strategy = null;
        switch (type) {
            case APP:
                strategy = application;
                break;
            case METHOD:
                strategy = method;
                break;
        }
        if (strategy == null) return;
        if (strategy.isUninitialized(destination)) {
            strategy.setRateLimitInsight(destination, getLimitInsight(type, map));
        }
    }

    private RateLimitInsight getLimitInsight(RateLimitType type, Map<String, List<String>> headers) {
        return new RateLimitInsight(headers.get("X-" + type + "-Rate-Limit").get(0));
    }

}
