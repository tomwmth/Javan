package com.hawolt;

import com.hawolt.api.*;
import com.hawolt.data.api.RankedDivision;
import com.hawolt.data.api.RankedQueue;
import com.hawolt.data.api.RankedTier;
import com.hawolt.data.routing.Platform;
import com.hawolt.data.routing.Region;
import com.hawolt.dto.champion.v3.ChampionInfo;
import com.hawolt.dto.clash.v1.PlayerDto;
import com.hawolt.dto.clash.v1.TournamentDto;
import com.hawolt.dto.clash.v1.TournamentTeamDto;
import com.hawolt.dto.league.v4.LeagueEntryDTO;
import com.hawolt.dto.league.v4.LeagueListDTO;
import com.hawolt.dto.mastery.v4.ChampionMasteryDto;
import com.hawolt.dto.match.v5.match.MatchDto;
import com.hawolt.dto.match.v5.timeline.MatchTimelineDto;
import com.hawolt.dto.spectator.v4.CurrentGameInfo;
import com.hawolt.dto.spectator.v4.FeaturedGames;
import com.hawolt.dto.summoner.v4.SummonerDto;
import com.hawolt.exceptions.DataNotFoundException;
import com.hawolt.exceptions.NoDefaultValueConfigured;
import com.hawolt.http.ratelimiter.RateLimitManager;
import com.hawolt.util.Paginator;

import java.io.IOException;
import java.util.List;

/**
 * Main starting point for integrating and using Javan
 **/

public class Javan {

    /**
     * Global manager for Rate Limits
     */
    public static RateLimitManager rateLimitManager = new RateLimitManager();

    private static String riotAPIKey;

    private static Platform defaultPlatform;
    private static Region defaultRegion;

    /**
     * @return Your set API key
     */
    public static String getRiotAPIKey() {
        return riotAPIKey;
    }

    /**
     * @param riotAPIKey Your API key for access
     */
    public static void setRiotAPIKey(String riotAPIKey) {
        Javan.riotAPIKey = riotAPIKey;
    }

    /**
     * @return Your default Platform
     */
    public static Platform getDefaultPlatform() {
        return defaultPlatform;
    }

    /**
     * @param defaultPlatform The default Platform to use for requests
     */
    public static void setDefaultPlatform(Platform defaultPlatform) {
        Javan.defaultPlatform = defaultPlatform;
    }

    /**
     * @return Your default Region
     */
    public static Region getDefaultRegion() {
        return defaultRegion;
    }

    /**
     * @param defaultRegion The default Region to use for requests
     */
    public static void setDefaultRegion(Region defaultRegion) {
        Javan.defaultRegion = defaultRegion;
    }

