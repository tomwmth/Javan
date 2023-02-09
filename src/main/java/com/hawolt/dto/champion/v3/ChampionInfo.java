package com.hawolt.dto.champion.v3;

import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class ChampionInfo {
    private final List<Integer> freeChampionIdsForNewPlayers, freeChampionIds;

    private final Integer maxNewPlayerLevel;

    public ChampionInfo(JSONObject champion) {
        this.maxNewPlayerLevel = champion.getInt("maxNewPlayerLevel");
        this.freeChampionIdsForNewPlayers = champion.getJSONArray("freeChampionIdsForNewPlayers")
                .toList()
                .stream()
                .map(Object::toString)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.freeChampionIds = champion.getJSONArray("freeChampionIds")
                .toList()
                .stream()
                .map(Object::toString)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getFreeChampionIdsForNewPlayers() {
        return freeChampionIdsForNewPlayers;
    }

    public List<Integer> getFreeChampionIds() {
        return freeChampionIds;
    }

    public Integer getMaxNewPlayerLevel() {
        return maxNewPlayerLevel;
    }

    @Override
    public String toString() {
        return "ChampionInfo{" +
                "freeChampionIdsForNewPlayers=" + freeChampionIdsForNewPlayers +
                ", freeChampionIds=" + freeChampionIds +
                ", maxNewPlayerLevel=" + maxNewPlayerLevel +
                '}';
    }
}
