package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: 08/02/2023 11:26
 * Author: Twitter @hawolt
 **/

public class FeaturedGameInfo {
    private final long gameId, gameStartTime;
    private final Observer observer;
    private final String gameType, platformId, gameMode;
    private final List<BannedChampion> bannedChampions;
    private final List<Participant> participants;
    private final int mapId, gameLength, gameQueueConfigId;

    public FeaturedGameInfo(JSONObject info) {
        this.gameId = info.getLong("gameId");
        this.gameStartTime = info.getLong("gameStartTime");
        this.observer = new Observer(info.getJSONObject("observers"));
        this.gameType = info.getString("gameType");
        this.platformId = info.getString("platformId");
        this.gameMode = info.getString("gameMode");
        this.bannedChampions = info.getJSONArray("bannedChampions")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(BannedChampion::new)
                .collect(Collectors.toList());
        this.participants = info.getJSONArray("participants")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(Participant::new)
                .collect(Collectors.toList());
        this.mapId = info.getInt("mapId");
        this.gameLength = info.getInt("gameLength");
        this.gameQueueConfigId = info.getInt("gameQueueConfigId");
    }

    public long getGameId() {
        return gameId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public Observer getObserver() {
        return observer;
    }

    public String getGameType() {
        return gameType;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public int getMapId() {
        return mapId;
    }

    public int getGameLength() {
        return gameLength;
    }

    public int getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    @Override
    public String toString() {
        return "FeaturedGameInfo{" +
                "gameId=" + gameId +
                ", gameStartTime=" + gameStartTime +
                ", observer=" + observer +
                ", gameType='" + gameType + '\'' +
                ", platformId='" + platformId + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", bannedChampions=" + bannedChampions +
                ", participants=" + participants +
                ", mapId=" + mapId +
                ", gameLength=" + gameLength +
                ", gameQueueConfigId=" + gameQueueConfigId +
                '}';
    }
}
