package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Generated structure of given Event
 **/

public class ItemUndoEvent extends Event {
    private final String type;
    private final int participantId, beforeId, goldGain, afterId, timestamp;

    public ItemUndoEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.participantId = event.getInt("participantId");
        this.beforeId = event.getInt("beforeId");
        this.goldGain = event.getInt("goldGain");
        this.afterId = event.getInt("afterId");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getBeforeId() {
        return beforeId;
    }

    public int getGoldGain() {
        return goldGain;
    }

    public int getAfterId() {
        return afterId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ItemUndoEvent{" +
                "type='" + type + '\'' +
                ", participantId=" + participantId +
                ", beforeId=" + beforeId +
                ", goldGain=" + goldGain +
                ", afterId=" + afterId +
                ", timestamp=" + timestamp +
                ", rawEvent=" + rawEvent +
                ", type=" + type +
                '}';
    }
}