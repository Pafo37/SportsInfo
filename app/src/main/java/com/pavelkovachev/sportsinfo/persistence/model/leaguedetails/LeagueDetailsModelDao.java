package com.pavelkovachev.sportsinfo.persistence.model.leaguedetails;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface LeagueDetailsModelDao {

    @Insert
    void insert(LeagueDetailsModel leagueDetailsModel);

}