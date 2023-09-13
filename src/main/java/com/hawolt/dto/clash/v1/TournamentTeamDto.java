package com.hawolt.dto.clash.v1;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class TournamentTeamDto extends DataTransferObject {
    private final String id, name, captain, abbreviation;
    private final int tournamentId, iconId, tier;
    private final List<PlayerDto> players;

    public TournamentTeamDto(JSONObject team) {
        super(team);
        this.id = team.getString("id");
        this.tournamentId = team.getInt("tournamentId");
        this.name = team.getString("name");
        this.iconId = team.getInt("iconId");
        this.tier = team.getInt("tier");
        this.captain = team.getString("captain");
        this.abbreviation = team.getString("captain");
        this.players = team.getJSONArray("players")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(PlayerDto::new)
                .map(playerDto -> playerDto.setTeamId(id))
                .collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCaptain() {
        return captain;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public int getIconId() {
        return iconId;
    }

    public int getTier() {
        return tier;
    }

    public List<PlayerDto> getPlayers() {
        return players;
    }
}
