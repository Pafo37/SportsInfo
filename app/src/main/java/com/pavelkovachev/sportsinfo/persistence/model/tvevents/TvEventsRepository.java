package com.pavelkovachev.sportsinfo.persistence.model.tvevents;

import java.util.List;

import io.reactivex.Single;

public interface TvEventsRepository {

    void insertTvEvents(List<TvEventsModel> tvEventsModelList);

    void insertTvEvent(TvEventsModel tvEventsModel);

    void deleteTvEvent(TvEventsModel tvEventsModel);

    Single<List<TvEventsModel>> getAllTvEvents();

}