package com.pavelkovachev.sportsinfo.persistence.model.sports;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface SportsModelDao {

    @Query("SELECT * from SportsModel")
    Single<List<SportsModel>> getAllSports();

    @Insert
    void insertSports(List<SportsModel> sportsModels);

    @Insert
    void insertSport(SportsModel sportsModel);

    @Delete
    void deleteSport(SportsModel sportsModel);

}