package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Generated structure of given Event
 **/

public class ItemDestroyedEvent extends Event {
    private final String type;
    private final int participantId, itemId, timestamp;

    public ItemDestroyedEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.participantId = event.getInt("participantId");
        this.itemId = event.getInt("itemId");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
