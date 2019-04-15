package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.tvevents.TvEventsModel;
import com.pavelkovachev.sportsinfo.persistence.model.tvevents.TvEventsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.tvevents.TvEventsRepository;

import java.util.List;

import io.reactivex.Single;

public class TvEventsService implements TvEventsRepository {

    private final TvEventsModelDao tvEventsModelDao;
    private final AppExecutor executor;

    public TvEventsService(TvEventsModelDao tvEventsModelDao, AppExecutor executor) {
        this.tvEventsModelDao = tvEventsModelDao;
        this.executor = executor;
    }

    @Override
    public void insertTvEvents(List<TvEventsModel> tvEventsModelList) {
        executor.execute(() -> tvEventsModelDao.insertTvEvents(tvEventsModelList));
    }

    @Override
    public void insertTvEvent(TvEventsModel tvEventsModel) {
        executor.execute(() -> tvEventsModelDao.insertTvEvent(tvEventsModel));
    }

    @Override
    public void deleteTvEvent(TvEventsModel tvEventsModel) {
        executor.execute(() -> tvEventsModelDao.deleteTvEvent(tvEventsModel));
    }

    @Override
    public Single<List<TvEventsModel>> getAllTvEvents() {
        return tvEventsModelDao.getAllTvEvents();
    }
}