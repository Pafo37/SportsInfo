package com.pavelkovachev.sportsinfo.persistence.model.leagues;

import java.util.List;

public interface LeaguesRepository {

    void insertLeagues(List<LeaguesModel> leaguesModelList);

    void insertLeague(LeaguesModel leaguesModel);

    void deleteLeague(LeaguesModel leaguesModel);

    void getAllLeagues();

}