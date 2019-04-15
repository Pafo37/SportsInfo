package com.pavelkovachev.sportsinfo.persistence.model.teams;

import java.util.List;

import io.reactivex.Single;

public interface TeamsRepository {

    void insertTeams(List<TeamsModel> teamsModelList);

    void insertTeam(TeamsModel teamsModel);

    void deleteTeam(TeamsModel teamsModel);

    Single<List<TeamsModel>> getAllTeams();

}