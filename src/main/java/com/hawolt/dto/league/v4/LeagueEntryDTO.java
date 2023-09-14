package com.hawolt.dto.league.v4;

import com.hawolt.data.api.RankedDivision;
import com.hawolt.data.api.RankedQueue;
import com.hawolt.data.api.RankedTier;
import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class LeagueEntryDTO extends DataTransferObject {
    private final RankedTier tier;
    private final RankedDivision division;
    private final RankedQueue queue;
    private final String leagueId, summonerName, summonerId;
    private final boolean freshBlood, inactive, veteran, hotStreak;
    private final int wins, leaguePoints, losses;
    private MiniSeriesDTO miniSeries;

    public LeagueEntryDTO(JSONObject entry) {
        super(entry);
        String tier = entry.getString("tier");
        this.tier = RankedTier.valueOf(tier);
        String division = entry.getString("rank");
        this.division = RankedDivision.valueOf(division);
        String queue = entry.getString("queueType");
        this.queue = RankedQueue.valueOf(queue);
        this.leagueId = entry.getString("leagueId");
        this.summonerName = entry.getString("summonerName");
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

    public RankedTier getTier() {
        return tier;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public RankedQueue getQueue() {
        return queue;
    }

    public RankedDivision getDivision() {
        return division;
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
