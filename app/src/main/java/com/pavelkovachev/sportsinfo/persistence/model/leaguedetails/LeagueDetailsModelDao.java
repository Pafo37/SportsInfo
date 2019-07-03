package com.pavelkovachev.sportsinfo.persistence.model.leaguedetails;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

@Dao
public interface LeagueDetailsModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LeagueDetailsModel leagueDetailsModel);

}