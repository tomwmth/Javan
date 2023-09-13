package com.hawolt.dto.match.v5.match;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class MatchDto extends DataTransferObject {
    private final MetadataDto metadataDto;
    private final InfoDto infoDto;

    public MatchDto(JSONObject body) {
        super(body);
        this.infoDto = new InfoDto(body.getJSONObject("info"));
        this.metadataDto = new MetadataDto(body.getJSONObject("metadata"));
    }

    public MetadataDto getMetadataDto() {
        return metadataDto;
    }

    public InfoDto getInfoDto() {
        return infoDto;
    }
}
