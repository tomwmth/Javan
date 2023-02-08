package com.hawolt.dto.match.v5.match;

import org.json.JSONObject;

/**
 * Created: 07/02/2023 14:48
 * Author: Twitter @hawolt
 **/

public class ObjectivesDto {
    private final ObjectiveDto baron, champion, dragon, inhibitor, riftHerald, tower;

    public ObjectivesDto(JSONObject objectives) {
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

    @Override
    public String toString() {
        return "ObjectivesDto{" +
                "baron=" + baron +
                ", champion=" + champion +
                ", local.dragon=" + dragon +
                ", inhibitor=" + inhibitor +
                ", riftHerald=" + riftHerald +
                ", tower=" + tower +
                '}';
    }
}
