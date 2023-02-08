package com.hawolt.dto.match.v5.timeline;

import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:24
 * Author: Twitter @hawolt
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