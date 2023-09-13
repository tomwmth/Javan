package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class DamageInfo extends Event {
    private final String name, spellName, type;
    private final boolean basic;
    private final int participantId, physicalDamage, magicDamage, spellSlot, trueDamage;

    public DamageInfo(JSONObject damage) {
        super(damage);
        this.name = damage.getString("name");
        this.spellName = damage.getString("spellName");
        this.type = damage.getString("type");
        this.basic = damage.getBoolean("basic");
        this.participantId = damage.getInt("participantId");
        this.physicalDamage = damage.getInt("physicalDamage");
        this.magicDamage = damage.getInt("magicDamage");
        this.spellSlot = damage.getInt("spellSlot");
        this.trueDamage = damage.getInt("trueDamage");
    }

    public String getName() {
        return name;
    }

    public String getSpellName() {
        return spellName;
    }

    public String getType() {
        return type;
    }

    public boolean isBasic() {
        return basic;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public int getSpellSlot() {
        return spellSlot;
    }

    public int getTrueDamage() {
        return trueDamage;
    }
}