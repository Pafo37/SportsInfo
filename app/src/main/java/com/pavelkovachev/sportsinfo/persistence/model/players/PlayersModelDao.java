package com.pavelkovachev.sportsinfo.persistence.model.players;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PlayersModelDao {

    @Query("SELECT * FROM PlayersModel")
    Single<List<PlayersModel>> getAllPlayers();

    @Insert
    void insertPlayers(List<PlayersModel> playersModelList);

    @Insert
    void insertPlayer(PlayersModel playersModel);

    @Delete
    void deletePlayers(PlayersModel playersModel);

}