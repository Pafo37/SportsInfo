package com.pavelkovachev.sportsinfo.persistence.model.event;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface EventModelDao {

    @Query("SELECT * FROM EventModel")
    Single<List<EventModel>> getAllEvents();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllEvents(List<EventModel> eventModelsList);

    @Insert
    void insertAllEvent(EventModel eventModel);

    @Delete
    void deleteAllEvent(EventModel eventModel);

}