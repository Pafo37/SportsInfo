package com.pavelkovachev.sportsinfo.network.response.leaguedetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pavelkovachev.sportsinfo.network.response.leagues.LeaguesResponse;

import java.util.List;

public class LeagueDetailsListResponse {

    @SerializedName("leagues")
    private List<LeaguesResponse> leagues = null;

    public List<LeaguesResponse> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<LeaguesResponse> leagues) {
        this.leagues = leagues;
    }
}