package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModel;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportRepository;

import java.util.List;

import io.reactivex.Single;

public class SportService implements SportRepository {

    private final SportModelDao sportModelDao;
    private final AppExecutor executor;

    public SportService(SportModelDao sportModelDao, AppExecutor executor) {
        this.sportModelDao = sportModelDao;
        this.executor = executor;
    }

    @Override
    public void insertSports(List<SportModel> sportModelList) {
        executor.execute(() -> sportModelDao.insertSports(sportModelList));
    }

    @Override
    public void insertSport(SportModel sportModel) {
        executor.execute(() -> sportModelDao.insertSport(sportModel));
    }

    @Override
    public void deleteSport(SportModel sportModel) {
        executor.execute(() -> sportModelDao.deleteSport(sportModel));
    }

    @Override
    public Single<List<SportModel>> getAllSports() {
        return sportModelDao.getAllSports();
    }
}