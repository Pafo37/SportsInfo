package com.pavelkovachev.sportsinfo.persistence.model.leagues;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface LeaguesModelDao {

    @Query("SELECT * FROM LeaguesModel")
    Single<List<LeaguesModel>> getAllLeagues();

    @Insert
    void insertLeagues(List<LeaguesModel> leaguesModelList);

    @Insert
    void insertLeague(LeaguesModel leaguesModel);

    @Delete
    void deleteLeagues(LeaguesModel leaguesModel);

}