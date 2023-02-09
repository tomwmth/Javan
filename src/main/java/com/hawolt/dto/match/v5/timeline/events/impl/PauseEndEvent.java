package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Generated structure of given Event
 **/

public class PauseEndEvent extends Event {
    private final String type;
    private final long realTimestamp;
    private final int timestamp;

    public PauseEndEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.realTimestamp = event.getLong("realTimestamp");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public long getRealTimestamp() {
        return realTimestamp;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "PauseEndEvent{" +
                "type='" + type + '\'' +
                ", realTimestamp=" + realTimestamp +
                ", timestamp=" + timestamp +
                ", rawEvent=" + rawEvent +
                ", type=" + type +
                '}';
    }
}
