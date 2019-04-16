package com.pavelkovachev.sportsinfo.persistence.model.tvevent;

import java.util.List;

import io.reactivex.Single;

public interface TvEventRepository {

    void insertTvEvents(List<TvEventModel> tvEventModelList);

    void insertTvEvent(TvEventModel tvEventModel);

    void deleteTvEvent(TvEventModel tvEventModel);

    Single<List<TvEventModel>> getAllTvEvents();

}