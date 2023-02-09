package com.hawolt.data.routing;

/**
 * Platform types that are used to access the API
 * associated with a Region which bundles multiple Platforms
 *
 * @see Region
 */

public enum Platform {
    BR1(Region.AMERICAS),
    EUN1(Region.EUROPE),
    EUW1(Region.EUROPE),
    JP1(Region.ASIA),
    KR(Region.ASIA),
    LA1(Region.AMERICAS),
    LA2(Region.AMERICAS),
    NA1(Region.AMERICAS),
    OC1(Region.SEA),
    TR1(Region.EUROPE),
    RU(Region.EUROPE),
    PH2(Region.SEA),
    SG2(Region.SEA),
    TH2(Region.SEA),
    TW2(Region.SEA),
    VN2(Region.SEA);
    final Region region;

    Platform(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }
}
