package com.pavelkovachev.sportsinfo.persistence.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.pavelkovachev.sportsinfo.persistence.model.event.EventModel;
import com.pavelkovachev.sportsinfo.persistence.model.event.EventModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.league.LeagueModel;
import com.pavelkovachev.sportsinfo.persistence.model.league.LeagueModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModel;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModel;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModel;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.tvevent.TvEventModel;
import com.pavelkovachev.sportsinfo.persistence.model.tvevent.TvEventModelDao;

@Database(entities = {
        EventModel.class,
        LeagueModel.class,
        PlayerModel.class,
        SportModel.class,
        TeamModel.class,
        TvEventModel.class}, version = 1, exportSchema = false)
public abstract class SportsInfoDatabase extends RoomDatabase {

    public abstract EventModelDao allEventsModelDao();

    public abstract LeagueModelDao leaguesModelDao();

    public abstract PlayerModelDao playersModelDao();

    public abstract SportModelDao sportsModelDao();

    public abstract TeamModelDao teamsModelDao();

    public abstract TvEventModelDao tvEventsModelDao();

}