package com.pavelkovachev.sportsinfo.network.response.players;

import com.google.gson.annotations.SerializedName;

public class PlayersResponse {

    @SerializedName("idPlayer")
    private String idPlayer;
    @SerializedName("idTeam")
    private String idTeam;
    @SerializedName("strNationality")
    private String strNationality;
    @SerializedName("strPlayer")
    private String strPlayer;
    @SerializedName("strTeam")
    private String strTeam;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("dateBorn")
    private String dateBorn;
    @SerializedName("dateSigned")
    private String dateSigned;
    @SerializedName("strBirthLocation")
    private String strBirthLocation;
    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;
    @SerializedName("strHeight")
    private String strHeight;
    @SerializedName("strThumb")
    private String strThumb;

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getStrBirthLocation() {
        return strBirthLocation;
    }

    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

}