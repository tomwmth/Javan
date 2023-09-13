package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import com.hawolt.dto.match.v5.match.MetadataDto;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class MatchTimelineDto extends DataTransferObject {
    private final MetadataDto metadata;
    private final TimelineInfo info;

    public MatchTimelineDto(JSONObject timeline) {
        super(timeline);
        this.metadata = new MetadataDto(timeline.getJSONObject("metadata"));
        this.info = new TimelineInfo(timeline.getJSONObject("info"));
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public TimelineInfo getInfo() {
        return info;
    }
}