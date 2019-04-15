package com.pavelkovachev.sportsinfo.persistence.model.player;

import java.util.List;

import io.reactivex.Single;

public interface PlayerRepository {

    void insertPlayers(List<PlayerModel> playerModelList);

    void insertPlayer(PlayerModel playerModel);

    void deletePlayer(PlayerModel playerModel);

    Single<List<PlayerModel>> getAllPlayers();

}