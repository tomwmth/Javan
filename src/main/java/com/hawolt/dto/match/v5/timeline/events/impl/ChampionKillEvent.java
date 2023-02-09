package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.DamageInfo;
import com.hawolt.dto.match.v5.timeline.Position;
import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated structure of given Event
 **/

public class ChampionKillEvent extends Event {
    private final String type;
    private final Position position;
    private final List<DamageInfo> victimDamageReceived;
    private List<DamageInfo> victimDamageDealt;
    private List<Integer> assistingParticipantIds = new ArrayList<>();
    private final int bounty, shutdownBounty, killStreakLength, killerId, timestamp, victimId;

    public ChampionKillEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.position = new Position(event.getJSONObject("position"));
        this.bounty = event.getInt("bounty");
        this.shutdownBounty = event.getInt("shutdownBounty");
        this.killStreakLength = event.getInt("killStreakLength");
        this.killerId = event.getInt("killerId");
        this.timestamp = event.getInt("timestamp");
        this.victimId = event.getInt("victimId");
        this.victimDamageReceived = event.getJSONArray("victimDamageReceived")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(DamageInfo::new)
                .collect(Collectors.toList());
        if (event.has("victimDamageDealt")) {
            this.victimDamageDealt = event.getJSONArray("victimDamageDealt")
                    .toList()
                    .stream()
                    .map(o -> (HashMap<?, ?>) o)
                    .map(JSONObject::new)
                    .map(DamageInfo::new)
                    .collect(Collectors.toList());
        }
        if (event.has("assistingParticipantIds")) {
            this.assistingParticipantIds = event.getJSONArray("assistingParticipantIds")
                    .toList()
                    .stream()
                    .map(Object::toString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }

    public String getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public List<DamageInfo> getVictimDamageReceived() {
        return victimDamageReceived;
    }

    public List<DamageInfo> getVictimDamageDealt() {
        return victimDamageDealt;
    }

    public List<Integer> getAssistingParticipantIds() {
        return assistingParticipantIds;
    }

    public int getBounty() {
        return bounty;
    }

    public int getShutdownBounty() {
        return shutdownBounty;
    }

    public int getKillStreakLength() {
        return killStreakLength;
    }

    public int getKillerId() {
        return killerId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getVictimId() {
        return victimId;
    }

    @Override
    public String toString() {
        return "ChampionKillEvent{" +
                "type='" + type + '\'' +
                ", position=" + position +
                ", victimDamageReceived=" + victimDamageReceived +
                ", victimDamageDealt=" + victimDamageDealt +
                ", assistingParticipantIds=" + assistingParticipantIds +
                ", bounty=" + bounty +
                ", shutdownBounty=" + shutdownBounty +
                ", killStreakLength=" + killStreakLength +
                ", killerId=" + killerId +
                ", timestamp=" + timestamp +
                ", victimId=" + victimId +
                '}';
    }
}