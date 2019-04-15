package com.pavelkovachev.sportsinfo.ui.fragment.leagues;


import com.pavelkovachev.sportsinfo.services.LeaguesServices;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import javax.inject.Inject;

public class LeaguesViewModel extends BaseViewModel {

    @Inject
    LeaguesServices leaguesServices;

    @Inject
    public LeaguesViewModel() {
    }
}