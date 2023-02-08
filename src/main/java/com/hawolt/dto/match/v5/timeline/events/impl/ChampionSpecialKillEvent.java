package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:46
 * Author: Twitter @hawolt
 **/

public class ChampionSpecialKillEvent extends Event {
    private final String killType, type;
    private final Object position;
    private final int killerId, timestamp;

    public ChampionSpecialKillEvent(JSONObject event) {
        super(event);
        this.killType = event.getString("killType");
        this.type = event.getString("type");
        this.position = event.get("position");
        this.killerId = event.getInt("killerId");
        this.timestamp = event.getInt("timestamp");
    }

    public String getKillType() {
        return killType;
    }

    public String getType() {
        return type;
    }

    public Object getPosition() {
        return position;
    }

    public int getKillerId() {
        return killerId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ChampionSpecialKillEvent{" +
                "killType='" + killType + '\'' +
                ", type='" + type + '\'' +
                ", position=" + position +
                ", killerId=" + killerId +
                ", timestamp=" + timestamp +
                ", rawEvent=" + rawEvent +
                ", type=" + type +
                '}';
    }
}
