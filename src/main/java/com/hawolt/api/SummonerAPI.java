package com.hawolt.api;

import com.hawolt.Javan;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.PlatformRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.summoner.v4.SummonerDto;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.http.HttpRequest;
import com.hawolt.http.HttpResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Wrapper for /lol/summoner/v4
 **/

public class SummonerAPI {

    private static SummonerDto getSummoner(HttpRequest.Builder builder) throws IOException, DataNotFoundException {
        HttpRequest request = builder.get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new SummonerDto(response.body());
        }
    }

    private static SummonerDto getSummoner(Platform platform, String... path) throws IOException, DataNotFoundException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest.Builder builder = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path(path);
        return getSummoner(builder);
    }

    public static SummonerDto getSummonerByName(Platform platform, String name) throws IOException, DataNotFoundException {
        return getSummoner(platform, "lol", "summoner", "v4", "summoners", "by-name", URLEncoder.encode(name, "UTF-8"));
    }

    public static SummonerDto getSummonerByPUUID(Platform platform, String puuid) throws IOException, DataNotFoundException {
        return getSummoner(platform, "lol", "summoner", "v4", "summoners", "by-puuid", puuid);
    }

    public static SummonerDto getSummonerByAccountId(Platform platform, String accountId) throws IOException, DataNotFoundException {
        return getSummoner(platform, "lol", "summoner", "v4", "summoners", "by-account", accountId);
    }

    public static SummonerDto getSummonerBySummonerId(Platform platform, String summonerId) throws IOException, DataNotFoundException {
        return getSummoner(platform, "lol", "summoner", "v4", "summoners", summonerId);
    }

    public static SummonerDto getSummonerByRSOPUUID(Platform platform, String rsoPUUID) throws IOException, DataNotFoundException {
        return getSummoner(platform, "fulfillment", "v1", "summoners", "by-puuid", rsoPUUID);
    }

    public static SummonerDto getSummonerByAccessToken(Platform platform, String token) throws IOException, DataNotFoundException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest.Builder builder = new HttpRequest.Builder(Javan.rateLimitManager)
                .addHeader("Authorization", "Bearer " + token)
                .protocol("https")
                .host(route)
                .path("lol", "summoner", "v4", "me");
        return getSummoner(builder);
    }
}
