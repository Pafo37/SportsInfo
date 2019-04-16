package com.pavelkovachev.sportsinfo.persistence.model.league;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class LeagueModel {

    @NonNull
    @PrimaryKey
    private int leagueId;

    @ColumnInfo(name = "league_name")
    private String leagueName;

    @ColumnInfo(name = "league_sport")
    private String leagueSport;

    public LeagueModel(int leagueId, String leagueName, String leagueSport) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.leagueSport = leagueSport;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getLeagueSport() {
        return leagueSport;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setLeagueSport(String leagueSport) {
        this.leagueSport = leagueSport;
    }
}