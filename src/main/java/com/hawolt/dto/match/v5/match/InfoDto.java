package com.hawolt.dto.match.v5.match;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class InfoDto {
    private final long gameId, gameEndTimestamp, gameStartTimestamp, gameCreation;
    private final String gameType, platformId, gameName, tournamentCode, gameVersion, gameMode;
    private final int queueId, gameDuration, mapId;
    private final List<ParticipantDto> participants;
    private final List<TeamDto> teams;

    public InfoDto(JSONObject info) {
        this.gameId = info.getLong("gameId");
        this.gameType = info.getString("gameType");
        this.queueId = info.getInt("queueId");
        this.gameDuration = info.getInt("gameDuration");
        this.teams = info.getJSONArray("teams")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(TeamDto::new)
                .collect(Collectors.toList());
        this.gameEndTimestamp = info.getLong("gameEndTimestamp");
        this.gameStartTimestamp = info.getLong("gameStartTimestamp");
        this.platformId = info.getString("platformId");
        this.gameCreation = info.getLong("gameCreation");
        this.gameName = info.getString("gameName");
        this.tournamentCode = info.getString("tournamentCode");
        this.gameVersion = info.getString("gameVersion");
        this.mapId = info.getInt("mapId");
        this.gameMode = info.getString("gameMode");
        this.participants = info.getJSONArray("participants")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(ParticipantDto::new)
                .collect(Collectors.toList());
    }

    public long getGameId() {
        return gameId;
    }

    public long getGameEndTimestamp() {
        return gameEndTimestamp;
    }

    public long getGameStartTimestamp() {
        return gameStartTimestamp;
    }

    public long getGameCreation() {
        return gameCreation;
    }

    public String getGameType() {
        return gameType;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getTournamentCode() {
        return tournamentCode;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public String getGameMode() {
        return gameMode;
    }

    public int getQueueId() {
        return queueId;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public int getMapId() {
        return mapId;
    }

    public List<ParticipantDto> getParticipants() {
        return participants;
    }

    public List<TeamDto> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        return "InfoDto{" +
                "gameId=" + gameId +
                ", gameEndTimestamp=" + gameEndTimestamp +
                ", gameStartTimestamp=" + gameStartTimestamp +
                ", gameCreation=" + gameCreation +
                ", gameType='" + gameType + '\'' +
                ", platformId='" + platformId + '\'' +
                ", gameName='" + gameName + '\'' +
                ", tournamentCode='" + tournamentCode + '\'' +
                ", gameVersion='" + gameVersion + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", queueId=" + queueId +
                ", gameDuration=" + gameDuration +
                ", mapId=" + mapId +
                ", participants=" + participants +
                ", teams=" + teams +
                '}';
    }
}
