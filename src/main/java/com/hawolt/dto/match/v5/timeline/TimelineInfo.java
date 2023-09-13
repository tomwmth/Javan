package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class TimelineInfo extends DataTransferObject {
    private final long gameId;
    private final List<TimelineParticipant> participants;
    private final List<FramesDto> frames;
    private final int frameInterval;

    public TimelineInfo(JSONObject info) {
        super(info);
        this.gameId = info.getLong("gameId");
        this.frameInterval = info.getInt("frameInterval");
        this.participants = info.getJSONArray("participants")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(TimelineParticipant::new)
                .collect(Collectors.toList());
        this.frames = info.getJSONArray("frames")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(FramesDto::new)
                .collect(Collectors.toList());
    }

    public long getGameId() {
        return gameId;
    }

    public List<TimelineParticipant> getParticipants() {
        return participants;
    }

    public List<FramesDto> getFrames() {
        return frames;
    }

    public int getFrameInterval() {
        return frameInterval;
    }
}