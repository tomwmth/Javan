package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Generated structure of given Event
 **/

public class SkillLevelUpEvent extends Event {
    private final String type, levelUpType;
    private final int participantId, skillSlot, timestamp;

    public SkillLevelUpEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.levelUpType = event.getString("levelUpType");
        this.participantId = event.getInt("participantId");
        this.skillSlot = event.getInt("skillSlot");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public String getLevelUpType() {
        return levelUpType;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getSkillSlot() {
        return skillSlot;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
