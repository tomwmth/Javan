package com.hawolt.dto.match.v5.perks;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: 07/02/2023 12:42
 * Author: Twitter @hawolt
 **/

public class PerksDto {
    private final List<PerkStyleDto> styles;
    private final PerkStatsDto statPerks;

    public PerksDto(JSONObject perk) {
        this.statPerks = new PerkStatsDto(perk.getJSONObject("statPerks"));
        this.styles = perk.getJSONArray("styles")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(PerkStyleDto::new)
                .collect(Collectors.toList());
    }

    public List<PerkStyleDto> getStyles() {
        return styles;
    }

    public PerkStatsDto getStatPerks() {
        return statPerks;
    }

    @Override
    public String toString() {
        return "PerksDto{" +
                "styles=" + styles +
                ", statPerks=" + statPerks +
                '}';
    }
}
