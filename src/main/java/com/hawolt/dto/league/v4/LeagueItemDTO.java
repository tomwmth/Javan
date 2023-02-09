package com.hawolt.dto.league.v4;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class LeagueItemDTO {
    private final String summonerName, rank, summonerId;
    private final boolean freshBlood, inactive, veteran, hotStreak;
    private final int wins, leaguePoints, losses;
    private MiniSeriesDTO miniSeries;

    public LeagueItemDTO(JSONObject item) {
        this.summonerName = item.getString("summonerName");
        this.rank = item.getString("rank");
        this.summonerId = item.getString("summonerId");
        this.freshBlood = item.getBoolean("freshBlood");
        this.inactive = item.getBoolean("inactive");
        this.veteran = item.getBoolean("veteran");
        this.hotStreak = item.getBoolean("hotStreak");
        this.wins = item.getInt("wins");
        this.leaguePoints = item.getInt("leaguePoints");
        this.losses = item.getInt("losses");
        if (!item.has("miniSeries")) return;
        this.miniSeries = new MiniSeriesDTO(item.getJSONObject("miniSeries"));
    }

    public String getSummonerName() {
        return summonerName;
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

    public MiniSeriesDTO getMiniSeries() {
        return miniSeries;
    }

    @Override
    public String toString() {
        return "LeagueItemDTO{" +
                "summonerName='" + summonerName + '\'' +
                ", rank='" + rank + '\'' +
                ", summonerId='" + summonerId + '\'' +
                ", freshBlood=" + freshBlood +
                ", inactive=" + inactive +
                ", veteran=" + veteran +
                ", hotStreak=" + hotStreak +
                ", wins=" + wins +
                ", leaguePoints=" + leaguePoints +
                ", losses=" + losses +
                ", miniSeries=" + miniSeries +
                '}';
    }
}
