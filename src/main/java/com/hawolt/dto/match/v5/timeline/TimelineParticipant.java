package com.hawolt.dto.match.v5.timeline;

import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:16
 * Author: Twitter @hawolt
 **/

public class TimelineParticipant {
    private final int participantId;
    private final String puuid;

    public TimelineParticipant(JSONObject participant) {
        this.participantId = participant.getInt("participantId");
        this.puuid = participant.getString("puuid");
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getPuuid() {
        return puuid;
    }

    @Override
    public String toString() {
        return "TimelineParticipant{" +
                "participantId=" + participantId +
                ", puuid='" + puuid + '\'' +
                '}';
    }
}
