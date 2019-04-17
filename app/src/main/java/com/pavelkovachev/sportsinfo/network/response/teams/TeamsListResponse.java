package com.pavelkovachev.sportsinfo.network.response.teams;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamsListResponse {

    @SerializedName("teams")
    private List<TeamsResponse> teams = null;

    public List<TeamsResponse> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsResponse> teams) {
        this.teams = teams;
    }
}