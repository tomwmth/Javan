package com.hawolt.dto.match.v5.match;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class BanDto extends DataTransferObject {
    private final int championId, pickTurn;

    public BanDto(JSONObject ban) {
        super(ban);
        this.championId = ban.getInt("championId");
        this.pickTurn = ban.getInt("pickTurn");
    }

    public int getChampionId() {
        return championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }
}
