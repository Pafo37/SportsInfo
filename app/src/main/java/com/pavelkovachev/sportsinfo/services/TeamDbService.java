package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModel;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class TeamDbService implements TeamRepository {

    private final TeamModelDao teamModelDao;
    private final AppExecutor executor;

    @Inject
    public TeamDbService(TeamModelDao teamModelDao, AppExecutor executor) {
        this.teamModelDao = teamModelDao;
        this.executor = executor;
    }

    @Override
    public void insertTeams(List<TeamModel> teamModelList) {
        executor.execute(() -> teamModelDao.insertTeams(teamModelList));
    }

    @Override
    public void insertTeam(TeamModel teamModel) {
        executor.execute(() -> teamModelDao.insertTeam(teamModel));
    }

    @Override
    public void deleteTeam(TeamModel teamModel) {
        executor.execute(() -> teamModelDao.deleteTeam(teamModel));
    }

    @Override
    public Single<List<TeamModel>> getAllTeams() {
        return teamModelDao.getAllTeams();
    }
}