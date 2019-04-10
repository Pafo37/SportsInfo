package com.pavelkovachev.sportsinfo.persistence.model.players;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;

@Dao
public interface PlayersModelDao {

    @Insert
    void insertPlayers(List<PlayersModel> playersModelList);

    @Insert
    void insertPlayer(PlayersModel playersModel);

    @Delete
    void deletePlayers(PlayersModel playersModel);

}