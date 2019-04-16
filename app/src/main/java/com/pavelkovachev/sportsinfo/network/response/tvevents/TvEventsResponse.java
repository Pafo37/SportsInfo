package com.pavelkovachev.sportsinfo.network.response.tvevents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvEventsResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("idEvent")
    private String idEvent;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strEvent")
    private String strEvent;
    @SerializedName("idChannel")
    private String idChannel;
    @SerializedName("strLogo")
    private String strLogo;
    @SerializedName("strChannel")
    private String strChannel;
    @SerializedName("strTime")
    private String strTime;
    @SerializedName("dateEvent")
    private String dateEvent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getStrEvent() {
        return strEvent;
    }

    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    public String getIdChannel() {
        return idChannel;
    }

    public void setIdChannel(String idChannel) {
        this.idChannel = idChannel;
    }

    public String getStrLogo() {
        return strLogo;
    }

    public void setStrLogo(String strLogo) {
        this.strLogo = strLogo;
    }

    public String getStrChannel() {
        return strChannel;
    }

    public void setStrChannel(String strChannel) {
        this.strChannel = strChannel;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }
}