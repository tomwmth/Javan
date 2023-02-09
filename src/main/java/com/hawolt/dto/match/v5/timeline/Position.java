package com.hawolt.dto.match.v5.timeline;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class Position {
    private final int x, y;

    public Position(JSONObject position) {
        this.x = position.getInt("x");
        this.y = position.getInt("y");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}