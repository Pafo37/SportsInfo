package com.pavelkovachev.sportsinfo.persistence.model.players;

import java.util.List;

import io.reactivex.Single;

public interface PlayersRepository {

    void insertPlayers(List<PlayersModel> playersModelList);

    void insertPlayer(PlayersModel playersModel);

    void deletePlayer(PlayersModel playersModel);

    Single<List<PlayersModel>> getAllPlayers();

}