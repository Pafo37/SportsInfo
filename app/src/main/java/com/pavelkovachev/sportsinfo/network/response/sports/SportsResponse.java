package com.pavelkovachev.sportsinfo.network.response.sports;

import com.google.gson.annotations.SerializedName;

public class SportsResponse {

    @SerializedName("idSport")
    private String idSport;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strSportThumb")
    private String strSportThumb;
    @SerializedName("strSportDescription")
    private String strSportDescription;

    public String getIdSport() {
        return idSport;
    }

    public void setIdSport(String idSport) {
        this.idSport = idSport;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }

}
