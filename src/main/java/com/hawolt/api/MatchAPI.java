package com.hawolt.api;

import com.hawolt.Javan;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.RegionRouting;
import com.hawolt.data.routing.RoutingValue;
import com.hawolt.dto.match.v5.match.MatchDto;
import com.hawolt.dto.match.v5.timeline.MatchTimelineDto;
import com.hawolt.exceptions.BadQueryException;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.http.HttpRequest;
import com.hawolt.http.HttpResponse;
import com.hawolt.util.Paginator;
import com.hawolt.util.QueryStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Wrapper for /lol/match/v5
 **/

public class MatchAPI {
    public static class Query extends com.hawolt.util.Query {
        private static final QueryStructure structure = QueryStructure.builder()
                .addParameter("startTime", false)
                .addParameter("endTime", false)
                .addParameter("queue", false)
                .addParameter("start", false)
                .addParameter("count", false)
                .addParameter("type", false)
                .build();

        public static Query BLANK = new Query(Collections.emptyMap());

        public Query(Map<String, Object> parameters) {
            super(parameters);
        }

        public static Builder builder() {
            return new Builder();
        }

        public enum GameType {
            RANKED, NORMAL, TOURNEY, TUTORIAL;

            @Override
            public String toString() {
                return name().toLowerCase();
            }
        }

        public enum Queue {
            BB_5x5_NORMAL_ARAM(100),
            SR_5x5_NORMAL_DRAFT(400),
            SR_5x5_RANKED_SOLO(420),
            SR_5x5_NORMAL_BLIND(430),
            SR_5x5_RANKED_FLEX(440),
            HA_5x5_NORMAL_ARAM(450),
            SR_5x5_TOURNEY_CLASH(700),
            HA_5x5_TOURNEY_CLASH(720),
            SR_5x5_BOTS_INTRO(830),
            SR_5x5_BOTS_BEGINNER(840),
            SR_5x5_BOTS_INTERMEDIATE(850),
            SR_5x5_RGM_ARURF(900),
            HA_5x5_RGM_POROKING(920),
            SR_5x5_RGM_SPELLBOOK(1400),
            RW_2x2_RGM_ARENA(1700),
            SR_5x5_RGM_URF(1900),
            SR_TUTORIAL_ONE(2000),
            SR_TUTORIAL_TWO(2010),
            SR_TUTORIAL_THREE(2020);

            private final int id;

            Queue(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return String.valueOf(this.id);
            }
        }

        public static class Builder {
            private final Map<String, Object> parameters = new HashMap<>();

            public Builder setStartTime(long startTime) {
                this.parameters.put("startTime", startTime);
                return this;
            }

            public Builder setEndTime(long endTime) {
                this.parameters.put("endTime", endTime);
                return this;
            }

            public Builder setQueue(Queue queue) {
                this.parameters.put("queue", queue);
                return this;
            }

            public Builder setType(GameType type) {
                this.parameters.put("type", type.name());
                return this;
            }

            public Builder setStartIndex(int startIndex) {
                this.parameters.put("start", startIndex);
                return this;
            }

            public Builder setCount(int count) {
                this.parameters.put("count", count);
                return this;
            }

            public Query build() {
                return new Query(parameters);
            }
        }
    }

    private static HttpRequest getMatchListByPUUIDRequest(Platform platform, String puuid, Query query) {
        RoutingValue route = RegionRouting.from(platform.getRegion());
        HttpRequest.Builder builder = new HttpRequest.Builder(Javan.rateLimitManager)
                .protocol("https")
                .host(route)
                .path("lol", "match", "v5", "matches", "by-puuid")
                .path(puuid, false)
                .path("ids");
        Map<String, Object> parameters = query.getParameters();
        for (String parameter : parameters.keySet()) {
            builder.addQueryParameter(parameter, parameters.get(parameter));
        }
        HttpRequest request = builder.get();
        if (!Query.structure.isValid(request)) throw new BadQueryException(request.getQueryParameterMap());
        return request;
    }

    public static Paginator<String> getPaginatedMatchListByPUUID(Platform platform, String puuid, Query query) {
        return new Paginator<String>(
                getMatchListByPUUIDRequest(platform, puuid, query),
                string -> new JSONArray(string).toList()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.toList())
        ) {
            @Override
            public String getPaginatorOffsetKey() {
                return "start";
            }

            @Override
            public int getElementCount() {
                return Integer.parseInt(query.getParameters().getOrDefault("count", 20).toString());
            }
        };
    }

    public static Paginator<String> getPaginatedMatchListByPUUID(Platform platform, String puuid) {
        return getPaginatedMatchListByPUUID(platform, puuid, Query.BLANK);
    }

    public static List<String> getMatchListByPUUID(Platform platform, String puuid, Query query) throws DataNotFoundException, IOException {
        HttpRequest request = getMatchListByPUUIDRequest(platform, puuid, query);
        try (HttpResponse<JSONArray> response = request.getAsJSONArray()) {
            if (response.code() == 404) throw new DataNotFoundException(request.getUrl());
            return response.body()
                    .toList()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
        }
    }

    public static List<String> getMatchListByPUUID(Platform platform, String puuid) throws DataNotFoundException, IOException {
        return getMatchListByPUUID(platform, puuid, Query.BLANK);
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
