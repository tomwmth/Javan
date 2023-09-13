package com.hawolt.dto.spectator.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class Participant extends DataTransferObject {
    private final String summonerName;
    private final boolean bot;
    private final int championId, profileIconId, teamId, spell1Id, spell2Id;

    public Participant(JSONObject participant) {
        super(participant);
        this.summonerName = participant.getString("summonerName");
        this.bot = participant.getBoolean("bot");
        this.championId = participant.getInt("championId");
        this.profileIconId = participant.getInt("profileIconId");
        this.teamId = participant.getInt("teamId");
        this.spell1Id = participant.getInt("spell1Id");
        this.spell2Id = participant.getInt("spell2Id");
    }

    public String getSummonerName() {
        return summonerName;
    }

    public boolean isBot() {
        return bot;
    }

    public int getChampionId() {
        return championId;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getSpell1Id() {
        return spell1Id;
    }

    public int getSpell2Id() {
        return spell2Id;
    }
}
