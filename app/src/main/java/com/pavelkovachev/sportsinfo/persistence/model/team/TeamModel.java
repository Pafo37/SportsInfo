package com.pavelkovachev.sportsinfo.persistence.model.team;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class TeamModel {

    @NonNull
    @PrimaryKey
    private int teamId;

    @ColumnInfo(name = "team_name")
    private String teamName;

    @ColumnInfo(name = "team_league_name")
    private String teamLeagueName;

    @ColumnInfo(name = "team_logo")
    private String teamLogo;

    @ColumnInfo(name = "team_country")
    private String teamCountry;

    @ColumnInfo(name = "team_year_formed")
    private String teamYearFormed;

    @ColumnInfo(name = "tea_description")
    private String teamDescription;

    public TeamModel(int teamId, String teamName, String teamLeagueName, String teamLogo,
                     String teamCountry, String teamYearFormed, String teamDescription) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLeagueName = teamLeagueName;
        this.teamLogo = teamLogo;
        this.teamCountry = teamCountry;
        this.teamYearFormed = teamYearFormed;
        this.teamDescription = teamDescription;
    }

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

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamLeagueName(String teamLeagueName) {
        this.teamLeagueName = teamLeagueName;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public void setTeamCountry(String teamCountry) {
        this.teamCountry = teamCountry;
    }

    public void setTeamYearFormed(String teamYearFormed) {
        this.teamYearFormed = teamYearFormed;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
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