package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Generated structure of given Event
 **/

public class LevelUpEvent extends Event {
    private final String type;
    private final int participantId, level, timestamp;

    public LevelUpEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.participantId = event.getInt("participantId");
        this.level = event.getInt("level");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getLevel() {
        return level;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
