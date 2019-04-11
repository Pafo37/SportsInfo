package com.pavelkovachev.sportsinfo.persistence.model.leagues;

import java.util.List;

import io.reactivex.Single;

public interface LeaguesRepository {

    void insertLeagues(List<LeaguesModel> leaguesModelList);

    void insertLeague(LeaguesModel leaguesModel);

    void deleteLeague(LeaguesModel leaguesModel);

    Single<List<LeaguesModel>> getAllLeagues();

}