package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class TimelineParticipant extends DataTransferObject {
    private final int participantId;
    private final String puuid;

    public TimelineParticipant(JSONObject participant) {
        super(participant);
        this.participantId = participant.getInt("participantId");
        this.puuid = participant.getString("puuid");
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getPUUID() {
        return puuid;
    }
}
