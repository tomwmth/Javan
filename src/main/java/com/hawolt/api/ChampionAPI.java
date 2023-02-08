package com.hawolt.api;

import com.hawolt.Kassadin;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.PlatformRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.champion.v3.ChampionInfo;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.http.HttpRequest;
import com.hawolt.http.HttpResponse;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created: 07/02/2023 12:40
 * Author: Twitter @hawolt
 **/

public class ChampionAPI {
    public static ChampionInfo getChampionRotations(Platform platform) throws DataNotFoundException, IOException {
        RoutingValue route = PlatformRouting.from(platform);
        HttpRequest request = new HttpRequest.Builder(Kassadin.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "platform", "v3", "champion-rotations")
                .get();
        try (HttpResponse<JSONObject> response = request.getAsJSONObject()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return new ChampionInfo(response.body());
        }
    }
}
