package com.hawolt.dto.clash.v1;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: 08/02/2023 12:25
 * Author: Twitter @hawolt
 **/

public class TournamentDto {
    private final int id, themeId;
    private final String nameKey, nameKeySecondary;
    private final List<TournamentPhaseDto> schedule;

    public TournamentDto(JSONObject tournament) {
        this.id = tournament.getInt("id");
        this.themeId = tournament.getInt("themeId");
        this.nameKey = tournament.getString("nameKey");
        this.nameKeySecondary = tournament.getString("nameKeySecondary");
        this.schedule = tournament.getJSONArray("schedule")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(TournamentPhaseDto::new)
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public int getThemeId() {
        return themeId;
    }

    public String getNameKey() {
        return nameKey;
    }

    public String getNameKeySecondary() {
        return nameKeySecondary;
    }

    public List<TournamentPhaseDto> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "TournamentDto{" +
                "id=" + id +
                ", themeId=" + themeId +
                ", nameKey='" + nameKey + '\'' +
                ", nameKeySecondary='" + nameKeySecondary + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
