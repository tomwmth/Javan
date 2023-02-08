package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

/**
 * Created: 08/02/2023 11:25
 * Author: Twitter @hawolt
 **/

public class BannedChampion {
    private final int championId, pickTurn, teamId;

    public BannedChampion(JSONObject banned) {
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

    @Override
    public String toString() {
        return "BannedChampion{" +
                "championId=" + championId +
                ", pickTurn=" + pickTurn +
                ", teamId=" + teamId +
                '}';
    }
}
