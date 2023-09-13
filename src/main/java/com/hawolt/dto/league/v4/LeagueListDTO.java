package com.hawolt.dto.league.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class LeagueListDTO extends DataTransferObject {
    private final List<LeagueItemDTO> entries;
    private final String tier, leagueId, name, queue;

    public LeagueListDTO(JSONObject list) {
        super(list);
        this.tier = list.getString("tier");
        this.leagueId = list.getString("leagueId");
        this.name = list.getString("name");
        this.queue = list.getString("queue");
        this.entries = list.getJSONArray("entries")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(LeagueItemDTO::new)
                .sorted(Comparator.comparingInt(LeagueItemDTO::getLeaguePoints))
                .collect(Collectors.toList());
    }

    public List<LeagueItemDTO> getEntries() {
        return entries;
    }

    public String getTier() {
        return tier;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getName() {
        return name;
    }

    public String getQueue() {
        return queue;
    }
}