package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class CurrentGameInfo {
    private final long gameId, gameStartTime;
    private final List<BannedChampion> bannedChampions;
    private final List<CurrentGameParticipant> participants;
    private final Observer observers;
    private final String gameType, platformId, gameMode;
    private final int mapId, gameLength, gameQueueConfigId;

    public CurrentGameInfo(JSONObject game) {
        this.gameId = game.getLong("gameId");
        this.gameStartTime = game.getLong("gameStartTime");
        this.bannedChampions = game.getJSONArray("bannedChampions")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(BannedChampion::new)
                .collect(Collectors.toList());
        this.participants = game.getJSONArray("participants")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(CurrentGameParticipant::new)
                .collect(Collectors.toList());
        this.observers = new Observer(game.getJSONObject("observers"));
        this.gameType = game.getString("gameType");
        this.platformId = game.getString("platformId");
        this.gameMode = game.getString("gameMode");
        this.mapId = game.getInt("mapId");
        this.gameLength = game.getInt("gameLength");
        this.gameQueueConfigId = game.getInt("gameQueueConfigId");
    }

    public long getGameId() {
        return gameId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    public List<CurrentGameParticipant> getParticipants() {
        return participants;
    }

    public Observer getObservers() {
        return observers;
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
        return "CurrentGameInfo{" +
                "gameId=" + gameId +
                ", gameStartTime=" + gameStartTime +
                ", bannedChampions=" + bannedChampions +
                ", participants=" + participants +
                ", observers=" + observers +
                ", gameType='" + gameType + '\'' +
                ", platformId='" + platformId + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", mapId=" + mapId +
                ", gameLength=" + gameLength +
                ", gameQueueConfigId=" + gameQueueConfigId +
                '}';
    }
}
