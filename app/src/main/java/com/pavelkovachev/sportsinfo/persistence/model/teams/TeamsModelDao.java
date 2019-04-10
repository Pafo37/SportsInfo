package com.pavelkovachev.sportsinfo.persistence.model.teams;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;

@Dao
public interface TeamsModelDao {

    @Insert
    void insertTeams(List<TeamsModel> teamsModelList);

    @Insert
    void insertTeam(TeamsModel teamsModel);

    @Delete
    void deleteTeam(TeamsModel teamsModel);

}