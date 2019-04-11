package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.leagues.LeaguesModel;
import com.pavelkovachev.sportsinfo.persistence.model.leagues.LeaguesModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.leagues.LeaguesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class LeaguesServices implements LeaguesRepository {

    private final LeaguesModelDao leaguesModelDao;
    private final AppExecutor executor;

    @Inject
    public LeaguesServices(final LeaguesModelDao leaguesModelDao,
                           final AppExecutor executor) {
        this.leaguesModelDao = leaguesModelDao;
        this.executor = executor;
    }

    @Override
    public void insertLeagues(List<LeaguesModel> leaguesModelList) {
        executor.execute(() -> leaguesModelDao.insertLeagues(leaguesModelList));
    }

    @Override
    public void insertLeague(LeaguesModel leaguesModel) {
        executor.execute(() -> leaguesModelDao.insertLeague(leaguesModel));
    }

    @Override
    public void deleteLeague(LeaguesModel leaguesModel) {
        executor.execute(() -> leaguesModelDao.deleteLeagues(leaguesModel));
    }

    @Override
    public Single<List<LeaguesModel>> getAllLeagues() {
        return leaguesModelDao.getAllLeagues();
    }
}