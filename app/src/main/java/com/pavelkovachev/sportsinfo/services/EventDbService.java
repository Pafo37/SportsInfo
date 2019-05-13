package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.event.EventModel;
import com.pavelkovachev.sportsinfo.persistence.model.event.EventModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.event.EventRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class EventDbService implements EventRepository {

    private final EventModelDao eventModelDao;
    private final AppExecutor executor;

    @Inject
    public EventDbService(final EventModelDao eventModelDao,
                          final AppExecutor executor) {
        this.eventModelDao = eventModelDao;
        this.executor = executor;
    }

    @Override
    public void insertAllEvents(List<EventModel> eventModelList) {
        executor.execute(() -> eventModelDao.insertAllEvents(eventModelList));
    }

    @Override
    public void insertAllEvent(EventModel eventModel) {
        executor.execute(() -> eventModelDao.insertAllEvent(eventModel));
    }

    @Override
    public void deleteAllEvent(EventModel eventModel) {
        executor.execute(() -> eventModelDao.deleteAllEvent(eventModel));
    }

    @Override
    public Single<List<EventModel>> getAllEvents() {
        return eventModelDao.getAllEvents();
    }
}