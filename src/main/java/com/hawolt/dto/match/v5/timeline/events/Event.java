package com.hawolt.dto.match.v5.timeline.events;

import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:34
 * Author: Twitter @hawolt
 **/

public class Event {
    protected final JSONObject rawEvent;
    protected final EventType type;

    public Event(JSONObject event) {
        this.type = EventType.valueOfOrElse(event.getString("type"), EventType.UNKNOWN);
        this.rawEvent = event;
    }

    public JSONObject getRawEvent() {
        return rawEvent;
    }

    public EventType getEventType() {
        return type;
    }

    @Override
    public String toString() {
        return "GenericEvent{" +
                "rawEvent=" + rawEvent +
                ", type=" + type +
                '}';
    }
}
