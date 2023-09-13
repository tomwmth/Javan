package com.hawolt.dto.match.v5.match;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class ObjectiveDto extends DataTransferObject {
    private final boolean first;
    private final int kills;

    public ObjectiveDto(JSONObject objective) {
        super(objective);
        this.first = objective.getBoolean("first");
        this.kills = objective.getInt("kills");
    }

    public boolean isFirst() {
        return first;
    }

    public int getKills() {
        return kills;
    }
}
