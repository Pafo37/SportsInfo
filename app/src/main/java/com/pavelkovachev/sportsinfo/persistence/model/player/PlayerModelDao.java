package com.pavelkovachev.sportsinfo.persistence.model.player;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PlayerModelDao {

    @Query("SELECT * FROM PlayerModel")
    Single<List<PlayerModel>> getAllPlayers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlayers(List<PlayerModel> playerModelList);

    @Insert
    void insertPlayer(PlayerModel playerModel);

    @Delete
    void deletePlayers(PlayerModel playerModel);

}