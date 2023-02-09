package com.hawolt.dto.match.v5.match;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class BanDto {
    private final int championId, pickTurn;

    public BanDto(JSONObject ban) {
        this.championId = ban.getInt("championId");
        this.pickTurn = ban.getInt("pickTurn");
    }

    public int getChampionId() {
        return championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    @Override
    public String toString() {
        return "BanDto{" +
                "championId=" + championId +
                ", pickTurn=" + pickTurn +
                '}';
    }
}
