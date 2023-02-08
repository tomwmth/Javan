package com.hawolt.dto.match.v5.timeline;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created: 08/02/2023 13:18
 * Author: Twitter @hawolt
 **/

public class TimelineParticipantFrames {
    private final Map<String, TimelineParticipantFrame> participantFrames = new HashMap<>();

    public TimelineParticipantFrames(JSONObject participant) {
        for (String key : participant.keySet()) {
            participantFrames.put(key, new TimelineParticipantFrame(participant.getJSONObject(key)));
        }
    }

    public Set<String> getParticipantIndexes() {
        return participantFrames.keySet();
    }
}