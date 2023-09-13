package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Generated structure of given Event
 **/

public class WardPlacedEvent extends Event {
    private final String type, wardType;
    private final int creatorId, timestamp;

    public WardPlacedEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.wardType = event.getString("wardType");
        this.creatorId = event.getInt("creatorId");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public String getWardType() {
        return wardType;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public int getTimestamp() {
        return timestamp;
    }
}