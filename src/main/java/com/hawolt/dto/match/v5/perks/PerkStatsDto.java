package com.hawolt.dto.match.v5.perks;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class PerkStatsDto extends DataTransferObject {
    private final int defense, flex, offense;

    public PerkStatsDto(JSONObject perk) {
        super(perk);
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
}
