package com.hawolt.dto.match.v5.match;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class TeamDto extends DataTransferObject {
    private final List<BanDto> bans;
    private final ObjectivesDto objectives;
    private final int teamId;
    private final boolean win;

    public TeamDto(JSONObject team) {
        super(team);
        this.win = team.getBoolean("win");
        this.teamId = team.getInt("teamId");
        this.objectives = new ObjectivesDto(team.getJSONObject("objectives"));
        this.bans = team.getJSONArray("bans")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(BanDto::new)
                .collect(Collectors.toList());
    }

    public List<BanDto> getBans() {
        return bans;
    }

    public ObjectivesDto getObjectives() {
        return objectives;
    }

    public int getTeamId() {
        return teamId;
    }

    public boolean isWin() {
        return win;
    }
}
