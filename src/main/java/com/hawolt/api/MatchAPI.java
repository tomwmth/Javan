package com.hawolt.api;

import com.hawolt.Javan;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.RegionRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.match.v5.match.MatchDto;
import com.hawolt.dto.match.v5.timeline.MatchTimelineDto;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.http.HttpRequest;
import com.hawolt.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for /lol/match/v5
 **/

public class MatchAPI {

    public static List<String> getMatchListByPUUID(Platform platform, String puuid) throws DataNotFoundException, IOException {
        RoutingValue route = RegionRouting.from(platform.getRegion());
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "match", "v5", "matches", "by-puuid")
                .path(puuid, false)
                .path("ids")
                .get();
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
        }
    }

    public static MatchDto getMatch(Platform platform, long matchId) throws DataNotFoundException, IOException {
        RoutingValue route = RegionRouting.from(platform.getRegion());
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "match", "v5", "matches")
                .path(String.format("%s_%s", platform.name(), matchId), false)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new MatchDto(response.body());
        }
    }

    public static MatchDto getMatch(String matchId) throws DataNotFoundException, IOException {
        String[] data = matchId.split("_");
        Platform platform = Platform.valueOf(data[0]);
        long gameId = Long.parseLong(data[1]);
        return getMatch(platform, gameId);
    }

    public static MatchTimelineDto getMatchTimeline(Platform platform, long matchId) throws DataNotFoundException, IOException {
        RoutingValue route = RegionRouting.from(platform.getRegion());
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "match", "v5", "matches")
                .path(String.format("%s_%s", platform.name(), matchId), false)
                .path("timeline")
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new MatchTimelineDto(response.body());
        }
    }

    public static MatchTimelineDto getMatchTimeline(String matchId) throws DataNotFoundException, IOException {
        String[] data = matchId.split("_");
        Platform platform = Platform.valueOf(data[0]);
        long gameId = Long.parseLong(data[1]);
        return getMatchTimeline(platform, gameId);
    }
}
