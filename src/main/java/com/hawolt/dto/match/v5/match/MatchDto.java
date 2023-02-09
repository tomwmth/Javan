package com.hawolt.dto.match.v5.match;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class MatchDto {
    private final MetadataDto metadataDto;
    private final InfoDto infoDto;

    public MatchDto(JSONObject body) {
        this.infoDto = new InfoDto(body.getJSONObject("info"));
        this.metadataDto = new MetadataDto(body.getJSONObject("metadata"));
    }

    public MetadataDto getMetadataDto() {
        return metadataDto;
    }

    public InfoDto getInfoDto() {
        return infoDto;
    }

    @Override
    public String toString() {
        return "MatchDto{" +
                "metadataDto=" + metadataDto +
                ", infoDto=" + infoDto +
                '}';
    }
}
