package com.pavelkovachev.sportsinfo.persistence.model.teams;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TeamsModelDao {

    @Query("SELECT * from TeamsModel")
    Single<List<TeamsModel>> getAllTeams();

    @Insert
    void insertTeams(List<TeamsModel> teamsModelList);

    @Insert
    void insertTeam(TeamsModel teamsModel);

    @Delete
    void deleteTeam(TeamsModel teamsModel);

}