package com.pavelkovachev.sportsinfo.dagger.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.pavelkovachev.sportsinfo.dagger.ViewModelFactory;
import com.pavelkovachev.sportsinfo.dagger.ViewModelKey;
import com.pavelkovachev.sportsinfo.ui.activity.main.MainActivity;
import com.pavelkovachev.sportsinfo.ui.fragment.allevents.AllEventsFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.allevents.AllEventsViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.events.EventsFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.events.EventsViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.homescreen.HomeScreenFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.homescreen.HomeScreenViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.leaguedetails.LeagueDetailsFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.leaguedetails.LeagueDetailsViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.leagues.LeaguesFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.leagues.LeaguesViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.playerdetails.PlayerDetailViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.playerdetails.PlayerDetailsFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.players.PlayersFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.players.PlayersViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.teamdetails.TeamDetailsFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.teamdetails.TeamDetailsViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.teams.TeamsFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.teams.TeamsViewModel;
import com.pavelkovachev.sportsinfo.ui.fragment.tvevents.TvEventsFragment;
import com.pavelkovachev.sportsinfo.ui.fragment.tvevents.TvEventsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector
    abstract LeaguesFragment contributesLeaguesFragment();

    @ContributesAndroidInjector
    abstract AllEventsFragment contributesAllEventsFragment();

    @ContributesAndroidInjector
    abstract EventsFragment contributesEventsFragment();

    @ContributesAndroidInjector
    abstract HomeScreenFragment contributesHomescreenFragment();

    @ContributesAndroidInjector
    abstract LeagueDetailsFragment contributesLeaguesDetailsFragment();

    @ContributesAndroidInjector
    abstract PlayerDetailsFragment contributesPlayerDetailsFragment();

    @ContributesAndroidInjector
    abstract PlayersFragment contributesPlayersFragment();

    @ContributesAndroidInjector
    abstract TeamDetailsFragment contributesTeamDetailsFragment();

    @ContributesAndroidInjector
    abstract TeamsFragment contributesTeamFragment();

    @ContributesAndroidInjector
    abstract TvEventsFragment contributesTvEventsFragment();

    @Binds
    @IntoMap
    @ViewModelKey(AllEventsViewModel.class)
    abstract ViewModel bindAllEventsViewModel(AllEventsViewModel allEventsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(EventsViewModel.class)
    abstract ViewModel bindEventsViewModel(EventsViewModel eventsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenViewModel.class)
    abstract ViewModel bindHomeScreenViewModel(HomeScreenViewModel homeScreenViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LeagueDetailsViewModel.class)
    abstract ViewModel bindLeagueDetailsViewModel(LeagueDetailsViewModel leagueDetailsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LeaguesViewModel.class)
    abstract ViewModel bindLeaguesViewModel(LeaguesViewModel leaguesViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PlayerDetailViewModel.class)
    abstract ViewModel bindPlayerDetailsViewModel(PlayerDetailViewModel playerDetailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PlayersViewModel.class)
    abstract ViewModel bindPlayersViewModel(PlayersViewModel playersViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TeamDetailsViewModel.class)
    abstract ViewModel bindTeamDetailsViewModel(TeamDetailsViewModel teamDetailsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TeamsViewModel.class)
    abstract ViewModel bindTeamsViewModel(TeamsViewModel teamsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TvEventsViewModel.class)
    abstract ViewModel bindTvEventsViewModel(TvEventsViewModel tvEventsViewModel);
}