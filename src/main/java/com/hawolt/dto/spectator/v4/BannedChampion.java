package com.hawolt.dto.spectator.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class BannedChampion extends DataTransferObject {
    private final int championId, pickTurn, teamId;

    public BannedChampion(JSONObject banned) {
        super(banned);
        this.championId = banned.getInt("championId");
        this.pickTurn = banned.getInt("pickTurn");
        this.teamId = banned.getInt("teamId");
    }

    public int getChampionId() {
        return championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public int getTeamId() {
        return teamId;
    }
}
