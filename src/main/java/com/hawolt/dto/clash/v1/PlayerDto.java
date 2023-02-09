package com.hawolt.dto.clash.v1;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class PlayerDto {
    private final String summonerId, position, role;
    private String teamId;

    public PlayerDto(JSONObject player) {
        this.summonerId = player.getString("summonerId");
        this.position = player.getString("position");
        this.role = player.getString("role");
        if (!player.has("teamId")) return;
        this.teamId = player.getString("teamId");
    }

    public PlayerDto setTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "summonerId='" + summonerId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", position='" + position + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
