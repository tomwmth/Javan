package com.hawolt.dto.match.v5.match;

import org.json.JSONObject;

/**
 * Created: 07/02/2023 14:48
 * Author: Twitter @hawolt
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
