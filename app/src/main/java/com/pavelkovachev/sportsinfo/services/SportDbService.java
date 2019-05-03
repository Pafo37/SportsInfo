package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModel;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class SportDbService implements SportRepository {

    private final SportModelDao sportModelDao;
    private final AppExecutor executor;

    @Inject
    public SportDbService(SportModelDao sportModelDao, AppExecutor executor) {
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