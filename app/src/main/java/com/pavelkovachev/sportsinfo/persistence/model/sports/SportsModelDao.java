package com.pavelkovachev.sportsinfo.persistence.model.sports;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;

@Dao
public interface SportsModelDao {

    @Insert
    void insertSports(List<SportsModel> sportsModels);

    @Insert
    void insertSport(SportsModel sportsModel);

    @Delete
    void deleteSport(SportsModel sportsModel);
}