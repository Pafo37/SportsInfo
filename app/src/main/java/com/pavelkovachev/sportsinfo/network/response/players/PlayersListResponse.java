package com.pavelkovachev.sportsinfo.network.response.players;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayersListResponse {

    @SerializedName("player")
    private List<PlayersResponse> players = null;

    public List<PlayersResponse> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayersResponse> players) {
        this.players = players;
    }
}