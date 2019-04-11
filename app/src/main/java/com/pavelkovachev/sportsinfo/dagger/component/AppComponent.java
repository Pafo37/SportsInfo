package com.pavelkovachev.sportsinfo.dagger.component;


import com.pavelkovachev.sportsinfo.dagger.modules.ApplicationModule;
import com.pavelkovachev.sportsinfo.ui.fragment.leagues.LeaguesViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {

    void inject(LeaguesViewModel leaguesViewModel);
}