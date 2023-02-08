package com.hawolt.dto.summoner.v4;

import org.json.JSONObject;

/**
 * Created: 07/02/2023 22:28
 * Author: Twitter @hawolt
 **/

public class SummonerDto {
    private final Long revisionDate;
    private final String accountId, name, puuid, id;
    private final int profileIconId, summonerLevel;

    public SummonerDto(JSONObject summoner) {
        this.revisionDate = summoner.getLong("revisionDate");
        this.accountId = summoner.getString("accountId");
        this.name = summoner.getString("name");
        this.puuid = summoner.getString("puuid");
        this.id = summoner.getString("id");
        this.profileIconId = summoner.getInt("profileIconId");
        this.summonerLevel = summoner.getInt("summonerLevel");
    }

    public Long getRevisionDate() {
        return revisionDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getPUUID() {
        return puuid;
    }

    public String getId() {
        return id;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    @Override
    public String toString() {
        return "SummonerDto{" +
                "revisionDate=" + revisionDate +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", puuid='" + puuid + '\'' +
                ", id='" + id + '\'' +
                ", profileIconId=" + profileIconId +
                ", summonerLevel=" + summonerLevel +
                '}';
    }
}
