package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: 08/02/2023 11:26
 * Author: Twitter @hawolt
 **/

public class CurrentGameParticipant {
    private final List<GameCustomizationObject> gameCustomizationObjects;
    private final Perks perks;
    private final String summonerName, summonerId;
    private final int championId, profileIconId, teamId, spell1Id, spell2Id;
    private final boolean bot;

    public CurrentGameParticipant(JSONObject participant) {
        this.perks = new Perks(participant.getJSONObject("perks"));
        this.summonerName = participant.getString("summonerName");
        this.summonerId = participant.getString("summonerId");
        this.bot = participant.getBoolean("bot");
        this.championId = participant.getInt("championId");
        this.profileIconId = participant.getInt("profileIconId");
        this.teamId = participant.getInt("teamId");
        this.spell1Id = participant.getInt("spell1Id");
        this.spell2Id = participant.getInt("spell2Id");
        this.gameCustomizationObjects = participant.getJSONArray("gameCustomizationObjects")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(GameCustomizationObject::new)
                .collect(Collectors.toList());
    }

    public List<GameCustomizationObject> getGameCustomizationObjects() {
        return gameCustomizationObjects;
    }

    public Perks getPerks() {
        return perks;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getSummonerId() {
        return summonerId;
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

    public boolean isBot() {
        return bot;
    }

    @Override
    public String toString() {
        return "CurrentGameParticipant{" +
                "gameCustomizationObjects=" + gameCustomizationObjects +
                ", perks=" + perks +
                ", summonerName='" + summonerName + '\'' +
                ", summonerId='" + summonerId + '\'' +
                ", championId=" + championId +
                ", profileIconId=" + profileIconId +
                ", teamId=" + teamId +
                ", spell1Id=" + spell1Id +
                ", spell2Id=" + spell2Id +
                ", bot=" + bot +
                '}';
    }
}
