package com.hawolt.dto.league.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class LeagueEntryDTO extends DataTransferObject {
    private final String tier, leagueId, summonerName, queueType, rank, summonerId;
    private final boolean freshBlood, inactive, veteran, hotStreak;
    private final int wins, leaguePoints, losses;
    private MiniSeriesDTO miniSeries;

    public LeagueEntryDTO(JSONObject entry) {
        super(entry);
        this.tier = entry.getString("tier");
        this.leagueId = entry.getString("leagueId");
        this.summonerName = entry.getString("summonerName");
        this.queueType = entry.getString("queueType");
        this.rank = entry.getString("rank");
        this.summonerId = entry.getString("summonerId");
        this.freshBlood = entry.getBoolean("freshBlood");
        this.inactive = entry.getBoolean("inactive");
        this.veteran = entry.getBoolean("veteran");
        this.hotStreak = entry.getBoolean("hotStreak");
        this.wins = entry.getInt("wins");
        this.leaguePoints = entry.getInt("leaguePoints");
        this.losses = entry.getInt("losses");
        if (!entry.has("miniSeries")) return;
        this.miniSeries = new MiniSeriesDTO(entry.getJSONObject("miniSeries"));
    }

    public MiniSeriesDTO getMiniSeries() {
        return miniSeries;
    }

    public String getTier() {
        return tier;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getQueueType() {
        return queueType;
    }

    public String getRank() {
        return rank;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public boolean isInactive() {
        return inactive;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }

    public int getWins() {
        return wins;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public int getLosses() {
        return losses;
    }
}
