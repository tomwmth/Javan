package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.Position;
import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated structure of given Event
 **/

public class BuildingKillEvent extends Event {
    private final String laneType, type, buildingType;
    private final int bounty, teamId, killerId, timestamp;
    private final Position position;
    private List<Integer> assistingParticipantIds = new ArrayList<>();
    private String towerType;

    public BuildingKillEvent(JSONObject event) {
        super(event);
        this.laneType = event.getString("laneType");
        this.type = event.getString("type");
        this.buildingType = event.getString("buildingType");
        this.position = new Position(event.getJSONObject("position"));
        this.bounty = event.getInt("bounty");
        this.teamId = event.getInt("teamId");
        this.killerId = event.getInt("killerId");
        this.timestamp = event.getInt("timestamp");
        if (event.has("towerType")) this.towerType = event.getString("towerType");
        if (event.has("assistingParticipantIds")) {
            this.assistingParticipantIds = event.getJSONArray("assistingParticipantIds")
                    .toList()
                    .stream()
                    .map(Object::toString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }

    public String getLaneType() {
        return laneType;
    }

    public String getTowerType() {
        return towerType;
    }

    public String getType() {
        return type;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public Position getPosition() {
        return position;
    }

    public Object getAssistingParticipantIds() {
        return assistingParticipantIds;
    }

    public int getBounty() {
        return bounty;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getKillerId() {
        return killerId;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
