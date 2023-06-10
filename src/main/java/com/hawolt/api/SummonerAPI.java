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

    private static SummonerDto getSummoner(Platform platform, HttpRequest.Builder builder) throws IOException, DataNotFoundException {
        HttpRequest request = builder.get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new SummonerDto(platform, response.body());
        }
    }

    private static SummonerDto getSummoner(Platform platform, String value, String... path) throws IOException, DataNotFoundException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest.Builder builder = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path(path)
                .path(value, false);
        return getSummoner(platform, builder);
    }

    public static SummonerDto getSummonerByName(Platform platform, String name) throws IOException, DataNotFoundException {
        return getSummoner(platform, URLEncoder.encode(name, "UTF-8"), "lol", "summoner", "v4", "summoners", "by-name");
    }

    public static SummonerDto getSummonerByPUUID(Platform platform, String puuid) throws IOException, DataNotFoundException {
        return getSummoner(platform, puuid, "lol", "summoner", "v4", "summoners", "by-puuid");
    }

    public static SummonerDto getSummonerByAccountId(Platform platform, String accountId) throws IOException, DataNotFoundException {
        return getSummoner(platform, accountId, "lol", "summoner", "v4", "summoners", "by-account");
    }

    public static SummonerDto getSummonerBySummonerId(Platform platform, String summonerId) throws IOException, DataNotFoundException {
        return getSummoner(platform, summonerId, "lol", "summoner", "v4", "summoners");
    }

    public static SummonerDto getSummonerByRSOPUUID(Platform platform, String rsoPUUID) throws IOException, DataNotFoundException {
        return getSummoner(platform, rsoPUUID, "fulfillment", "v1", "summoners", "by-puuid");
    }

    public static SummonerDto getSummonerByAccessToken(Platform platform, String token) throws IOException, DataNotFoundException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest.Builder builder = new HttpRequest.Builder(Javan.rateLimitManager)
                .addHeader("Authorization", "Bearer " + token)
                .protocol("https")
                .host(route)
                .path("lol", "summoner", "v4", "me");
        return getSummoner(platform, builder);
    }
}
