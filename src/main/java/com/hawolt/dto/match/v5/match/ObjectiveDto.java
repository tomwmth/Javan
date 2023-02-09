package com.hawolt.dto.match.v5.match;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class ObjectiveDto {
    private final boolean first;
    private final int kills;

    public ObjectiveDto(JSONObject objective) {
        this.first = objective.getBoolean("first");
        this.kills = objective.getInt("kills");
    }

    public boolean isFirst() {
        return first;
    }

    public int getKills() {
        return kills;
    }

    @Override
    public String toString() {
        return "ObjectiveDto{" +
                "first=" + first +
                ", kills=" + kills +
                '}';
    }
}
