package com.hawolt.api;

import com.hawolt.Javan;
import com.hawolt.data.api.Division;
import com.hawolt.data.api.QueueType;
import com.hawolt.data.api.Tier;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.PlatformRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.league.v4.LeagueEntryDTO;
import com.hawolt.dto.league.v4.LeagueListDTO;
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

public class LeagueAPI {
    private static LeagueListDTO getLeague(Platform platform, String... path) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path(path)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new LeagueListDTO(response.body());
        }
    }

    public static LeagueListDTO getChallengerLeagues(Platform platform, QueueType queueType) throws DataNotFoundException, IOException {
        return getLeague(platform, "lol", "league", "v4", "challengerleagues", "by-queue", queueType.name());
    }

    public static LeagueListDTO getGrandmasterLeague(Platform platform, QueueType queueType) throws DataNotFoundException, IOException {
        return getLeague(platform, "lol", "league", "v4", "grandmasterleagues", "by-queue", queueType.name());
    }

    public static LeagueListDTO getMasterLeague(Platform platform, QueueType queueType) throws DataNotFoundException, IOException {
        return getLeague(platform, "lol", "league", "v4", "masterleagues", "by-queue", queueType.name());
    }

    public static LeagueListDTO getLeagueListByLeagueId(Platform platform, String leagueUUID) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "league", "v4", "leagues", leagueUUID)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new LeagueListDTO(response.body());
        }
    }

    public static List<LeagueEntryDTO> getLeagueEntriesForSummoner(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "league", "v4", "entries", "by-summoner", summonerId)
                .get();
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(o -> (HashMap<?, ?>) o)
                    .map(JSONObject::new)
                    .map(LeagueEntryDTO::new)
                    .collect(Collectors.toList());
        }
    }

    public static List<LeagueEntryDTO> getAllLeagueEntries(Platform platform, Division division, Tier tier, QueueType queueType) throws DataNotFoundException, IOException {
        return getAllLeagueEntries(platform, division, tier, queueType, 1);
    }

    public static List<LeagueEntryDTO> getAllLeagueEntries(Platform platform, Division division, Tier tier, QueueType queueType, Object page) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "league", "v4", "entries", queueType, tier, division)
                .addQueryParameter("page", page)
                .get();
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(o -> (HashMap<?, ?>) o)
                    .map(JSONObject::new)
                    .map(LeagueEntryDTO::new)
                    .collect(Collectors.toList());
        }
    }
}