    /**
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static ChampionInfo getChampionRotations() throws DataNotFoundException, IOException {
        if (defaultPlatform == null) throw new NoDefaultValueConfigured();
        return ChampionAPI.getChampionRotations(defaultPlatform);
    }

    /**
     * @param platform Platform to request data from
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static ChampionInfo getChampionRotations(Platform platform) throws DataNotFoundException, IOException {
        return ChampionAPI.getChampionRotations(platform);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<PlayerDto> getActiveClashPlayers(String summonerId) throws DataNotFoundException, IOException {
        return getActiveClashPlayers(defaultPlatform, summonerId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<PlayerDto> getActiveClashPlayers(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        return ClashAPI.getActiveClashPlayers(platform, summonerId);
    }

    /**
     * @param teamId ID of the Team you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static TournamentTeamDto getTeamById(String teamId) throws DataNotFoundException, IOException {
        return getTeamById(defaultPlatform, teamId);
    }

    /**
     * @param platform Platform to request data from
     * @param teamId   ID of the Team you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static TournamentTeamDto getTeamById(Platform platform, String teamId) throws DataNotFoundException, IOException {
        return ClashAPI.getTeamById(platform, teamId);
    }

    /**
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<TournamentDto> getTournaments() throws DataNotFoundException, IOException {
        return getTournaments(defaultPlatform);
    }

    /**
     * @param platform Platform to request data from
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<TournamentDto> getTournaments(Platform platform) throws DataNotFoundException, IOException {
        return ClashAPI.getTournaments(platform);
    }

    /**
     * @param teamId ID of the Team you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static TournamentDto getTournamentByTeamId(String teamId) throws DataNotFoundException, IOException {
        return getTournamentByTeamId(defaultPlatform, teamId);
    }

    /**
     * @param platform Platform to request data from
     * @param teamId   ID of the Team you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static TournamentDto getTournamentByTeamId(Platform platform, String teamId) throws DataNotFoundException, IOException {
        return ClashAPI.getTournamentByTeamId(platform, teamId);
    }

    /**
     * @param tournamentId ID of the Tournament you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static TournamentDto getTournamentByTournamentId(String tournamentId) throws DataNotFoundException, IOException {
        return getTournamentByTournamentId(getDefaultPlatform(), tournamentId);
    }

    /**
     * @param platform     Platform to request data from
     * @param tournamentId ID of the Tournament you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static TournamentDto getTournamentByTournamentId(Platform platform, String tournamentId) throws DataNotFoundException, IOException {
        return ClashAPI.getTournamentByTournamentId(platform, tournamentId);
    }

    /**
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getChallengerLeagues(RankedQueue queueType) throws DataNotFoundException, IOException {
        return getChallengerLeagues(defaultPlatform, queueType);
    }

    /**
     * @param platform  Platform to request data from
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getChallengerLeagues(Platform platform, RankedQueue queueType) throws DataNotFoundException, IOException {
        return LeagueAPI.getChallengerLeagues(platform, queueType);
    }

    /**
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getGrandmasterLeague(RankedQueue queueType) throws DataNotFoundException, IOException {
        return getGrandmasterLeague(defaultPlatform, queueType);
    }

    /**
     * @param platform  Platform to request data from
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getGrandmasterLeague(Platform platform, RankedQueue queueType) throws DataNotFoundException, IOException {
        return LeagueAPI.getGrandmasterLeague(platform, queueType);
    }

    /**
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getMasterLeague(RankedQueue queueType) throws DataNotFoundException, IOException {
        return getMasterLeague(defaultPlatform, queueType);
    }

    /**
     * @param platform  Platform to request data from
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getMasterLeague(Platform platform, RankedQueue queueType) throws DataNotFoundException, IOException {
        return LeagueAPI.getMasterLeague(platform, queueType);
    }

    /**
     * @param leagueUUID UUID of the league you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getLeagueListByLeagueId(String leagueUUID) throws DataNotFoundException, IOException {
        return getLeagueListByLeagueId(defaultPlatform, leagueUUID);
    }

    /**
     * @param platform   Platform to request data from
     * @param leagueUUID UUID of the league you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static LeagueListDTO getLeagueListByLeagueId(Platform platform, String leagueUUID) throws DataNotFoundException, IOException {
        return LeagueAPI.getLeagueListByLeagueId(platform, leagueUUID);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<LeagueEntryDTO> getLeagueEntriesForSummoner(String summonerId) throws DataNotFoundException, IOException {
        return getLeagueEntriesForSummoner(defaultPlatform, summonerId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<LeagueEntryDTO> getLeagueEntriesForSummoner(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        return LeagueAPI.getLeagueEntriesForSummoner(platform, summonerId);
    }

    /**
     * @param division  Division you want to request data for
     * @param tier      Tier you want to request data for
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<LeagueEntryDTO> getAllLeagueEntries(RankedDivision division, RankedTier tier, RankedQueue queueType) throws DataNotFoundException, IOException {
        return getAllLeagueEntries(defaultPlatform, division, tier, queueType);
    }

    /**
     * @param platform  Platform to request data from
     * @param division  Division you want to request data for
     * @param tier      Tier you want to request data for
     * @param queueType Type of queue you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<LeagueEntryDTO> getAllLeagueEntries(Platform platform, RankedDivision division, RankedTier tier, RankedQueue queueType) throws DataNotFoundException, IOException {
        return LeagueAPI.getAllLeagueEntries(platform, division, tier, queueType);
    }

    /**
     * @param division  Division you want to request data for
     * @param tier      Tier you want to request data for
     * @param queueType Type of queue you want to request data for
     * @param page      Page you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<LeagueEntryDTO> getAllLeagueEntries(RankedDivision division, RankedTier tier, RankedQueue queueType, Object page) throws DataNotFoundException, IOException {
        return getAllLeagueEntries(defaultPlatform, division, tier, queueType, page);
    }

    /**
     * @param platform  Platform to request data from
     * @param division  Division you want to request data for
     * @param tier      Tier you want to request data for
     * @param queueType Type of queue you want to request data for
     * @param page      Page you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<LeagueEntryDTO> getAllLeagueEntries(Platform platform, RankedDivision division, RankedTier tier, RankedQueue queueType, Object page) throws DataNotFoundException, IOException {
        return LeagueAPI.getAllLeagueEntries(platform, division, tier, queueType, page);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */

