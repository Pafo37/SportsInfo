package com.pavelkovachev.sportsinfo.dagger.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.pavelkovachev.sportsinfo.persistence.database.SportsInfoDatabase;
import com.pavelkovachev.sportsinfo.persistence.model.allevents.AllEventsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.leagues.LeaguesModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.players.PlayersModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.sports.SportsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.teams.TeamsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.tvevents.TvEventsModelDao;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private SportsInfoDatabase database;

    public RoomModule(Application application) {
        database = Room.databaseBuilder(application, SportsInfoDatabase.class, "sports_info_db").build();
    }

    @Provides
    SportsInfoDatabase providesRoomDatabase() {
        return database;
    }

    @Provides
    AllEventsModelDao providesAllEventsDao() {
        return database.allEventsModelDao();
    }

    @Provides
    LeaguesModelDao providesLeaguesModelDao() {
        return database.leaguesModelDao();
    }

    @Provides
    PlayersModelDao providesPlayersModelDao() {
        return database.playersModelDao();
    }

    @Provides
    SportsModelDao providesSportsModelDao() {
        return database.sportsModelDao();
    }

    @Provides
    TeamsModelDao providesTeamsModelDao() {
        return database.teamsModelDao();
    }

    @Provides
    TvEventsModelDao providesTvEventsModelDao() {
        return database.tvEventsModelDao();
    }
}