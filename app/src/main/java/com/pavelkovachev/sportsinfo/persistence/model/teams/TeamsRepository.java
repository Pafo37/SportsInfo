package com.pavelkovachev.sportsinfo.persistence.model.teams;

import java.util.List;

public interface TeamsRepository {

    void insertTeams(List<TeamsModel> teamsModelList);

    void insertTeam(TeamsModel teamsModel);

    void deleteTeam(TeamsModel teamsModel);

    void getAllTeams();

}