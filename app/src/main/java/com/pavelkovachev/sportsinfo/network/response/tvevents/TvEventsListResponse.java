package com.pavelkovachev.sportsinfo.network.response.tvevents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvEventsListResponse {

    @SerializedName("tvevents")
    private List<TvEventsResponse> tvEvents = null;

    public List<TvEventsResponse> getTvEvents() {
        return tvEvents;
    }

    public void setTvevents(List<TvEventsResponse> tvEvents) {
        this.tvEvents = tvEvents;
    }
}