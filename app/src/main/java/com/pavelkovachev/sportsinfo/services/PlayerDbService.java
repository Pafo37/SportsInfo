package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModel;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class PlayerDbService implements PlayerRepository {

    private final PlayerModelDao playerModelDao;
    private final AppExecutor executor;

    @Inject
    public PlayerDbService(final PlayerModelDao playerModelDao,
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