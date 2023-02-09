package com.hawolt.dto.clash.v1;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class TournamentPhaseDto {
    private final int id;
    private final long registrationTime, startTime;
    private final boolean cancelled;

    public TournamentPhaseDto(JSONObject phase) {
        this.id = phase.getInt("id");
        this.registrationTime = phase.getLong("registrationTime");
        this.startTime = phase.getLong("startTime");
        this.cancelled = phase.getBoolean("cancelled");
    }

    public int getId() {
        return id;
    }

    public long getRegistrationTime() {
        return registrationTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "TournamentPhaseDto{" +
                "id=" + id +
                ", registrationTime=" + registrationTime +
                ", startTime=" + startTime +
                ", cancelled=" + cancelled +
                '}';
    }
}
