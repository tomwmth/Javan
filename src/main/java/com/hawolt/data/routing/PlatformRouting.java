package com.hawolt.data.routing;

import com.hawolt.exceptions.UnknownRoutingException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created: 07/02/2023 10:56
 * Author: Twitter @hawolt
 **/

public class PlatformRouting {
    private static final Map<Platform, RoutingValue> map = new HashMap<>();

    static {
        map.put(Platform.BR1, () -> "br1.api.riotgames.com");
        map.put(Platform.EUN1, () -> "eun1.api.riotgames.com");
        map.put(Platform.EUW1, () -> "euw1.api.riotgames.com");
        map.put(Platform.JP1, () -> "jp1.api.riotgames.com");
        map.put(Platform.KR, () -> "kr.api.riotgames.com");
        map.put(Platform.LA1, () -> "la1.api.riotgames.com");
        map.put(Platform.LA2, () -> "la2.api.riotgames.com");
        map.put(Platform.NA1, () -> "na1.api.riotgames.com");
        map.put(Platform.OC1, () -> "oc1.api.riotgames.com");
        map.put(Platform.TR1, () -> "tr1.api.riotgames.com");
        map.put(Platform.RU, () -> "ru.api.riotgames.com");
        map.put(Platform.PH2, () -> "ph2.api.riotgames.com");
        map.put(Platform.SG2, () -> "sg2.api.riotgames.com");
        map.put(Platform.TH2, () -> "th2.api.riotgames.com");
        map.put(Platform.TW2, () -> "tw2.api.riotgames.com");
        map.put(Platform.VN2, () -> "vn2.api.riotgames.com");
    }

    public static RoutingValue from(Platform platform) throws UnknownRoutingException {
        if (platform == null) throw new UnknownRoutingException("null");
        RoutingValue route = map.get(platform);
        if (route == null) throw new UnknownRoutingException(platform.name());
        return route;
    }
}
