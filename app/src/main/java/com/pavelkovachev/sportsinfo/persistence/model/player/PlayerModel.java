package com.pavelkovachev.sportsinfo.persistence.model.player;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class PlayerModel {

    @NonNull
    @PrimaryKey
    private int playerId;

    @ColumnInfo(name = "player_name")
    private String playerName;

    @ColumnInfo(name = "player_nationality")
    private String playerNationality;

    @ColumnInfo(name = "player_team_name")
    private String playerTeamName;

    @ColumnInfo(name = "player_height")
    private String playerHeight;

    @ColumnInfo(name = "player_date_born")
    private String playerDateBorn;

    @ColumnInfo(name = "player_birthplace")
    private String playerBirthplace;

    @ColumnInfo(name = "player_description")
    private String playerDescription;

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerNationality() {
        return playerNationality;
    }

    public String getPlayerTeamName() {
        return playerTeamName;
    }

    public String getPlayerHeight() {
        return playerHeight;
    }

    public String getPlayerDateBorn() {
        return playerDateBorn;
    }

    public String getPlayerBirthplace() {
        return playerBirthplace;
    }

    public String getPlayerDescription() {
        return playerDescription;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerNationality(String playerNationality) {
        this.playerNationality = playerNationality;
    }

    public void setPlayerTeamName(String playerTeamName) {
        this.playerTeamName = playerTeamName;
    }

    public void setPlayerHeight(String playerHeight) {
        this.playerHeight = playerHeight;
    }

    public void setPlayerDateBorn(String playerDateBorn) {
        this.playerDateBorn = playerDateBorn;
    }

    public void setPlayerBirthplace(String playerBirthplace) {
        this.playerBirthplace = playerBirthplace;
    }

    public void setPlayerDescription(String playerDescription) {
        this.playerDescription = playerDescription;
    }
}