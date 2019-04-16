package com.pavelkovachev.sportsinfo.network.response.events;

import com.google.gson.annotations.SerializedName;

public class EventsResponse {

    @SerializedName("idEvent")
    private String idEvent;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("idLeague")
    private String idLeague;
    @SerializedName("strLeague")
    private String strLeague;
    @SerializedName("strHomeTeam")
    private String strHomeTeam;
    @SerializedName("strAwayTeam")
    private String strAwayTeam;
    @SerializedName("intHomeScore")
    private String intHomeScore;
    @SerializedName("intAwayScore")
    private String intAwayScore;
    @SerializedName("dateEvent")
    private String dateEvent;
    @SerializedName("idHomeTeam")
    private String idHomeTeam;
    @SerializedName("idAwayTeam")
    private String idAwayTeam;

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    public String getIntHomeScore() {
        return intHomeScore;
    }

    public void setIntHomeScore(String intHomeScore) {
        this.intHomeScore = intHomeScore;
    }

    public String getIntAwayScore() {
        return intAwayScore;
    }

    public void setIntAwayScore(String intAwayScore) {
        this.intAwayScore = intAwayScore;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getIdHomeTeam() {
        return idHomeTeam;
    }

    public void setIdHomeTeam(String idHomeTeam) {
        this.idHomeTeam = idHomeTeam;
    }

    public String getIdAwayTeam() {
        return idAwayTeam;
    }

    public void setIdAwayTeam(String idAwayTeam) {
        this.idAwayTeam = idAwayTeam;
    }
}