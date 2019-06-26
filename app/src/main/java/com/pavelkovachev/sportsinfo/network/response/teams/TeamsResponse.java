package com.pavelkovachev.sportsinfo.network.response.teams;

import com.google.gson.annotations.SerializedName;

public class TeamsResponse {

    @SerializedName("idTeam")
    private String idTeam;
    @SerializedName("strTeam")
    private String strTeam;
    @SerializedName("yearFormed")
    private String yearFormed;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strLeague")
    private String strLeague;
    @SerializedName("idLeague")
    private String idLeague;
    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;
    @SerializedName("strCountry")
    private String strCountry;
    @SerializedName("strTeamLogo")
    private String strTeamLogo;

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getYearFormed() {
        return yearFormed;
    }

    public void setYearFormed(String yearFormed) {
        this.yearFormed = yearFormed;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }
}