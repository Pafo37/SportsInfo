package com.pavelkovachev.sportsinfo.persistence.model.sports;

import java.util.List;

import io.reactivex.Single;

public interface SportsRepository {

    void insertSports(List<SportsModel> sportsModelList);

    void insertSport(SportsModel sportsModel);

    void deleteSport(SportsModel sportsModel);

    Single<List<SportsModel>> getAllSports();

}