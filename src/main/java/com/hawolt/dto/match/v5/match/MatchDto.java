package com.hawolt.dto.match.v5.match;

import com.hawolt.dto.DataTransferObject;
import com.hawolt.dto.summoner.v4.SummonerDto;
import org.json.JSONObject;

import java.util.List;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class MatchDto extends DataTransferObject {
    private final MetadataDto metadataDto;
    private final InfoDto infoDto;

    public MatchDto(JSONObject body) {
        super(body);
        this.infoDto = new InfoDto(body.getJSONObject("info"));
        this.metadataDto = new MetadataDto(body.getJSONObject("metadata"));
    }

    public MetadataDto getMetadataDto() {
        return metadataDto;
    }

    public InfoDto getInfoDto() {
        return infoDto;
    }

    /**
     * Checks if the specified summoner was victorious in the match.
     *
     * @param puuid The PUUID representing the summoner.
     * @return {@code true} if the summoner was victorious, {@code false} otherwise.
     * @throws IllegalArgumentException if the player with the PUUID did not participate in the match
     */
    public boolean isVictorious(String puuid) {
        return getParticipantData(puuid).isWin();
    }

    /**
     * Checks if the specified summoner was victorious in the match.
     *
     * @param summoner The SummonerDto representing the summoner.
     * @return {@code true} if the summoner was victorious, {@code false} otherwise.
     * @throws IllegalArgumentException if the player with the PUUID did not participate in the match
     */
    public boolean isVictorious(SummonerDto summoner) {
        return isVictorious(summoner.getPUUID());
    }

    /**
     * Retrieves the participant data for the player with the specified PUUID in the match.
     *
     * @param puuid The PUUID of the player.
     * @return The ParticipantDto representing the player's data in the match.
     * @throws IllegalArgumentException if the player with the PUUID did not participate in the match
     */
    public ParticipantDto getParticipantData(String puuid) {
        return getInfoDto().getParticipants()
                .stream()
                .filter(participantDto -> puuid.equals(participantDto.getPUUID()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The player with the given PUUID did not participate in the match"));
    }
}
