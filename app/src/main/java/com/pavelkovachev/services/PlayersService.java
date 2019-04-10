package com.pavelkovachev.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.players.PlayersModel;
import com.pavelkovachev.sportsinfo.persistence.model.players.PlayersModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.players.PlayersRepository;

import java.util.List;

public class PlayersService implements PlayersRepository {

    private final PlayersModelDao playersModelDao;
    private final AppExecutor executor;

    public PlayersService(final PlayersModelDao playersModelDao,
                          final AppExecutor executor) {
        this.playersModelDao = playersModelDao;
        this.executor = executor;
    }

    @Override
    public void insertPlayers(List<PlayersModel> playersModelList) {
        executor.execute(() -> playersModelDao.insertPlayers(playersModelList));
    }

    @Override
    public void insertPlayer(PlayersModel playersModel) {
        executor.execute(() -> playersModelDao.insertPlayer(playersModel));
    }

    @Override
    public void deletePlayer(PlayersModel playersModel) {
        executor.execute(() -> playersModelDao.deletePlayers(playersModel));
    }

    @Override
    public void getAllPlayers() {

    }
}