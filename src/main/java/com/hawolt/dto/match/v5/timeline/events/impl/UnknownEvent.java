package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:33
 * Author: Twitter @hawolt
 **/

public class UnknownEvent extends Event {
    public UnknownEvent(JSONObject event) {
        super(event);
    }
}
