package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.match.v5.timeline.events.Event;
import com.hawolt.dto.match.v5.timeline.events.EventTransformer;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 08/02/2023 13:26
 * Author: Twitter @hawolt
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

    @Override
    public String toString() {
        return "Events{" +
                "list=" + list +
                '}';
    }
}
