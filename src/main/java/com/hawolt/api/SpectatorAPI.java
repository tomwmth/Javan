package com.hawolt.api;

import com.hawolt.Javan;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.PlatformRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.spectator.v4.CurrentGameInfo;
import com.hawolt.dto.spectator.v4.FeaturedGames;
import com.hawolt.dto.summoner.v4.SummonerDto;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.http.HttpRequest;
import com.hawolt.http.HttpResponse;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Wrapper for /lol/spectator/v4
 **/

public class SpectatorAPI {
    public static CurrentGameInfo getActiveGameInfo(Platform platform, SummonerDto summoner) throws DataNotFoundException, IOException {
        return getActiveGameInfo(platform, summoner.getId());
    }

    public static CurrentGameInfo getActiveGameInfo(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "spectator", "v4", "active-games", "by-summoner", summonerId)
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new CurrentGameInfo(response.body());
        }
    }

    public static FeaturedGames getFeaturedGames(Platform platform) throws IOException, DataNotFoundException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "spectator", "v4", "featured-games")
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new FeaturedGames(response.body());
        }
    }
}
