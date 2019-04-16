package com.pavelkovachev.sportsinfo.persistence.model.tvevent;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TvEventModelDao {

    @Query("SELECT * FROM TvEventModel")
    Single<List<TvEventModel>> getAllTvEvents();

    @Insert
    void insertTvEvents(List<TvEventModel> tvEventModelList);

    @Insert
    void insertTvEvent(TvEventModel tvEventModel);

    @Delete
    void deleteTvEvent(TvEventModel tvEventModel);

}