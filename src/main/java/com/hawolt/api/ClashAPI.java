package com.hawolt.api;

import com.hawolt.Kassadin;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.PlatformRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.clash.v1.PlayerDto;
import com.hawolt.dto.clash.v1.TeamDto;
import com.hawolt.dto.clash.v1.TournamentDto;
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

public class ClashAPI {
    public static List<PlayerDto> getActiveClashPlayers(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Kassadin.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "clash", "v1", "players", "by-summoner", summonerId)
                .get();
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(o -> (HashMap<?, ?>) o)
                    .map(JSONObject::new)
                    .map(PlayerDto::new)
                    .collect(Collectors.toList());
        }
    }

    public static TeamDto getTeamById(Platform platform, String teamId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Kassadin.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "clash", "v1", "teams", teamId)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new TeamDto(response.body());
        }
    }

    public static List<TournamentDto> getTournaments(Platform platform) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Kassadin.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "clash", "v1", "tournaments")
                .get();
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(o -> (HashMap<?, ?>) o)
                    .map(JSONObject::new)
                    .map(TournamentDto::new)
                    .collect(Collectors.toList());
        }
    }

    public static TournamentDto getTournamentByTeamId(Platform platform, String teamId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Kassadin.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "clash", "v1", "tournaments", "by-team", teamId)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new TournamentDto(response.body());
        }
    }

    public static TournamentDto getTournamentByTournamentId(Platform platform, String tournamentId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Kassadin.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "clash", "v1", "tournaments", tournamentId)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new TournamentDto(response.body());
        }
    }
}
