package com.pavelkovachev.sportsinfo.network;

import com.pavelkovachev.sportsinfo.network.response.events.EventsListResponse;
import com.pavelkovachev.sportsinfo.network.response.leagues.LeaguesListResponse;
import com.pavelkovachev.sportsinfo.network.response.leagues.LeaguesResponse;
import com.pavelkovachev.sportsinfo.network.response.players.PlayersListResponse;
import com.pavelkovachev.sportsinfo.network.response.sports.SportsListResponse;
import com.pavelkovachev.sportsinfo.network.response.teams.TeamsListResponse;
import com.pavelkovachev.sportsinfo.network.response.teams.TeamsResponse;
import com.pavelkovachev.sportsinfo.network.response.tvevents.TvEventsListResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportsInfoApi {

    @GET("api/v1/json/1/all_sports.php")
    Single<SportsListResponse> getSportsResponse();

    @GET("api/v1/json/1/all_leagues.php")
    Single<LeaguesListResponse> getLeaguesResponse();

    @GET("api/v1/json/1/search_all_teams.php")
    Single<TeamsListResponse> getTeamsResponse(@Query("l") String leagueName);

    @GET("api/v1/json/1/lookup_all_players.php")
    Single<PlayersListResponse> getPlayersResponse(@Query("id") String teamName);

    @GET("api/v1/json/1/lookupleague.php")
    Single<LeaguesListResponse> getLeagueDetailsResponse(@Query("id") String leagueId);

    @GET("api/v1/json/1/lookupteam.php")
    Single<TeamsListResponse> getTeamDetailsResponse(@Query("id") String teamId);

    @GET("api/v1/json/1/lookupplayer.php")
    Single<PlayersListResponse> getPlayerDetailsResponse(@Query("id") String playerId);

    @GET("api/v1/json/1/eventsday.php")
    Single<EventsListResponse> getEventsResponse(@Query("d") String date);

    @GET("api/v1/json/1/eventstv.php")
    Single<TvEventsListResponse> getTVEventsResponse(@Query("d") String date);
}