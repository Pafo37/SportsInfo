package com.pavelkovachev.sportsinfo.persistence.model.tvevents;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TvEventsModelDao {

    @Query("SELECT * from TvEventsModel")
    Single<List<TvEventsModel>> getAllTvEvents();

    @Insert
    void insertTvEvents(List<TvEventsModel> tvEventsModelList);

    @Insert
    void insertTvEvent(TvEventsModel tvEventsModel);

    @Delete
    void deleteTvEvent(TvEventsModel tvEventsModel);

}