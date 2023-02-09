package com.hawolt.dto.match.v5.perks;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class PerkStyleDto {
    private final List<PerkStyleSelectionDto> selections;
    private final String description;
    private final int style;

    public PerkStyleDto(JSONObject perk) {
        this.description = perk.getString("description");
        this.style = perk.getInt("style");
        this.selections = perk.getJSONArray("selections")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(PerkStyleSelectionDto::new)
                .collect(Collectors.toList());
    }

    public List<PerkStyleSelectionDto> getSelections() {
        return selections;
    }

    public String getDescription() {
        return description;
    }

    public int getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return "PerkStyleDto{" +
                "selections=" + selections +
                ", description='" + description + '\'' +
                ", style=" + style +
                '}';
    }
}
