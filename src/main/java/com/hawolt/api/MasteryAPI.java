package com.hawolt.api;

import com.hawolt.Javan;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.PlatformRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.mastery.v4.ChampionMasteryDto;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.http.HttpRequest;
import com.hawolt.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: 07/02/2023 12:40
 * Author: Twitter @hawolt
 **/

public class MasteryAPI {
    public static int getPlayerTotalMasteryScore(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "champion-mastery", "v4", "scores", "by-summoner", summonerId)
                .get();
        try (HttpResponse<String> response = request.getAsString()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return Integer.parseInt(response.body());
        }
    }

    public static ChampionMasteryDto getPlayerMasteryScoreForChampion(Platform platform, String summonerId, Object championId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "champion-mastery", "v4", "champion-masteries", "by-summoner", summonerId, "by-champion", championId)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new ChampionMasteryDto(response.body());
        }
    }

    public static List<ChampionMasteryDto> getPlayerTopMasteryScores(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        return getPlayerTopMasteryScores(platform, summonerId, 3);
    }

    public static List<ChampionMasteryDto> getPlayerTopMasteryScores(Platform platform, String summonerId, Object count) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "champion-mastery", "v4", "champion-masteries", "by-summoner", summonerId, "top")
                .addQueryParameter("count", count)
                .get();
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(o -> (HashMap<?, ?>) o)
                    .map(JSONObject::new)
                    .map(ChampionMasteryDto::new)
                    .collect(Collectors.toList());
        }
    }

    public static List<ChampionMasteryDto> getPlayerMasteryScores(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "champion-mastery", "v4", "champion-masteries", "by-summoner", summonerId)
                .get();
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(o -> (HashMap<?, ?>) o)
                    .map(JSONObject::new)
                    .map(ChampionMasteryDto::new)
                    .collect(Collectors.toList());
        }
    }
}
