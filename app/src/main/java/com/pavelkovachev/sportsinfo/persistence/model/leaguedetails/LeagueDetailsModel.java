package com.pavelkovachev.sportsinfo.persistence.model.leaguedetails;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.pavelkovachev.sportsinfo.network.response.leaguedetails.LeagueDetailsResponse;

@Entity
public class LeagueDetailsModel {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sport_name")
    private String sportName;

    @ColumnInfo(name = "league_name")
    private String leagueName;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "year_formed")
    private String yearFormed;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "league_logo")
    private String leagueLogo;

    public LeagueDetailsModel(String sportName, String leagueName, String country,
                              String yearFormed, String description, String leagueLogo) {
        this.sportName = sportName;
        this.leagueName = leagueName;
        this.country = country;
        this.yearFormed = yearFormed;
        this.description = description;
        this.leagueLogo = leagueLogo;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getCountry() {
        return country;
    }

    public String getLeagueLogo() {
        return leagueLogo;
    }

    public void setLeagueLogo(String leagueLogo) {
        this.leagueLogo = leagueLogo;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYearFormed() {
        return yearFormed;
    }

    public void setYearFormed(String yearFormed) {
        this.yearFormed = yearFormed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static LeagueDetailsModel convertToLeagueDetailsModel(LeagueDetailsResponse leagueDetailsResponse) {
        return new LeagueDetailsModel(
                leagueDetailsResponse.getStrSport(),
                leagueDetailsResponse.getStrLeague(),
                leagueDetailsResponse.getStrCountry(),
                leagueDetailsResponse.getIntFormedYear(),
                leagueDetailsResponse.getStrDescriptionEN(),
                leagueDetailsResponse.getStrLogo());
    }
}