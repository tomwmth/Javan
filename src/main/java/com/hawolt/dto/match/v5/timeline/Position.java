package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class Position extends DataTransferObject {
    private final int x, y;

    public Position(JSONObject position) {
        super(position);
        this.x = position.getInt("x");
        this.y = position.getInt("y");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}