package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.tvevent.TvEventModel;
import com.pavelkovachev.sportsinfo.persistence.model.tvevent.TvEventModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.tvevent.TvEventRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class TvEventDbService implements TvEventRepository {

    private final TvEventModelDao tvEventModelDao;
    private final AppExecutor executor;

    @Inject
    public TvEventDbService(TvEventModelDao tvEventModelDao, AppExecutor executor) {
        this.tvEventModelDao = tvEventModelDao;
        this.executor = executor;
    }

    @Override
    public void insertTvEvents(List<TvEventModel> tvEventModelList) {
        executor.execute(() -> tvEventModelDao.insertTvEvents(tvEventModelList));
    }

    @Override
    public void insertTvEvent(TvEventModel tvEventModel) {
        executor.execute(() -> tvEventModelDao.insertTvEvent(tvEventModel));
    }

    @Override
    public void deleteTvEvent(TvEventModel tvEventModel) {
        executor.execute(() -> tvEventModelDao.deleteTvEvent(tvEventModel));
    }

    @Override
    public Single<List<TvEventModel>> getAllTvEvents() {
        return tvEventModelDao.getAllTvEvents();
    }
}