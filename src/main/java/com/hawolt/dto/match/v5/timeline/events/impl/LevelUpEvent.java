package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:46
 * Author: Twitter @hawolt
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

    @Override
    public String toString() {
        return "LevelUpEvent{" +
                "type='" + type + '\'' +
                ", participantId=" + participantId +
                ", level=" + level +
                ", timestamp=" + timestamp +
                ", rawEvent=" + rawEvent +
                ", type=" + type +
                '}';
    }
}
