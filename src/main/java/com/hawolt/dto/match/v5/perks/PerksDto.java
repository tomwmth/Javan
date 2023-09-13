package com.hawolt.dto.match.v5.perks;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class PerksDto extends DataTransferObject {
    private final List<PerkStyleDto> styles;
    private final PerkStatsDto statPerks;

    public PerksDto(JSONObject perk) {
        super(perk);
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
}
