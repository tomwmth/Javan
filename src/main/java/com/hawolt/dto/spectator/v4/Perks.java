package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class Perks {
    private final Integer perkSubStyle, perkStyle;
    private final List<Long> perkIds;

    public Perks(JSONObject perks) {
        this.perkSubStyle = perks.getInt("perkSubStyle");
        this.perkStyle = perks.getInt("perkStyle");
        this.perkIds = perks.getJSONArray("perkIds")
                .toList()
                .stream()
                .map(Object::toString)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public Integer getPerkSubStyle() {
        return perkSubStyle;
    }

    public Integer getPerkStyle() {
        return perkStyle;
    }

    public List<Long> getPerkIds() {
        return perkIds;
    }

    @Override
    public String toString() {
        return "Perks{" +
                "perkSubStyle=" + perkSubStyle +
                ", perkStyle=" + perkStyle +
                ", perkIds=" + perkIds +
                '}';
    }
}
