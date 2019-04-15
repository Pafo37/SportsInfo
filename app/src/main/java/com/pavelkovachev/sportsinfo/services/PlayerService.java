package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModel;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerRepository;

import java.util.List;

import io.reactivex.Single;

public class PlayerService implements PlayerRepository {

    private final PlayerModelDao playerModelDao;
    private final AppExecutor executor;

    public PlayerService(final PlayerModelDao playerModelDao,
                         final AppExecutor executor) {
        this.playerModelDao = playerModelDao;
        this.executor = executor;
    }

    @Override
    public void insertPlayers(List<PlayerModel> playerModelList) {
        executor.execute(() -> playerModelDao.insertPlayers(playerModelList));
    }

    @Override
    public void insertPlayer(PlayerModel playerModel) {
        executor.execute(() -> playerModelDao.insertPlayer(playerModel));
    }

    @Override
    public void deletePlayer(PlayerModel playerModel) {
        executor.execute(() -> playerModelDao.deletePlayers(playerModel));
    }

    @Override
    public Single<List<PlayerModel>> getAllPlayers() {
        return playerModelDao.getAllPlayers();
    }
}