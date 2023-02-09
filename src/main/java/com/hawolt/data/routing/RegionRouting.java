package com.hawolt.data.routing;

import com.hawolt.exceptions.UnknownRoutingException;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapping of the Region types to their associated hosts
 *
 * @see Region
 */


public class RegionRouting {
    private static final Map<Region, RoutingValue> map = new HashMap<>();

    static {
        map.put(Region.AMERICAS, () -> "americas.api.riotgames.com");
        map.put(Region.ASIA, () -> "asia.api.riotgames.com");
        map.put(Region.EUROPE, () -> "europe.api.riotgames.com");
        map.put(Region.SEA, () -> "sea.api.riotgames.com");
    }

    /**
     * @param region Region to fetch a RoutingValue for
     * @return Hostname for the specified Platform
     * @throws UnknownRoutingException When an unknown Region is provided
     */
    public static RoutingValue from(Region region) throws UnknownRoutingException {
        if (region == null) throw new UnknownRoutingException("null");
        RoutingValue route = map.get(region);
        if (route == null) throw new UnknownRoutingException(region.name());
        return route;
    }
}
