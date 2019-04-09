package com.pavelkovachev.sportsinfo.persistence.model.leagues;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class LeaguesModel {

    @NonNull
    @PrimaryKey
    private int leagueId;

    @ColumnInfo(name = "league_name")
    private String leagueName;

    @ColumnInfo(name = "league_sport")
    private String leagueSport;

    public int getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getLeagueSport() {
        return leagueSport;
    }
}