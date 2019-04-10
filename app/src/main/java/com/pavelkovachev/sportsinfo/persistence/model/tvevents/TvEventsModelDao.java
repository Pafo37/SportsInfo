package com.pavelkovachev.sportsinfo.persistence.model.tvevents;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;

@Dao
public interface TvEventsModelDao {

    @Insert
    void insertTvEvents(List<TvEventsModel> tvEventsModelList);

    @Insert
    void insertTvEvent(TvEventsModel tvEventsModel);

    @Delete
    void deleteTvEvent(TvEventsModel tvEventsModel);
}