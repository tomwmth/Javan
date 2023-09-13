package com.hawolt.dto.match.v5.timeline.events;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Handles events of the timeline
 **/

public class Event extends DataTransferObject {
    protected final JSONObject rawEvent;
    protected final EventType type;

    public Event(JSONObject event) {
        super(event);
        this.type = EventType.valueOfOrElse(event.getString("type"), EventType.UNKNOWN);
        this.rawEvent = event;
    }

    public JSONObject getRawEvent() {
        return rawEvent;
    }

    public EventType getEventType() {
        return type;
    }
}
