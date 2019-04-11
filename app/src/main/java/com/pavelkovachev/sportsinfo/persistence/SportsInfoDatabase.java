package com.pavelkovachev.sportsinfo.persistence;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.pavelkovachev.sportsinfo.persistence.model.allevents.AllEventsModel;
import com.pavelkovachev.sportsinfo.persistence.model.allevents.AllEventsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.leagues.LeaguesModel;
import com.pavelkovachev.sportsinfo.persistence.model.leagues.LeaguesModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.players.PlayersModel;
import com.pavelkovachev.sportsinfo.persistence.model.players.PlayersModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.sports.SportsModel;
import com.pavelkovachev.sportsinfo.persistence.model.sports.SportsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.teams.TeamsModel;
import com.pavelkovachev.sportsinfo.persistence.model.teams.TeamsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.tvevents.TvEventsModel;
import com.pavelkovachev.sportsinfo.persistence.model.tvevents.TvEventsModelDao;

@Database(entities = {AllEventsModel.class, LeaguesModel.class, PlayersModel.class,
        SportsModel.class, TeamsModel.class, TvEventsModel.class}, version = 1, exportSchema = false)
public abstract class SportsInfoDatabase extends RoomDatabase {

    public abstract AllEventsModelDao allEventsModelDao();

    public abstract LeaguesModelDao leaguesModelDao();

    public abstract PlayersModelDao playersModelDao();

    public abstract SportsModelDao sportsModelDao();

    public abstract TeamsModelDao teamsModelDao();

    public abstract TvEventsModelDao tvEventsModelDao();

}