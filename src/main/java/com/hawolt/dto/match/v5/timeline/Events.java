package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.match.v5.timeline.events.Event;
import com.hawolt.dto.match.v5.timeline.events.EventTransformer;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class Events {
    private final List<Event> list = new ArrayList<>();

    public Events(JSONArray events) {
        for (int i = 0; i < events.length(); i++) {
            Event event = new Event(events.getJSONObject(i));
            list.add(EventTransformer.transform(event));
        }
    }

    public List<Event> getList() {
        return list;
    }
}
