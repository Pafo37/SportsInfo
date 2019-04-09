package com.pavelkovachev.sportsinfo.persistence.model.teams;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class TeamsModel {

    @NonNull
    @PrimaryKey
    private int teamId;

    @ColumnInfo(name = "league_name")
    private String teamName;

    @ColumnInfo(name = "league_name")
    private String teamLeagueName;

    @ColumnInfo(name = "league_logo")
    private String teamLogo;

    @ColumnInfo(name = "league_country")
    private String teamCountry;

    @ColumnInfo(name = "league_year_formed")
    private String teamYearFormed;

    @ColumnInfo(name = "league_description")
    private String teamDescription;

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLeagueName() {
        return teamLeagueName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public String getTeamCountry() {
        return teamCountry;
    }

    public String getTeamYearFormed() {
        return teamYearFormed;
    }

    public String getTeamDescription() {
        return teamDescription;
    }
}