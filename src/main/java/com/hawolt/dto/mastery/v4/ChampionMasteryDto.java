package com.hawolt.dto.mastery.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class ChampionMasteryDto extends DataTransferObject {
    private final String summonerId;
    private final long lastPlayTime;
    private final boolean chestGranted;
    private final int championPointsUntilNextLevel, tokensEarned, championId, championLevel, championPoints, championPointsSinceLastLevel;

    public ChampionMasteryDto(JSONObject mastery) {
        super(mastery);
        this.summonerId = mastery.getString("summonerId");
        this.lastPlayTime = mastery.getLong("lastPlayTime");
        this.chestGranted = mastery.getBoolean("chestGranted");
        this.championPointsUntilNextLevel = mastery.getInt("championPointsUntilNextLevel");
        this.tokensEarned = mastery.getInt("tokensEarned");
        this.championId = mastery.getInt("championId");
        this.championLevel = mastery.getInt("championLevel");
        this.championPoints = mastery.getInt("championPoints");
        this.championPointsSinceLastLevel = mastery.getInt("championPointsSinceLastLevel");
    }

    public String getSummonerId() {
        return summonerId;
    }

    public long getLastPlayTime() {
        return lastPlayTime;
    }

    public boolean isChestGranted() {
        return chestGranted;
    }

    public int getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public int getTokensEarned() {
        return tokensEarned;
    }

    public int getChampionId() {
        return championId;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public int getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }
}