    public static int getPlayerTotalMasteryScore(String summonerId) throws DataNotFoundException, IOException {
        return getPlayerTotalMasteryScore(defaultPlatform, summonerId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static int getPlayerTotalMasteryScore(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        return MasteryAPI.getPlayerTotalMasteryScore(platform, summonerId);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @param championId ID of the Champion you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static ChampionMasteryDto getPlayerMasteryScoreForChampion(String summonerId, Object championId) throws DataNotFoundException, IOException {
        return getPlayerMasteryScoreForChampion(defaultPlatform, summonerId, championId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @param championId ID of the Champion you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static ChampionMasteryDto getPlayerMasteryScoreForChampion(Platform platform, String summonerId, Object championId) throws DataNotFoundException, IOException {
        return MasteryAPI.getPlayerMasteryScoreForChampion(platform, summonerId, championId);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<ChampionMasteryDto> getPlayerTopMasteryScores(String summonerId) throws DataNotFoundException, IOException {
        return getPlayerTopMasteryScores(defaultPlatform, summonerId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<ChampionMasteryDto> getPlayerTopMasteryScores(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        return MasteryAPI.getPlayerTopMasteryScores(platform, summonerId);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @param count      Amount of Champions to include
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<ChampionMasteryDto> getPlayerTopMasteryScores(String summonerId, Object count) throws DataNotFoundException, IOException {
        return getPlayerTopMasteryScores(defaultPlatform, summonerId, count);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @param count      Amount of Champions to include
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<ChampionMasteryDto> getPlayerTopMasteryScores(Platform platform, String summonerId, Object count) throws DataNotFoundException, IOException {
        return MasteryAPI.getPlayerTopMasteryScores(platform, summonerId, count);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<ChampionMasteryDto> getPlayerMasteryScores(String summonerId) throws DataNotFoundException, IOException {
        return getPlayerMasteryScores(defaultPlatform, summonerId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<ChampionMasteryDto> getPlayerMasteryScores(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        return MasteryAPI.getPlayerMasteryScores(platform, summonerId);
    }

    /**
     * @param puuid PUUID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<String> getMatchListByPUUID(String puuid) throws DataNotFoundException, IOException {
        return getMatchListByPUUID(defaultPlatform, puuid);
    }

    /**
     * @param platform Platform to request data from
     * @param puuid    PUUID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<String> getMatchListByPUUID(Platform platform, String puuid) throws DataNotFoundException, IOException {
        return MatchAPI.getMatchListByPUUID(platform, puuid);
    }

    /**
     * @param platform Platform to request data from
     * @param puuid    PUUID you want to request data for
     * @param query    MatchAPI.MatchQuery to request only data matching the query
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static List<String> getMatchListByPUUID(Platform platform, String puuid, MatchAPI.Query query) throws DataNotFoundException, IOException {
        return MatchAPI.getMatchListByPUUID(platform, puuid, query);
    }

    /**
     * @param platform Platform to request data from
     * @param puuid    PUUID you want to request data for
     * @return Paginated Wrapper for the specified Resource as described on the official Riot API documentation
     */
    public static Paginator<String> getPaginatedMatchListByPUUID(Platform platform, String puuid) {
        return MatchAPI.getPaginatedMatchListByPUUID(platform, puuid);
    }

    /**
     * @param platform Platform to request data from
     * @param puuid    PUUID you want to request data for
     * @param query    MatchAPI.MatchQuery to request only data matching the query
     * @return Paginated Wrapper for the specified Resource as described on the official Riot API documentation
     */
    public static Paginator<String> getPaginatedMatchListByPUUID(Platform platform, String puuid, MatchAPI.Query query) {
        return MatchAPI.getPaginatedMatchListByPUUID(platform, puuid, query);
    }

    /**
     * @param matchId MatchID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static MatchDto getMatch(long matchId) throws DataNotFoundException, IOException {
        return getMatch(defaultPlatform, matchId);
    }

    /**
     * @param platform Platform to request data from
     * @param matchId  MatchID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static MatchDto getMatch(Platform platform, long matchId) throws DataNotFoundException, IOException {
        return getMatch(String.join("_", platform.name(), String.valueOf(matchId)));
    }

    /**
     * @param matchId MatchID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static MatchDto getMatch(String matchId) throws DataNotFoundException, IOException {
        return MatchAPI.getMatch(matchId);
    }

    /**
     * @param matchId MatchID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static MatchTimelineDto getMatchTimeline(long matchId) throws DataNotFoundException, IOException {
        return getMatchTimeline(defaultPlatform, matchId);
    }

    /**
     * @param platform Platform to request data from
     * @param matchId  MatchID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static MatchTimelineDto getMatchTimeline(Platform platform, long matchId) throws DataNotFoundException, IOException {
        return getMatchTimeline(String.join("_", platform.name(), String.valueOf(matchId)));
    }

    /**
     * @param matchId MatchID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static MatchTimelineDto getMatchTimeline(String matchId) throws DataNotFoundException, IOException {
        return MatchAPI.getMatchTimeline(matchId);
    }

    /**
     * @param summoner Summoner you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static CurrentGameInfo getActiveGameInfo(SummonerDto summoner) throws DataNotFoundException, IOException {
        return getActiveGameInfo(defaultPlatform, summoner);
    }

    /**
     * @param platform Platform to request data from
     * @param summoner Summoner you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static CurrentGameInfo getActiveGameInfo(Platform platform, SummonerDto summoner) throws DataNotFoundException, IOException {
        return SpectatorAPI.getActiveGameInfo(platform, summoner);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static CurrentGameInfo getActiveGameInfo(String summonerId) throws DataNotFoundException, IOException {
        return getActiveGameInfo(defaultPlatform, summonerId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     * @throws IOException
     */
    public static CurrentGameInfo getActiveGameInfo(Platform platform, String summonerId) throws DataNotFoundException, IOException {
        return SpectatorAPI.getActiveGameInfo(platform, summonerId);
    }

    /**
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static FeaturedGames getFeaturedGames() throws IOException, DataNotFoundException {
        return getFeaturedGames(defaultPlatform);
    }

    /**
     * @param platform Platform to request data from
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static FeaturedGames getFeaturedGames(Platform platform) throws IOException, DataNotFoundException {
        return SpectatorAPI.getFeaturedGames(platform);
    }

    /**
     * @param name Name of the player you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByName(String name) throws IOException, DataNotFoundException {
        return getSummonerByName(defaultPlatform, name);
    }

    /**
     * @param platform Platform to request data from
     * @param name     Name of the player you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByName(Platform platform, String name) throws IOException, DataNotFoundException {
        return SummonerAPI.getSummonerByName(platform, name);
    }

    /**
     * @param puuid PUUID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByPUUID(String puuid) throws IOException, DataNotFoundException {
        return getSummonerByPUUID(defaultPlatform, puuid);
    }

    /**
     * @param platform Platform to request data from
     * @param puuid    PUUID you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByPUUID(Platform platform, String puuid) throws IOException, DataNotFoundException {
        return SummonerAPI.getSummonerByPUUID(platform, puuid);
    }

    /**
     * @param accountId ID of the account you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByAccountId(String accountId) throws IOException, DataNotFoundException {
        return getSummonerByAccountId(defaultPlatform, accountId);
    }

    public static SummonerDto getSummonerByAccountId(Platform platform, String accountId) throws IOException, DataNotFoundException {
        return SummonerAPI.getSummonerByAccountId(platform, accountId);
    }

    /**
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerBySummonerId(String summonerId) throws IOException, DataNotFoundException {
        return getSummonerBySummonerId(defaultPlatform, summonerId);
    }

    /**
     * @param platform   Platform to request data from
     * @param summonerId ID of the Summoner you are requesting data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerBySummonerId(Platform platform, String summonerId) throws IOException, DataNotFoundException {
        return SummonerAPI.getSummonerBySummonerId(platform, summonerId);
    }

    /**
     * @param rsoPUUID RSOPUUID of the account you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByRSOPUUID(String rsoPUUID) throws IOException, DataNotFoundException {
        return getSummonerByRSOPUUID(defaultPlatform, rsoPUUID);
    }

    /**
     * @param platform Platform to request data from
     * @param rsoPUUID RSOPUUID of the account you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByRSOPUUID(Platform platform, String rsoPUUID) throws IOException, DataNotFoundException {
        return SummonerAPI.getSummonerByRSOPUUID(platform, rsoPUUID);
    }

    /**
     * @param token Bearer Token of the account you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByAccessToken(String token) throws IOException, DataNotFoundException {
        return getSummonerByAccessToken(defaultPlatform, token);
    }

    /**
     * @param platform Platform to request data from
     * @param token    Bearer Token of the account you want to request data for
     * @return Wrapper for the specified Resource as described on the official Riot API documentation
     * @throws IOException
     * @throws DataNotFoundException HTTP 404 causes this Exception to be thrown
     */
    public static SummonerDto getSummonerByAccessToken(Platform platform, String token) throws IOException, DataNotFoundException {
        return SummonerAPI.getSummonerByAccessToken(platform, token);
    }

}
