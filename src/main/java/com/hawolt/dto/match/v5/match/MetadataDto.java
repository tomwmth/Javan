package com.hawolt.dto.match.v5.match;

import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class MetadataDto {
    private final String dataVersion, matchId;
    private final List<String> participants;

    public MetadataDto(JSONObject metadata) {
        this.dataVersion = metadata.getString("dataVersion");
        this.matchId = metadata.getString("matchId");
        this.participants = metadata.getJSONArray("participants")
                .toList()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public String getMatchId() {
        return matchId;
    }

    public List<String> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "MetadataDto{" +
                "dataVersion='" + dataVersion + '\'' +
                ", matchId='" + matchId + '\'' +
                ", participants=" + participants +
                '}';
    }
}
