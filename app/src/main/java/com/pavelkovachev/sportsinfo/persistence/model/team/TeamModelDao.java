package com.pavelkovachev.sportsinfo.persistence.model.team;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TeamModelDao {

    @Query("SELECT * FROM TeamModel")
    Single<List<TeamModel>> getAllTeams();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeams(List<TeamModel> teamModelList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeam(TeamModel teamModel);

    @Delete
    void deleteTeam(TeamModel teamModel);

}