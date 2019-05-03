package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.league.LeagueModel;
import com.pavelkovachev.sportsinfo.persistence.model.league.LeagueModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.league.LeagueRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class LeagueDbServices implements LeagueRepository {

    private final LeagueModelDao leagueModelDao;
    private final AppExecutor executor;

    @Inject
    public LeagueDbServices(final LeagueModelDao leagueModelDao,
                            final AppExecutor executor) {
        this.leagueModelDao = leagueModelDao;
        this.executor = executor;
    }

    @Override
    public void insertLeagues(List<LeagueModel> leagueModelList) {
        executor.execute(() -> leagueModelDao.insertLeagues(leagueModelList));
    }

    @Override
    public void insertLeague(LeagueModel leagueModel) {
        executor.execute(() -> leagueModelDao.insertLeague(leagueModel));
    }

    @Override
    public void deleteLeague(LeagueModel leagueModel) {
        executor.execute(() -> leagueModelDao.deleteLeagues(leagueModel));
    }

    @Override
    public Single<List<LeagueModel>> getAllLeagues() {
        return leagueModelDao.getAllLeagues();
    }
}