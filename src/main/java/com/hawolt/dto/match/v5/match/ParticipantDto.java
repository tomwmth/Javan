package com.hawolt.dto.match.v5.match;

import com.hawolt.dto.match.v5.perks.PerksDto;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class ParticipantDto {
    private final int bountyLevel, totalUnitsHealed, largestMultiKill, spell2Casts, champExperience, onMyWayPings, summonerLevel, holdPings, damageDealtToObjectives, pushPings, turretTakedowns, magicDamageTaken, deaths, objectivesStolen, detectorWardsPlaced, enemyMissingPings, magicDamageDealtToChampions, wardsKilled, pentaKills, spell3Casts, wardsPlaced, totalDamageDealt, largestKillingSpree, totalDamageDealtToChampions, summoner2Id, totalTimeSpentDead, inhibitorKills, totalTimeCCDealt, participantId, profileIcon, goldSpent, unrealKills, consumablesPurchased, visionScore, longestTimeSpentLiving, killingSprees, sightWardsBoughtInGame, turretsLost, commandPings, quadraKills, item4, nexusTakedowns, item3, item6, item5, item0, item2, summoner1Id, item1, totalDamageShieldedOnTeammates, summoner2Casts, goldEarned, nexusLost, physicalDamageTaken, champLevel, totalDamageTaken, neutralMinionsKilled, basicPings, allInPings, championTransform, tripleKills, damageSelfMitigated, inhibitorsLost, inhibitorTakedowns, largestCriticalStrike, assistMePings, totalHealsOnTeammates, summoner1Casts, damageDealtToBuildings, magicDamageDealt, timePlayed, timeCCingOthers, physicalDamageDealtToChampions, totalMinionsKilled, visionWardsBoughtInGame, kills, championId, baitPings, getBackPings, needVisionPings, turretKills, enemyVisionPings, trueDamageTaken, assists, itemsPurchased, objectivesStolenAssists, damageDealtToTurrets, totalHeal, visionClearedPings, physicalDamageDealt, trueDamageDealtToChampions, dragonKills, baronKills, doubleKills, nexusKills, trueDamageDealt, spell1Casts, teamId, dangerPings, spell4Casts;
    private final boolean teamEarlySurrendered, eligibleForProgression, firstTowerAssist, firstBloodAssist, gameEndedInEarlySurrender, firstBloodKill, gameEndedInSurrender, firstTowerKill, win;
    private final String riotIdName, role, championName, riotIdTagline, summonerName, puuid, summonerId, teamPosition, individualPosition, lane;
    private final PerksDto perks;

    public ParticipantDto(JSONObject participant) {
        this.riotIdName = participant.getString("riotIdName");
        this.role = participant.getString("role");
        this.championName = participant.getString("championName");
        this.riotIdTagline = participant.getString("riotIdTagline");
        this.summonerName = participant.getString("summonerName");
        this.puuid = participant.getString("puuid");
        this.summonerId = participant.getString("summonerId");
        this.teamPosition = participant.getString("teamPosition");
        this.individualPosition = participant.getString("individualPosition");
        this.lane = participant.getString("lane");
        this.teamEarlySurrendered = participant.getBoolean("teamEarlySurrendered");
        this.eligibleForProgression = participant.getBoolean("eligibleForProgression");
        this.firstTowerAssist = participant.getBoolean("firstTowerAssist");
        this.firstBloodAssist = participant.getBoolean("firstBloodAssist");
        this.gameEndedInEarlySurrender = participant.getBoolean("gameEndedInEarlySurrender");
        this.firstBloodKill = participant.getBoolean("firstBloodKill");
        this.gameEndedInSurrender = participant.getBoolean("gameEndedInSurrender");
        this.firstTowerKill = participant.getBoolean("firstTowerKill");
        this.win = participant.getBoolean("win");
        this.bountyLevel = participant.getInt("bountyLevel");
        this.totalUnitsHealed = participant.getInt("totalUnitsHealed");
        this.largestMultiKill = participant.getInt("largestMultiKill");
        this.spell2Casts = participant.getInt("spell2Casts");
        this.champExperience = participant.getInt("champExperience");
        this.onMyWayPings = participant.getInt("onMyWayPings");
        this.summonerLevel = participant.getInt("summonerLevel");
        this.holdPings = participant.getInt("holdPings");
        this.damageDealtToObjectives = participant.getInt("damageDealtToObjectives");
        this.pushPings = participant.getInt("pushPings");
        this.turretTakedowns = participant.getInt("turretTakedowns");
        this.magicDamageTaken = participant.getInt("magicDamageTaken");
        this.deaths = participant.getInt("deaths");
        this.objectivesStolen = participant.getInt("objectivesStolen");
        this.detectorWardsPlaced = participant.getInt("detectorWardsPlaced");
        this.enemyMissingPings = participant.getInt("enemyMissingPings");
        this.magicDamageDealtToChampions = participant.getInt("magicDamageDealtToChampions");
        this.wardsKilled = participant.getInt("wardsKilled");
        this.pentaKills = participant.getInt("pentaKills");
        this.spell3Casts = participant.getInt("spell3Casts");
        this.wardsPlaced = participant.getInt("wardsPlaced");
        this.totalDamageDealt = participant.getInt("totalDamageDealt");
        this.largestKillingSpree = participant.getInt("largestKillingSpree");
        this.totalDamageDealtToChampions = participant.getInt("totalDamageDealtToChampions");
        this.summoner2Id = participant.getInt("summoner2Id");
        this.totalTimeSpentDead = participant.getInt("totalTimeSpentDead");
        this.inhibitorKills = participant.getInt("inhibitorKills");
        this.totalTimeCCDealt = participant.getInt("totalTimeCCDealt");
        this.participantId = participant.getInt("participantId");
        this.profileIcon = participant.getInt("profileIcon");
        this.goldSpent = participant.getInt("goldSpent");
        this.unrealKills = participant.getInt("unrealKills");
        this.consumablesPurchased = participant.getInt("consumablesPurchased");
        this.visionScore = participant.getInt("visionScore");
        this.longestTimeSpentLiving = participant.getInt("longestTimeSpentLiving");
        this.killingSprees = participant.getInt("killingSprees");
        this.sightWardsBoughtInGame = participant.getInt("sightWardsBoughtInGame");
        this.turretsLost = participant.getInt("turretsLost");
        this.commandPings = participant.getInt("commandPings");
        this.quadraKills = participant.getInt("quadraKills");
        this.item4 = participant.getInt("item4");
        this.nexusTakedowns = participant.getInt("nexusTakedowns");
        this.item3 = participant.getInt("item3");
        this.item6 = participant.getInt("item6");
        this.item5 = participant.getInt("item5");
        this.item0 = participant.getInt("item0");
        this.item2 = participant.getInt("item2");
        this.summoner1Id = participant.getInt("summoner1Id");
        this.item1 = participant.getInt("item1");
        this.totalDamageShieldedOnTeammates = participant.getInt("totalDamageShieldedOnTeammates");
        this.summoner2Casts = participant.getInt("summoner2Casts");
        this.goldEarned = participant.getInt("goldEarned");
        this.nexusLost = participant.getInt("nexusLost");
        this.physicalDamageTaken = participant.getInt("physicalDamageTaken");
        this.champLevel = participant.getInt("champLevel");
        this.totalDamageTaken = participant.getInt("totalDamageTaken");
        this.neutralMinionsKilled = participant.getInt("neutralMinionsKilled");
        this.basicPings = participant.getInt("basicPings");
        this.allInPings = participant.getInt("allInPings");
        this.championTransform = participant.getInt("championTransform");
        this.tripleKills = participant.getInt("tripleKills");
        this.damageSelfMitigated = participant.getInt("damageSelfMitigated");
        this.inhibitorsLost = participant.getInt("inhibitorsLost");
        this.inhibitorTakedowns = participant.getInt("inhibitorTakedowns");
        this.largestCriticalStrike = participant.getInt("largestCriticalStrike");
        this.assistMePings = participant.getInt("assistMePings");
        this.totalHealsOnTeammates = participant.getInt("totalHealsOnTeammates");
        this.summoner1Casts = participant.getInt("summoner1Casts");
        this.damageDealtToBuildings = participant.getInt("damageDealtToBuildings");
        this.magicDamageDealt = participant.getInt("magicDamageDealt");
        this.timePlayed = participant.getInt("timePlayed");
        this.timeCCingOthers = participant.getInt("timeCCingOthers");
        this.physicalDamageDealtToChampions = participant.getInt("physicalDamageDealtToChampions");
        this.totalMinionsKilled = participant.getInt("totalMinionsKilled");
        this.visionWardsBoughtInGame = participant.getInt("visionWardsBoughtInGame");
        this.kills = participant.getInt("kills");
        this.championId = participant.getInt("championId");
        this.baitPings = participant.getInt("baitPings");
        this.getBackPings = participant.getInt("getBackPings");
        this.needVisionPings = participant.getInt("needVisionPings");
        this.turretKills = participant.getInt("turretKills");
        this.enemyVisionPings = participant.getInt("enemyVisionPings");
        this.trueDamageTaken = participant.getInt("trueDamageTaken");
        this.assists = participant.getInt("assists");
        this.itemsPurchased = participant.getInt("itemsPurchased");
        this.objectivesStolenAssists = participant.getInt("objectivesStolenAssists");
        this.damageDealtToTurrets = participant.getInt("damageDealtToTurrets");
        this.totalHeal = participant.getInt("totalHeal");
        this.visionClearedPings = participant.getInt("visionClearedPings");
        this.physicalDamageDealt = participant.getInt("physicalDamageDealt");
        this.trueDamageDealtToChampions = participant.getInt("trueDamageDealtToChampions");
        this.dragonKills = participant.getInt("dragonKills");
        this.baronKills = participant.getInt("baronKills");
        this.doubleKills = participant.getInt("doubleKills");
        this.nexusKills = participant.getInt("nexusKills");
        this.trueDamageDealt = participant.getInt("trueDamageDealt");
        this.spell1Casts = participant.getInt("spell1Casts");
        this.teamId = participant.getInt("teamId");
        this.dangerPings = participant.getInt("dangerPings");
        this.spell4Casts = participant.getInt("spell4Casts");
        this.perks = new PerksDto(participant.getJSONObject("perks"));
    }

    public int getBountyLevel() {
        return bountyLevel;
    }

    public int getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public int getSpell2Casts() {
        return spell2Casts;
    }

    public int getChampExperience() {
        return champExperience;
    }

    public int getOnMyWayPings() {
        return onMyWayPings;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public int getHoldPings() {
        return holdPings;
    }

    public int getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    public int getPushPings() {
        return pushPings;
    }

    public int getTurretTakedowns() {
        return turretTakedowns;
    }

    public int getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getObjectivesStolen() {
        return objectivesStolen;
    }

    public int getDetectorWardsPlaced() {
        return detectorWardsPlaced;
    }

    public int getEnemyMissingPings() {
        return enemyMissingPings;
    }

    public int getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public int getWardsKilled() {
        return wardsKilled;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public int getSpell3Casts() {
        return spell3Casts;
    }

    public int getWardsPlaced() {
        return wardsPlaced;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public int getSummoner2Id() {
        return summoner2Id;
    }

    public int getTotalTimeSpentDead() {
        return totalTimeSpentDead;
    }

    public int getInhibitorKills() {
        return inhibitorKills;
    }

    public int getTotalTimeCCDealt() {
        return totalTimeCCDealt;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public int getUnrealKills() {
        return unrealKills;
    }

    public int getConsumablesPurchased() {
        return consumablesPurchased;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public int getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    public int getKillingSprees() {
        return killingSprees;
    }

    public int getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public int getTurretsLost() {
        return turretsLost;
    }

    public int getCommandPings() {
        return commandPings;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public int getItem4() {
        return item4;
    }

    public int getNexusTakedowns() {
        return nexusTakedowns;
    }

    public int getItem3() {
        return item3;
    }

    public int getItem6() {
        return item6;
    }

    public int getItem5() {
        return item5;
    }

    public int getItem0() {
        return item0;
    }

    public int getItem2() {
        return item2;
    }

    public int getSummoner1Id() {
        return summoner1Id;
    }

    public int getItem1() {
        return item1;
    }

    public int getTotalDamageShieldedOnTeammates() {
        return totalDamageShieldedOnTeammates;
    }

    public int getSummoner2Casts() {
        return summoner2Casts;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public int getNexusLost() {
        return nexusLost;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public int getChampLevel() {
        return champLevel;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public int getBasicPings() {
        return basicPings;
    }

    public int getAllInPings() {
        return allInPings;
    }

    public int getChampionTransform() {
        return championTransform;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public int getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    public int getInhibitorsLost() {
        return inhibitorsLost;
    }

    public int getInhibitorTakedowns() {
        return inhibitorTakedowns;
    }

    public int getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public int getAssistMePings() {
        return assistMePings;
    }

    public int getTotalHealsOnTeammates() {
        return totalHealsOnTeammates;
    }

    public int getSummoner1Casts() {
        return summoner1Casts;
    }

    public int getDamageDealtToBuildings() {
        return damageDealtToBuildings;
    }

    public int getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public int getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public int getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public int getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public int getKills() {
        return kills;
    }

    public int getChampionId() {
        return championId;
    }

    public int getBaitPings() {
        return baitPings;
    }

    public int getGetBackPings() {
        return getBackPings;
    }

    public int getNeedVisionPings() {
        return needVisionPings;
    }

    public int getTurretKills() {
        return turretKills;
    }

    public int getEnemyVisionPings() {
        return enemyVisionPings;
    }

    public int getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public int getAssists() {
        return assists;
    }

    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public int getObjectivesStolenAssists() {
        return objectivesStolenAssists;
    }

    public int getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public int getVisionClearedPings() {
        return visionClearedPings;
    }

    public int getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public int getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public int getDragonKills() {
        return dragonKills;
    }

    public int getBaronKills() {
        return baronKills;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public int getNexusKills() {
        return nexusKills;
    }

    public int getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public int getSpell1Casts() {
        return spell1Casts;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getDangerPings() {
        return dangerPings;
    }

    public int getSpell4Casts() {
        return spell4Casts;
    }

    public boolean isTeamEarlySurrendered() {
        return teamEarlySurrendered;
    }

    public boolean isEligibleForProgression() {
        return eligibleForProgression;
    }

    public boolean isFirstTowerAssist() {
        return firstTowerAssist;
    }

    public boolean isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public boolean isGameEndedInEarlySurrender() {
        return gameEndedInEarlySurrender;
    }

    public boolean isFirstBloodKill() {
        return firstBloodKill;
    }

    public boolean isGameEndedInSurrender() {
        return gameEndedInSurrender;
    }

    public boolean isFirstTowerKill() {
        return firstTowerKill;
    }

    public boolean isWin() {
        return win;
    }

    public String getRiotIdName() {
        return riotIdName;
    }

    public String getRole() {
        return role;
    }

    public String getChampionName() {
        return championName;
    }

    public String getRiotIdTagline() {
        return riotIdTagline;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public String getIndividualPosition() {
        return individualPosition;
    }

    public String getLane() {
        return lane;
    }

    public PerksDto getPerks() {
        return perks;
    }

    @Override
    public String toString() {
        return "ParticipantDto{" +
                "bountyLevel=" + bountyLevel +
                ", totalUnitsHealed=" + totalUnitsHealed +
                ", largestMultiKill=" + largestMultiKill +
                ", spell2Casts=" + spell2Casts +
                ", champExperience=" + champExperience +
                ", onMyWayPings=" + onMyWayPings +
                ", summonerLevel=" + summonerLevel +
                ", holdPings=" + holdPings +
                ", damageDealtToObjectives=" + damageDealtToObjectives +
                ", pushPings=" + pushPings +
                ", turretTakedowns=" + turretTakedowns +
                ", magicDamageTaken=" + magicDamageTaken +
                ", deaths=" + deaths +
                ", objectivesStolen=" + objectivesStolen +
                ", detectorWardsPlaced=" + detectorWardsPlaced +
                ", enemyMissingPings=" + enemyMissingPings +
                ", magicDamageDealtToChampions=" + magicDamageDealtToChampions +
                ", wardsKilled=" + wardsKilled +
                ", pentaKills=" + pentaKills +
                ", spell3Casts=" + spell3Casts +
                ", wardsPlaced=" + wardsPlaced +
                ", totalDamageDealt=" + totalDamageDealt +
                ", largestKillingSpree=" + largestKillingSpree +
                ", totalDamageDealtToChampions=" + totalDamageDealtToChampions +
                ", summoner2Id=" + summoner2Id +
                ", totalTimeSpentDead=" + totalTimeSpentDead +
                ", inhibitorKills=" + inhibitorKills +
                ", totalTimeCCDealt=" + totalTimeCCDealt +
                ", participantId=" + participantId +
                ", profileIcon=" + profileIcon +
                ", goldSpent=" + goldSpent +
                ", unrealKills=" + unrealKills +
                ", consumablesPurchased=" + consumablesPurchased +
                ", visionScore=" + visionScore +
                ", longestTimeSpentLiving=" + longestTimeSpentLiving +
                ", killingSprees=" + killingSprees +
                ", sightWardsBoughtInGame=" + sightWardsBoughtInGame +
                ", turretsLost=" + turretsLost +
                ", commandPings=" + commandPings +
                ", quadraKills=" + quadraKills +
                ", item4=" + item4 +
                ", nexusTakedowns=" + nexusTakedowns +
                ", item3=" + item3 +
                ", item6=" + item6 +
                ", item5=" + item5 +
                ", item0=" + item0 +
                ", item2=" + item2 +
                ", summoner1Id=" + summoner1Id +
                ", item1=" + item1 +
                ", totalDamageShieldedOnTeammates=" + totalDamageShieldedOnTeammates +
                ", summoner2Casts=" + summoner2Casts +
                ", goldEarned=" + goldEarned +
                ", nexusLost=" + nexusLost +
                ", physicalDamageTaken=" + physicalDamageTaken +
                ", champLevel=" + champLevel +
                ", totalDamageTaken=" + totalDamageTaken +
                ", neutralMinionsKilled=" + neutralMinionsKilled +
                ", basicPings=" + basicPings +
                ", allInPings=" + allInPings +
                ", championTransform=" + championTransform +
                ", tripleKills=" + tripleKills +
                ", damageSelfMitigated=" + damageSelfMitigated +
                ", inhibitorsLost=" + inhibitorsLost +
                ", inhibitorTakedowns=" + inhibitorTakedowns +
                ", largestCriticalStrike=" + largestCriticalStrike +
                ", assistMePings=" + assistMePings +
                ", totalHealsOnTeammates=" + totalHealsOnTeammates +
                ", summoner1Casts=" + summoner1Casts +
                ", damageDealtToBuildings=" + damageDealtToBuildings +
                ", magicDamageDealt=" + magicDamageDealt +
                ", timePlayed=" + timePlayed +
                ", timeCCingOthers=" + timeCCingOthers +
                ", physicalDamageDealtToChampions=" + physicalDamageDealtToChampions +
                ", totalMinionsKilled=" + totalMinionsKilled +
                ", visionWardsBoughtInGame=" + visionWardsBoughtInGame +
                ", kills=" + kills +
                ", championId=" + championId +
                ", baitPings=" + baitPings +
                ", getBackPings=" + getBackPings +
                ", needVisionPings=" + needVisionPings +
                ", turretKills=" + turretKills +
                ", enemyVisionPings=" + enemyVisionPings +
                ", trueDamageTaken=" + trueDamageTaken +
                ", assists=" + assists +
                ", itemsPurchased=" + itemsPurchased +
                ", objectivesStolenAssists=" + objectivesStolenAssists +
                ", damageDealtToTurrets=" + damageDealtToTurrets +
                ", totalHeal=" + totalHeal +
                ", visionClearedPings=" + visionClearedPings +
                ", physicalDamageDealt=" + physicalDamageDealt +
                ", trueDamageDealtToChampions=" + trueDamageDealtToChampions +
                ", dragonKills=" + dragonKills +
                ", baronKills=" + baronKills +
                ", doubleKills=" + doubleKills +
                ", nexusKills=" + nexusKills +
                ", trueDamageDealt=" + trueDamageDealt +
                ", spell1Casts=" + spell1Casts +
                ", teamId=" + teamId +
                ", dangerPings=" + dangerPings +
                ", spell4Casts=" + spell4Casts +
                ", teamEarlySurrendered=" + teamEarlySurrendered +
                ", eligibleForProgression=" + eligibleForProgression +
                ", firstTowerAssist=" + firstTowerAssist +
                ", firstBloodAssist=" + firstBloodAssist +
                ", gameEndedInEarlySurrender=" + gameEndedInEarlySurrender +
                ", firstBloodKill=" + firstBloodKill +
                ", gameEndedInSurrender=" + gameEndedInSurrender +
                ", firstTowerKill=" + firstTowerKill +
                ", win=" + win +
                ", riotIdName='" + riotIdName + '\'' +
                ", role='" + role + '\'' +
                ", championName='" + championName + '\'' +
                ", riotIdTagline='" + riotIdTagline + '\'' +
                ", summonerName='" + summonerName + '\'' +
                ", puuid='" + puuid + '\'' +
                ", summonerId='" + summonerId + '\'' +
                ", teamPosition='" + teamPosition + '\'' +
                ", individualPosition='" + individualPosition + '\'' +
                ", lane='" + lane + '\'' +
                ", perks=" + perks +
                '}';
    }
}
