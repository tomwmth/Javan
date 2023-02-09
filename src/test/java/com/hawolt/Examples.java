package com.hawolt;

import com.hawolt.api.*;
import com.hawolt.data.api.QueueType;
import com.hawolt.data.routing.Platform;
import com.hawolt.dto.league.v4.LeagueItemDTO;
import com.hawolt.dto.league.v4.LeagueListDTO;
import com.hawolt.dto.match.v5.match.MatchDto;
import com.hawolt.dto.summoner.v4.SummonerDto;
import com.hawolt.exceptions.DataNotFoundException;

import java.io.IOException;
import java.util.List;

public class Examples {

    public static void main(String[] args) throws DataNotFoundException, IOException {
        Javan.setRiotAPIKey(args[0]);
        SummonerDto summoner = SummonerAPI.getSummonerByName(Platform.EUW1, "Agurin");
        System.out.println(summoner);
        List<String> list = MatchAPI.getMatchListByPUUID(Platform.EUW1, summoner.getPUUID());
        if (!list.isEmpty()) {
            MatchDto match = MatchAPI.getMatch(list.get(0));
            System.out.println(match);
        }
        LeagueListDTO apex = LeagueAPI.getChallengerLeagues(Platform.EUW1, QueueType.RANKED_SOLO_5x5);
        List<LeagueItemDTO> challengers = apex.getEntries();
        System.out.println(challengers.get(0));
        LeagueItemDTO alpha = challengers.get(challengers.size() - 1);
        System.out.println(MasteryAPI.getPlayerTotalMasteryScore(Platform.EUW1, alpha.getSummonerId()));
        System.out.println(SpectatorAPI.getFeaturedGames(Platform.EUW1));
        System.out.println(ClashAPI.getTournaments(Platform.EUW1));
        System.out.println(ChampionAPI.getChampionRotations(Platform.EUW1));
    }
}
