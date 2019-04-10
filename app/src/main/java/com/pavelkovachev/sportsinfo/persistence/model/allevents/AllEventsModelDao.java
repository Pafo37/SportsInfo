package com.pavelkovachev.sportsinfo.persistence.model.allevents;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;

@Dao
public interface AllEventsModelDao {

    @Insert
    void insertAllEvents(List<AllEventsModel> allEventsModelsList);

    @Insert
    void insertAllEvent(AllEventsModel allEventsModel);

    @Delete
    void deleteAllEvent(AllEventsModel allEventsModel);

}