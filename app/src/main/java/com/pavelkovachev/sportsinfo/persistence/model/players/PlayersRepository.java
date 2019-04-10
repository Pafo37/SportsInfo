package com.pavelkovachev.sportsinfo.persistence.model.players;

import java.util.List;

public interface PlayersRepository {

    void insertPlayers(List<PlayersModel> playersModelList);

    void insertPlayer(PlayersModel playersModel);

    void deletePlayer(PlayersModel playersModel);

}