package com.pavelkovachev.sportsinfo.persistence.model.event;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.pavelkovachev.sportsinfo.adapters.diffutil.DiffComparable;
import com.pavelkovachev.sportsinfo.network.response.events.EventsResponse;

@Entity
public class EventModel implements DiffComparable {

    @NonNull
    @PrimaryKey
    private String allEventsId;

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

    public EventModel(String allEventsId, String allEventsSport, String allEventsLeague,
                      String allEventsDate, String allEventsHomeTeamName, String allEventsAwayTeamName,
                      String allEventsHomeTeamScore, String allEventsAwayTeamScore) {
        this.allEventsId = allEventsId;
        this.allEventsSport = allEventsSport;
        this.allEventsLeague = allEventsLeague;
        this.allEventsDate = allEventsDate;
        this.allEventsHomeTeamName = allEventsHomeTeamName;
        this.allEventsAwayTeamName = allEventsAwayTeamName;
        this.allEventsHomeTeamScore = allEventsHomeTeamScore;
        this.allEventsAwayTeamScore = allEventsAwayTeamScore;
    }

    public String getAllEventsId() {
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

    public void setAllEventsId(String allEventsId) {
        this.allEventsId = allEventsId;
    }

    public void setAllEventsSport(String allEventsSport) {
        this.allEventsSport = allEventsSport;
    }

    public void setAllEventsLeague(String allEventsLeague) {
        this.allEventsLeague = allEventsLeague;
    }

    public void setAllEventsDate(String allEventsDate) {
        this.allEventsDate = allEventsDate;
    }

    public void setAllEventsHomeTeamName(String allEventsHomeTeamName) {
        this.allEventsHomeTeamName = allEventsHomeTeamName;
    }

    public void setAllEventsAwayTeamName(String allEventsAwayTeamName) {
        this.allEventsAwayTeamName = allEventsAwayTeamName;
    }

    public void setAllEventsHomeTeamScore(String allEventsHomeTeamScore) {
        this.allEventsHomeTeamScore = allEventsHomeTeamScore;
    }

    public void setAllEventsAwayTeamScore(String allEventsAwayTeamScore) {
        this.allEventsAwayTeamScore = allEventsAwayTeamScore;
    }

    public static EventModel convertToEventModel(EventsResponse eventsResponse) {
        return new EventModel(eventsResponse.getIdEvent(), eventsResponse.getStrSport(),
                eventsResponse.getStrLeague(), eventsResponse.getDateEvent(),
                eventsResponse.getStrHomeTeam(), eventsResponse.getStrAwayTeam(),
                eventsResponse.getHomeScore(), eventsResponse.getAwayScore());
    }

    @Override
    public boolean isItemTheSameAs(Object newItem) {
        EventModel eventModel = (EventModel) newItem;
        return this.getAllEventsId() == eventModel.getAllEventsId();
    }

    @Override
    public boolean areContentsTheSameAs(Object newItem) {
        EventModel eventModel = (EventModel) newItem;
        return this == eventModel;
    }
}