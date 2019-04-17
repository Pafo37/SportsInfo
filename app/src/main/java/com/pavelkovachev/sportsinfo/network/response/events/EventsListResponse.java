package com.pavelkovachev.sportsinfo.network.response.events;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventsListResponse {

    @SerializedName("events")
    private List<EventsResponse> events = null;

    public List<EventsResponse> getEvents() {
        return events;
    }

    public void setEvents(List<EventsResponse> events) {
        this.events = events;
    }
}