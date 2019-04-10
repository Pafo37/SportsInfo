package com.pavelkovachev.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.sports.SportsModel;
import com.pavelkovachev.sportsinfo.persistence.model.sports.SportsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.sports.SportsRepository;

import java.util.List;

public class SportsService implements SportsRepository {

    private final SportsModelDao sportsModelDao;
    private final AppExecutor executor;

    public SportsService(SportsModelDao sportsModelDao, AppExecutor executor) {
        this.sportsModelDao = sportsModelDao;
        this.executor = executor;
    }

    @Override
    public void insertSports(List<SportsModel> sportsModelList) {
        executor.execute(() -> sportsModelDao.insertSports(sportsModelList));
    }

    @Override
    public void insertSport(SportsModel sportsModel) {
        executor.execute(() -> sportsModelDao.insertSport(sportsModel));
    }

    @Override
    public void deleteSport(SportsModel sportsModel) {
        executor.execute(() -> sportsModelDao.deleteSport(sportsModel));
    }

    @Override
    public void getAllSports() {

    }
}