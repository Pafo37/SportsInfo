package com.pavelkovachev.sportsinfo.dagger.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.pavelkovachev.sportsinfo.persistence.database.SportsInfoDatabase;
import com.pavelkovachev.sportsinfo.persistence.model.event.EventModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.league.LeagueModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.leaguedetails.LeagueDetailsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.tvevent.TvEventModelDao;

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
    EventModelDao providesAllEventsDao() {
        return database.allEventsModelDao();
    }

    @Provides
    LeagueModelDao providesLeaguesModelDao() {
        return database.leaguesModelDao();
    }

    @Provides
    PlayerModelDao providesPlayersModelDao() {
        return database.playersModelDao();
    }

    @Provides
    SportModelDao providesSportsModelDao() {
        return database.sportsModelDao();
    }

    @Provides
    TeamModelDao providesTeamsModelDao() {
        return database.teamsModelDao();
    }

    @Provides
    TvEventModelDao providesTvEventsModelDao() {
        return database.tvEventsModelDao();
    }

    @Provides
    LeagueDetailsModelDao providesLeagueDetailsModelDao() {
        return database.leagueDetailsModelDao();
    }
}