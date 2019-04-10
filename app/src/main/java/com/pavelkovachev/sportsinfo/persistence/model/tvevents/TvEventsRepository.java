package com.pavelkovachev.sportsinfo.persistence.model.tvevents;

import java.util.List;

public interface TvEventsRepository {

    void insertTvEvents(List<TvEventsModel> tvEventsModelList);

    void insertTvEvent(TvEventsModel tvEventsModel);

    void deleteTvEvent(TvEventsModel tvEventsModel);

    void getAllTvEvents();

}