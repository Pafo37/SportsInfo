package com.pavelkovachev.sportsinfo.persistence.model.league;

import java.util.List;

import io.reactivex.Single;

public interface LeagueRepository {

    void insertLeagues(List<LeagueModel> leagueModelList);

    void insertLeague(LeagueModel leagueModel);

    void deleteLeague(LeagueModel leagueModel);

    Single<List<LeagueModel>> getAllLeagues();

}