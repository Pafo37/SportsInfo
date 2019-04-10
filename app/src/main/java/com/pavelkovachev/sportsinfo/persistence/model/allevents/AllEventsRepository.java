package com.pavelkovachev.sportsinfo.persistence.model.allevents;

import java.util.List;

public interface AllEventsRepository {

    void insertAllEvents(List<AllEventsModel> allEventsModelList);

    void insertAllEvent(AllEventsModel allEventsModel);

    void deleteAllEvent(AllEventsModel allEventsModel);

    void getAllEvents();

}