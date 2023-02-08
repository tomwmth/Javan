package com.hawolt.dto.match.v5.timeline;

import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:24
 * Author: Twitter @hawolt
 **/

public class DamageStats {
    private final int trueDamageDoneToChampions, magicDamageDoneToChampions, trueDamageTaken, magicDamageDone, totalDamageDone, magicDamageTaken, totalDamageTaken, physicalDamageDoneToChampions, physicalDamageTaken, trueDamageDone, physicalDamageDone, totalDamageDoneToChampions;

    public DamageStats(JSONObject stats) {
        this.trueDamageDoneToChampions = stats.getInt("trueDamageDoneToChampions");
        this.magicDamageDoneToChampions = stats.getInt("magicDamageDoneToChampions");
        this.trueDamageTaken = stats.getInt("trueDamageTaken");
        this.magicDamageDone = stats.getInt("magicDamageDone");
        this.totalDamageDone = stats.getInt("totalDamageDone");
        this.magicDamageTaken = stats.getInt("magicDamageTaken");
        this.totalDamageTaken = stats.getInt("totalDamageTaken");
        this.physicalDamageDoneToChampions = stats.getInt("physicalDamageDoneToChampions");
        this.physicalDamageTaken = stats.getInt("physicalDamageTaken");
        this.trueDamageDone = stats.getInt("trueDamageDone");
        this.physicalDamageDone = stats.getInt("physicalDamageDone");
        this.totalDamageDoneToChampions = stats.getInt("totalDamageDoneToChampions");
    }

    public int getTrueDamageDoneToChampions() {
        return trueDamageDoneToChampions;
    }

    public int getMagicDamageDoneToChampions() {
        return magicDamageDoneToChampions;
    }

    public int getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public int getMagicDamageDone() {
        return magicDamageDone;
    }

    public int getTotalDamageDone() {
        return totalDamageDone;
    }

    public int getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public int getPhysicalDamageDoneToChampions() {
        return physicalDamageDoneToChampions;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public int getTrueDamageDone() {
        return trueDamageDone;
    }

    public int getPhysicalDamageDone() {
        return physicalDamageDone;
    }

    public int getTotalDamageDoneToChampions() {
        return totalDamageDoneToChampions;
    }

    @Override
    public String toString() {
        return "DamageStats{" +
                "trueDamageDoneToChampions=" + trueDamageDoneToChampions +
                ", magicDamageDoneToChampions=" + magicDamageDoneToChampions +
                ", trueDamageTaken=" + trueDamageTaken +
                ", magicDamageDone=" + magicDamageDone +
                ", totalDamageDone=" + totalDamageDone +
                ", magicDamageTaken=" + magicDamageTaken +
                ", totalDamageTaken=" + totalDamageTaken +
                ", physicalDamageDoneToChampions=" + physicalDamageDoneToChampions +
                ", physicalDamageTaken=" + physicalDamageTaken +
                ", trueDamageDone=" + trueDamageDone +
                ", physicalDamageDone=" + physicalDamageDone +
                ", totalDamageDoneToChampions=" + totalDamageDoneToChampions +
                '}';
    }
}