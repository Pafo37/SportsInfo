package com.pavelkovachev.sportsinfo.network.response.leaguedetails;

import com.google.gson.annotations.SerializedName;

public class LeagueDetailsResponse {

    @SerializedName("idLeague")
    private String idLeague;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strLeague")
    private String strLeague;
    @SerializedName("strLeagueAlternate")
    private String strLeagueAlternate;
    @SerializedName("intFormedYear")
    private String yearFormed;
    @SerializedName("strCountry")
    private String strCountry;
    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;
    @SerializedName("strLogo")
    private String strLogo;

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
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

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

    public String getIntFormedYear() {
        return yearFormed;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.yearFormed = intFormedYear;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrLogo() {
        return strLogo;
    }

    public void setStrLogo(String strLogo) {
        this.strLogo = strLogo;
    }
}