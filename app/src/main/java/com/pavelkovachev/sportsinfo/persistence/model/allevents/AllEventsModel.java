package com.pavelkovachev.sportsinfo.persistence.model.allevents;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class AllEventsModel {

    @NonNull
    @PrimaryKey
    private int allEventsId;

    @ColumnInfo(name = "all_events_sport")
    private String allEventsSport;

    @ColumnInfo(name = "all_events_league")
    private String allEventsLeague;

    @ColumnInfo(name = "all_events_date")
    private String allEventsDate;

    @ColumnInfo(name = "all_events_home_team_name")
    private String allEventsHomeTeamName;

    @ColumnInfo(name = "all_events_away_team_name")
    private String allEventsAwayTeamName;

    @ColumnInfo(name = "all_events_home_team_score")
    private String allEventsHomeTeamScore;

    @ColumnInfo(name = "all_events_away_team_score")
    private String allEventsAwayTeamScore;

    public int getAllEventsId() {
        return allEventsId;
    }

    public String getAllEventsSport() {
        return allEventsSport;
    }

    public String getAllEventsLeague() {
        return allEventsLeague;
    }

    public String getAllEventsDate() {
        return allEventsDate;
    }

    public String getAllEventsHomeTeamName() {
        return allEventsHomeTeamName;
    }

    public String getAllEventsAwayTeamName() {
        return allEventsAwayTeamName;
    }

    public String getAllEventsHomeTeamScore() {
        return allEventsHomeTeamScore;
    }

    public String getAllEventsAwayTeamScore() {
        return allEventsAwayTeamScore;
    }
}