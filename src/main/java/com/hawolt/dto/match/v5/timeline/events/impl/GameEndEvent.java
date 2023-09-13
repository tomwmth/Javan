package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Generated structure of given Event
 **/

public class GameEndEvent extends Event {
    private final String type;
    private final long gameId, realTimestamp;
    private final int winningTeam, timestamp;

    public GameEndEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.gameId = event.getLong("gameId");
        this.realTimestamp = event.getLong("realTimestamp");
        this.winningTeam = event.getInt("winningTeam");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public long getGameId() {
        return gameId;
    }

    public long getRealTimestamp() {
        return realTimestamp;
    }

    public int getWinningTeam() {
        return winningTeam;
    }

    public int getTimestamp() {
        return timestamp;
    }
}