package com.pavelkovachev.sportsinfo.persistence.model.league;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface LeagueModelDao {

    @Query("SELECT * FROM LeagueModel")
    Single<List<LeagueModel>> getAllLeagues();

    @Insert
    void insertLeagues(List<LeagueModel> leagueModelList);

    @Insert
    void insertLeague(LeagueModel leagueModel);

    @Delete
    void deleteLeagues(LeagueModel leagueModel);

}