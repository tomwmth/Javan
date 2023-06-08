package com.hawolt.dto.summoner.v4;

import com.hawolt.data.routing.Platform;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class SummonerDto {
    private final Platform platform;
    private final Long revisionDate;
    private final String accountId, name, puuid, id;
    private final int profileIconId, summonerLevel;

    public SummonerDto(Platform platform, JSONObject summoner) {
        this.platform = platform;
        this.revisionDate = summoner.getLong("revisionDate");
        this.accountId = summoner.getString("accountId");
        this.name = summoner.getString("name");
        this.puuid = summoner.getString("puuid");
        this.id = summoner.getString("id");
        this.profileIconId = summoner.getInt("profileIconId");
        this.summonerLevel = summoner.getInt("summonerLevel");
    }

    public Platform getPlatform() {
        return platform;
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
