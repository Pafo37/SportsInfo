package com.pavelkovachev.sportsinfo.persistence.model.sport;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface SportModelDao {

    @Query("SELECT * FROM SportModel")
    Single<List<SportModel>> getAllSports();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSports(List<SportModel> sportModels);

    @Insert
    void insertSport(SportModel sportModel);

    @Delete
    void deleteSport(SportModel sportModel);

}