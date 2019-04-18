package com.pavelkovachev.sportsinfo;

import com.pavelkovachev.sportsinfo.network.response.sports.SportsResponse;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModel;

public class SportsConverter {

    public static SportModel convertToSportModel(SportsResponse sportsResponse) {

        return new SportModel(sportsResponse.getIdSport(), sportsResponse.getStrSport(),
                sportsResponse.getStrSportThumb(), sportsResponse.getStrSportDescription());
    }
}
