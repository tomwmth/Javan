package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.match.v5.match.MetadataDto;
import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:09
 * Author: Twitter @hawolt
 **/

public class MatchTimelineDto {
    private final MetadataDto metadata;
    private final TimelineInfo info;

    public MatchTimelineDto(JSONObject timeline) {
        this.metadata = new MetadataDto(timeline.getJSONObject("metadata"));
        this.info = new TimelineInfo(timeline.getJSONObject("info"));
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public TimelineInfo getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "MatchTimelineDto{" +
                "metadata=" + metadata +
                ", info=" + info +
                '}';
    }
}