package com.hawolt.dto.match.v5.perks;

import org.json.JSONObject;

/**
 * Created: 07/02/2023 14:53
 * Author: Twitter @hawolt
 **/

public class PerkStatsDto {
    private final int defense, flex, offense;

    public PerkStatsDto(JSONObject perk) {
        this.defense = perk.getInt("defense");
        this.flex = perk.getInt("flex");
        this.offense = perk.getInt("offense");
    }

    public int getDefense() {
        return defense;
    }

    public int getFlex() {
        return flex;
    }

    public int getOffense() {
        return offense;
    }

    @Override
    public String toString() {
        return "PerkStatsDto{" +
                "defense=" + defense +
                ", flex=" + flex +
                ", offense=" + offense +
                '}';
    }
}
