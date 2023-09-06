package com.hawolt.http.ratelimiter;

import com.hawolt.data.routing.RoutingValue;
import com.hawolt.http.HttpResponse;
import com.hawolt.http.ratelimit.AbstractRateLimitStrategy;
import com.hawolt.http.ratelimit.LocalCountingRateLimitStrategy;

import java.util.List;
import java.util.Map;

/**
 * Manager for application and method Rate Limits
 **/

public class RateLimitManager {
    private AbstractRateLimitStrategy application = new LocalCountingRateLimitStrategy();
    private AbstractRateLimitStrategy method = new LocalCountingRateLimitStrategy();

    /**
     * @param routingValue Hostname of the given request used for application Rate Limit
     * @param path         Path of the given request used for method Rate Limit
     */
    public void waitForQuota(RoutingValue routingValue, String path) {
        application.waitForQuota(routingValue.getHost());
        method.waitForQuota(String.join("/", routingValue.getHost(), path));
    }

    /**
     * @param routingValue Hostname of the given request used for application Rate Limit
     * @param path         Path of the given request used for method Rate Limit
     */
    public void hit(RoutingValue routingValue, String path) {
        application.hit(routingValue.getHost());
        method.hit(String.join("/", routingValue.getHost(), path));
    }

    /**
     * @param routingValue Hostname of the given request used for application Rate Limit
     * @param path         Path of the given request used for method Rate Limit
     * @param response     Response we received for our request
     */
    public void report(RoutingValue routingValue, String path, HttpResponse<?> response) {
        handleRateLimit(RateLimitType.APP, routingValue.getHost(), response.headers());
        handleRateLimit(RateLimitType.METHOD, String.join("/", routingValue.getHost(), path), response.headers());
    }

    /**
     * @param type        Type of Rate Limit to handle
     * @param destination Path of the given request
     * @param map         Headers given in the response to our request
     */
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

    /**
     * @param type    The Rate Limit type to check for
     * @param headers Response headers from the request
     * @return Insight on the Rate Limits
     */
    private RateLimitInsight getLimitInsight(RateLimitType type, Map<String, List<String>> headers) {
        if (headers.containsKey("X-" + type + "-Rate-Limit")) {
            return new RateLimitInsight(headers.get("X-" + type + "-Rate-Limit").get(0));
        } else {
            String quota = Integer.MAX_VALUE + ":" + Integer.MAX_VALUE;
            String limit = String.join(",", quota, quota);
            return new RateLimitInsight(limit);
        }
    }

    /**
     * @param application Custom application Rate Limit strategy
     */
    public void setApplication(AbstractRateLimitStrategy application) {
        this.application = application;
    }

    /**
     * @param method Custom method Rate Limit strategy
     */
    public void setMethod(AbstractRateLimitStrategy method) {
        this.method = method;
    }
}
