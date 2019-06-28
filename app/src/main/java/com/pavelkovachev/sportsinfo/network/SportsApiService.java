package com.pavelkovachev.sportsinfo.network;

import com.pavelkovachev.sportsinfo.network.response.events.EventsListResponse;
import com.pavelkovachev.sportsinfo.network.response.leaguedetails.LeagueDetailsListResponse;
import com.pavelkovachev.sportsinfo.network.response.leagues.LeaguesListResponse;
import com.pavelkovachev.sportsinfo.network.response.players.PlayersListResponse;
import com.pavelkovachev.sportsinfo.network.response.sports.SportsListResponse;
import com.pavelkovachev.sportsinfo.network.response.teams.TeamsListResponse;
import com.pavelkovachev.sportsinfo.network.response.tvevents.TvEventsListResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class SportsApiService {

    private ApiService apiService;

    @Inject
    public SportsApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<SportsListResponse> getSports() {
        return apiService.getSportsInfoApi().getSportsResponse();
    }

    public Single<LeaguesListResponse> getLeagues() {
        return apiService.getSportsInfoApi().getLeaguesResponse();
    }

    public Single<TeamsListResponse> getTeams(String leagueName) {
        return apiService.getSportsInfoApi().getTeamsResponse(leagueName);
    }

    public Single<PlayersListResponse> getPlayers(String teamId) {
        return apiService.getSportsInfoApi().getPlayersResponse(teamId);
    }

    public Single<LeagueDetailsListResponse> getLeagueDetails(String leagueId) {
        return apiService.getSportsInfoApi().getLeagueDetailsResponse(leagueId);
    }

    public Single<TeamsListResponse> getTeamDetails(String teamId) {
        return apiService.getSportsInfoApi().getTeamDetailsResponse(teamId);
    }

    public Single<EventsListResponse> getEvents(String date) {
        return apiService.getSportsInfoApi().getEventsResponse(date);
    }

    public Single<TvEventsListResponse> getTvEvents(String date) {
        return apiService.getSportsInfoApi().getTVEventsResponse(date);
    }
}