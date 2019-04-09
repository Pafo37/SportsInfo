package com.pavelkovachev.sportsinfo.persistence.model.tvevents;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class TvEventsModel {

    @NonNull
    @PrimaryKey
    private int tvEventId;

    @ColumnInfo(name = "tv_event_name")
    private String tvEventName;

    @ColumnInfo(name = "tv_event_date")
    private String tvEventDate;

    @ColumnInfo(name = "tv_event_time")
    private String tvEventTime;

    @ColumnInfo(name = "tv_event_sport")
    private String tvEventSport;

    @ColumnInfo(name = "tv_event_logo")
    private String tvEventLogo;

    @ColumnInfo(name = "tv_event_channel")
    private String tvEventChannel;

    public int getTvEventId() {
        return tvEventId;
    }

    public String getTvEventName() {
        return tvEventName;
    }

    public String getTvEventDate() {
        return tvEventDate;
    }

    public String getTvEventTime() {
        return tvEventTime;
    }

    public String getTvEventSport() {
        return tvEventSport;
    }

    public String getTvEventLogo() {
        return tvEventLogo;
    }

    public String getTvEventChannel() {
        return tvEventChannel;
    }
}