package com.pavelkovachev.sportsinfo.persistence.model.sport;

import java.util.List;

import io.reactivex.Single;

public interface SportRepository {

    void insertSports(List<SportModel> sportModelList);

    void insertSport(SportModel sportModel);

    void deleteSport(SportModel sportModel);

    Single<List<SportModel>> getAllSports();

}