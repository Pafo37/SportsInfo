package com.pavelkovachev.sportsinfo.network.response.leagues;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaguesListResponse {

    @SerializedName("leagues")
    private List<LeaguesResponse> leagues = null;

    public List<LeaguesResponse> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<LeaguesResponse> leagues) {
        this.leagues = leagues;
    }
}