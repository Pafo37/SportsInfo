package com.pavelkovachev.sportsinfo.persistence.model.allevents;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface AllEventsModelDao {

    @Query("SELECT * FROM AllEventsModel")
    Single<List<AllEventsModel>> getAllEvents();

    @Insert
    void insertAllEvents(List<AllEventsModel> allEventsModelsList);

    @Insert
    void insertAllEvent(AllEventsModel allEventsModel);

    @Delete
    void deleteAllEvent(AllEventsModel allEventsModel);

}