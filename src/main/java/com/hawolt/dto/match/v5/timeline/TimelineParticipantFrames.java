package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class TimelineParticipantFrames extends DataTransferObject {
    private final Map<String, TimelineParticipantFrame> participantFrames = new HashMap<>();

    public TimelineParticipantFrames(JSONObject participant) {
        super(participant);
        for (String key : participant.keySet()) {
            participantFrames.put(key, new TimelineParticipantFrame(participant.getJSONObject(key)));
        }
    }

    public Set<String> getParticipantIndexes() {
        return participantFrames.keySet();
    }
}