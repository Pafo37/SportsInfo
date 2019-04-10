package com.pavelkovachev.sportsinfo.persistence.model.leagues;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;

@Dao
public interface LeaguesModelDao {

    @Insert
    void insertLeagues(List<LeaguesModel> leaguesModelList);

    @Insert
    void insertLeague(LeaguesModel leaguesModel);

    @Delete
    void deleteLeagues(LeaguesModel leaguesModel);

}