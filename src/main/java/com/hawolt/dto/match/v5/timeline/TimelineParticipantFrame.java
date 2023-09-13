package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class TimelineParticipantFrame extends DataTransferObject {
    private final DamageStats damageStats;
    private final ChampionStats championStats;
    private final Position position;
    private final int minionsKilled, participantId, timeEnemySpentControlled, level, totalGold, goldPerSecond, xp, currentGold, jungleMinionsKilled;

    public TimelineParticipantFrame(JSONObject participant) {
        super(participant);
        this.damageStats = new DamageStats(participant.getJSONObject("damageStats"));
        this.championStats = new ChampionStats(participant.getJSONObject("championStats"));
        this.position = new Position(participant.getJSONObject("position"));
        this.minionsKilled = participant.getInt("minionsKilled");
        this.participantId = participant.getInt("participantId");
        this.timeEnemySpentControlled = participant.getInt("timeEnemySpentControlled");
        this.level = participant.getInt("level");
        this.totalGold = participant.getInt("totalGold");
        this.goldPerSecond = participant.getInt("goldPerSecond");
        this.xp = participant.getInt("xp");
        this.currentGold = participant.getInt("currentGold");
        this.jungleMinionsKilled = participant.getInt("jungleMinionsKilled");
    }

    public DamageStats getDamageStats() {
        return damageStats;
    }

    public ChampionStats getChampionStats() {
        return championStats;
    }

    public Position getPosition() {
        return position;
    }

    public int getMinionsKilled() {
        return minionsKilled;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getTimeEnemySpentControlled() {
        return timeEnemySpentControlled;
    }

    public int getLevel() {
        return level;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public int getGoldPerSecond() {
        return goldPerSecond;
    }

    public int getXp() {
        return xp;
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public int getJungleMinionsKilled() {
        return jungleMinionsKilled;
    }
}