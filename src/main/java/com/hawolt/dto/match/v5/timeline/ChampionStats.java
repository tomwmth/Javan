package com.hawolt.dto.match.v5.timeline;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class ChampionStats extends DataTransferObject {
    private final int lifesteal, magicPenPercent, healthRegen, movementSpeed, armorPenPercent, healthMax, power, attackDamage, physicalVamp, magicResist, abilityPower, abilityHaste, health, bonusMagicPenPercent, ccReduction, spellVamp, bonusArmorPenPercent, cooldownReduction, powerRegen, armor, armorPen, powerMax, attackSpeed, magicPen, omnivamp;

    public ChampionStats(JSONObject stats) {
        super(stats);
        this.lifesteal = stats.getInt("lifesteal");
        this.magicPenPercent = stats.getInt("magicPenPercent");
        this.healthRegen = stats.getInt("healthRegen");
        this.movementSpeed = stats.getInt("movementSpeed");
        this.armorPenPercent = stats.getInt("armorPenPercent");
        this.healthMax = stats.getInt("healthMax");
        this.power = stats.getInt("power");
        this.attackDamage = stats.getInt("attackDamage");
        this.physicalVamp = stats.getInt("physicalVamp");
        this.magicResist = stats.getInt("magicResist");
        this.abilityPower = stats.getInt("abilityPower");
        this.abilityHaste = stats.getInt("abilityHaste");
        this.health = stats.getInt("health");
        this.bonusMagicPenPercent = stats.getInt("bonusMagicPenPercent");
        this.ccReduction = stats.getInt("ccReduction");
        this.spellVamp = stats.getInt("spellVamp");
        this.bonusArmorPenPercent = stats.getInt("bonusArmorPenPercent");
        this.cooldownReduction = stats.getInt("cooldownReduction");
        this.powerRegen = stats.getInt("powerRegen");
        this.armor = stats.getInt("armor");
        this.armorPen = stats.getInt("armorPen");
        this.powerMax = stats.getInt("powerMax");
        this.attackSpeed = stats.getInt("attackSpeed");
        this.magicPen = stats.getInt("magicPen");
        this.omnivamp = stats.getInt("omnivamp");
    }

    public int getLifesteal() {
        return lifesteal;
    }

    public int getMagicPenPercent() {
        return magicPenPercent;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getArmorPenPercent() {
        return armorPenPercent;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public int getPower() {
        return power;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getPhysicalVamp() {
        return physicalVamp;
    }

    public int getMagicResist() {
        return magicResist;
    }

    public int getAbilityPower() {
        return abilityPower;
    }

    public int getAbilityHaste() {
        return abilityHaste;
    }

    public int getHealth() {
        return health;
    }

    public int getBonusMagicPenPercent() {
        return bonusMagicPenPercent;
    }

    public int getCcReduction() {
        return ccReduction;
    }

    public int getSpellVamp() {
        return spellVamp;
    }

    public int getBonusArmorPenPercent() {
        return bonusArmorPenPercent;
    }

    public int getCooldownReduction() {
        return cooldownReduction;
    }

    public int getPowerRegen() {
        return powerRegen;
    }

    public int getArmor() {
        return armor;
    }

    public int getArmorPen() {
        return armorPen;
    }

    public int getPowerMax() {
        return powerMax;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getMagicPen() {
        return magicPen;
    }

    public int getOmnivamp() {
        return omnivamp;
    }
}