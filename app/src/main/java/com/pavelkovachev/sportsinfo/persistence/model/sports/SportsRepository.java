package com.pavelkovachev.sportsinfo.persistence.model.sports;

import java.util.List;

public interface SportsRepository {

    void insertSports(List<SportsModel> sportsModelList);

    void insertSport(SportsModel sportsModel);

    void deleteSport(SportsModel sportsModel);

}