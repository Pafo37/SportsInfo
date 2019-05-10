package com.pavelkovachev.sportsinfo.persistence.model.tvevent;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.pavelkovachev.sportsinfo.adapters.diffutil.DiffComparable;
import com.pavelkovachev.sportsinfo.network.response.tvevents.TvEventsResponse;

@Entity
public class TvEventModel implements DiffComparable {

    @NonNull
    @PrimaryKey
    private String tvEventId;

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

    public TvEventModel(String tvEventId, String tvEventName, String tvEventDate, String tvEventTime,
                        String tvEventSport, String tvEventLogo, String tvEventChannel) {
        this.tvEventId = tvEventId;
        this.tvEventName = tvEventName;
        this.tvEventDate = tvEventDate;
        this.tvEventTime = tvEventTime;
        this.tvEventSport = tvEventSport;
        this.tvEventLogo = tvEventLogo;
        this.tvEventChannel = tvEventChannel;
    }

    public String getTvEventId() {
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

    public void setTvEventId(String tvEventId) {
        this.tvEventId = tvEventId;
    }

    public void setTvEventName(String tvEventName) {
        this.tvEventName = tvEventName;
    }

    public void setTvEventDate(String tvEventDate) {
        this.tvEventDate = tvEventDate;
    }

    public void setTvEventTime(String tvEventTime) {
        this.tvEventTime = tvEventTime;
    }

    public void setTvEventSport(String tvEventSport) {
        this.tvEventSport = tvEventSport;
    }

    public void setTvEventLogo(String tvEventLogo) {
        this.tvEventLogo = tvEventLogo;
    }

    public void setTvEventChannel(String tvEventChannel) {
        this.tvEventChannel = tvEventChannel;
    }

    public static TvEventModel convertToTvEventModel(TvEventsResponse tvEventsResponse) {

        return new TvEventModel(tvEventsResponse.getId(), tvEventsResponse.getStrEvent(),
                tvEventsResponse.getDateEvent(), tvEventsResponse.getStrTime(),
                tvEventsResponse.getStrSport(), tvEventsResponse.getStrLogo(), tvEventsResponse.getStrChannel());
    }

    @Override
    public boolean isItemTheSameAs(Object newItem) {
        TvEventModel newTvEvent = (TvEventModel) newItem;
        return this.getTvEventId() == newTvEvent.getTvEventId();
    }

    @Override
    public boolean areContentsTheSameAs(Object newItem) {
        TvEventModel newTvEvent = (TvEventModel) newItem;
        return this == newTvEvent;
    }
}