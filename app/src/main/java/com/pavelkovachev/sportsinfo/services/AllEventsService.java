package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.allevents.AllEventsModel;
import com.pavelkovachev.sportsinfo.persistence.model.allevents.AllEventsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.allevents.AllEventsRepository;

import java.util.List;

public class AllEventsService implements AllEventsRepository {

    private final AllEventsModelDao allEventsModelDao;
    private final AppExecutor executor;

    public AllEventsService(final AllEventsModelDao allEventsModelDao,
                            final AppExecutor executor) {
        this.allEventsModelDao = allEventsModelDao;
        this.executor = executor;
    }

    @Override
    public void insertAllEvents(List<AllEventsModel> allEventsModelList) {
        executor.execute(() -> allEventsModelDao.insertAllEvents(allEventsModelList));
    }

    @Override
    public void insertAllEvent(AllEventsModel allEventsModel) {
        executor.execute(() -> allEventsModelDao.insertAllEvent(allEventsModel));
    }

    @Override
    public void deleteAllEvent(AllEventsModel allEventsModel) {
        executor.execute(() -> allEventsModelDao.deleteAllEvent(allEventsModel));
    }

    @Override
    public void getAllEvents() {

    }
}
