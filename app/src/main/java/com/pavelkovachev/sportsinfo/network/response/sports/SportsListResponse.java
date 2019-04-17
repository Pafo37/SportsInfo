package com.pavelkovachev.sportsinfo.network.response.sports;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SportsListResponse {

    @SerializedName("sports")
    private List<SportsResponse> sports = null;

    public List<SportsResponse> getSports() {
        return sports;
    }

    public void setSports(List<SportsResponse> sports) {
        this.sports = sports;
    }
}