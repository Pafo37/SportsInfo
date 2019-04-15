package com.pavelkovachev.sportsinfo.persistence.model.team;

import java.util.List;

import io.reactivex.Single;

public interface TeamRepository {

    void insertTeams(List<TeamModel> teamModelList);

    void insertTeam(TeamModel teamModel);

    void deleteTeam(TeamModel teamModel);

    Single<List<TeamModel>> getAllTeams();

}