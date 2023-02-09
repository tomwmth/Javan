package com.hawolt.data.routing;

/**
 * Abstraction for Platforms and Regions to access the Riot API
 *
 * @see Region
 * @see Platform
 */

public interface RoutingValue {
    String getHost();
}
