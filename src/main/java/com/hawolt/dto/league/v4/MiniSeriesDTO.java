package com.hawolt.dto.league.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class MiniSeriesDTO extends DataTransferObject {
    private final int losses, target, wins;
    private final String progress;

    public MiniSeriesDTO(JSONObject series) {
        super(series);
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
}
