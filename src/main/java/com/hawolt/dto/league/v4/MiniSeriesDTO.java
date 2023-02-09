package com.hawolt.dto.league.v4;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class MiniSeriesDTO {
    private final int losses, target, wins;
    private final String progress;

    public MiniSeriesDTO(JSONObject series) {
        this.losses = series.getInt("losses");
        this.target = series.getInt("target");
        this.wins = series.getInt("wins");
        this.progress = series.getString("progress");
    }

    public int getLosses() {
        return losses;
    }

    public int getTarget() {
        return target;
    }

    public int getWins() {
        return wins;
    }

    public String getProgress() {
        return progress;
    }

    @Override
    public String toString() {
        return "MiniSeriesDTO{" +
                "losses=" + losses +
                ", target=" + target +
                ", wins=" + wins +
                ", progress='" + progress + '\'' +
                '}';
    }
}
