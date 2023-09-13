package com.hawolt.dto.match.v5.match;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class ObjectivesDto extends DataTransferObject {
    private final ObjectiveDto baron, champion, dragon, inhibitor, riftHerald, tower;

    public ObjectivesDto(JSONObject objectives) {
        super(objectives);
        this.baron = new ObjectiveDto(objectives.getJSONObject("baron"));
        this.champion = new ObjectiveDto(objectives.getJSONObject("champion"));
        this.dragon = new ObjectiveDto(objectives.getJSONObject("dragon"));
        this.inhibitor = new ObjectiveDto(objectives.getJSONObject("inhibitor"));
        this.riftHerald = new ObjectiveDto(objectives.getJSONObject("riftHerald"));
        this.tower = new ObjectiveDto(objectives.getJSONObject("tower"));
    }

    public ObjectiveDto getBaron() {
        return baron;
    }

    public ObjectiveDto getChampion() {
        return champion;
    }

    public ObjectiveDto getDragon() {
        return dragon;
    }

    public ObjectiveDto getInhibitor() {
        return inhibitor;
    }

    public ObjectiveDto getRiftHerald() {
        return riftHerald;
    }

    public ObjectiveDto getTower() {
        return tower;
    }
}
