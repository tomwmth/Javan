package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class FramesDto extends DataTransferObject {
    private final Events events;
    private final TimelineParticipantFrames participantFrames;
    private final int timestamp;

    public FramesDto(JSONObject frame) {
        super(frame);
        this.events = new Events(frame.getJSONArray("events"));
        this.timestamp = frame.getInt("timestamp");
        this.participantFrames = new TimelineParticipantFrames(frame.getJSONObject("participantFrames"));
    }

    public Events getEvents() {
        return events;
    }

    public TimelineParticipantFrames getParticipantFrames() {
        return participantFrames;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
