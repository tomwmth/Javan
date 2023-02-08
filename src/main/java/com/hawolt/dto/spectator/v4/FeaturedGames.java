package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: 08/02/2023 11:25
 * Author: Twitter @hawolt
 **/

public class FeaturedGames {
    private final List<FeaturedGameInfo> gameList;
    private final int clientRefreshInterval;

    public FeaturedGames(JSONObject game) {
        this.clientRefreshInterval = game.getInt("clientRefreshInterval");
        this.gameList = game.getJSONArray("gameList")
                .toList()
                .stream()
                .map(o -> (HashMap<?, ?>) o)
                .map(JSONObject::new)
                .map(FeaturedGameInfo::new)
                .collect(Collectors.toList());
    }

    public List<FeaturedGameInfo> getGameList() {
        return gameList;
    }

    public int getClientRefreshInterval() {
        return clientRefreshInterval;
    }

    @Override
    public String toString() {
        return "FeaturedGames{" +
                "gameList=" + gameList +
                ", clientRefreshInterval=" + clientRefreshInterval +
                '}';
    }
}