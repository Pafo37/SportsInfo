package com.pavelkovachev.sportsinfo.persistence.model.event;

import java.util.List;

import io.reactivex.Single;

public interface EventRepository {

    void insertAllEvents(List<EventModel> eventModelList);

    void insertAllEvent(EventModel eventModel);

    void deleteAllEvent(EventModel eventModel);

    Single<List<EventModel>> getAllEvents();

}