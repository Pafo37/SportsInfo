package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.leaguedetails.LeagueDetailsModel;
import com.pavelkovachev.sportsinfo.persistence.model.leaguedetails.LeagueDetailsModelDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LeagueDetailsDbService implements LeagueDetailsModelDao {

    private AppExecutor appExecutor;
    private LeagueDetailsModelDao leagueDetailsModelDao;

    @Inject
    public LeagueDetailsDbService(final AppExecutor appExecutor,
                                  final LeagueDetailsModelDao leagueDetailsModelDao) {
        this.appExecutor = appExecutor;
        this.leagueDetailsModelDao = leagueDetailsModelDao;
    }

    @Override
    public void insert(LeagueDetailsModel leagueDetailsModel) {
        appExecutor.execute(() -> leagueDetailsModelDao.insert(leagueDetailsModel));
    }
}