package com.pavelkovachev.sportsinfo.services;

import com.pavelkovachev.sportsinfo.AppExecutor;
import com.pavelkovachev.sportsinfo.persistence.model.teams.TeamsModel;
import com.pavelkovachev.sportsinfo.persistence.model.teams.TeamsModelDao;
import com.pavelkovachev.sportsinfo.persistence.model.teams.TeamsRepository;

import java.util.List;

import io.reactivex.Single;

public class TeamsService implements TeamsRepository {

    private final TeamsModelDao teamsModelDao;
    private final AppExecutor executor;

    public TeamsService(TeamsModelDao teamsModelDao, AppExecutor executor) {
        this.teamsModelDao = teamsModelDao;
        this.executor = executor;
    }

    @Override
    public void insertTeams(List<TeamsModel> teamsModelList) {
        executor.execute(() -> teamsModelDao.insertTeams(teamsModelList));
    }

    @Override
    public void insertTeam(TeamsModel teamsModel) {
        executor.execute(() -> teamsModelDao.insertTeam(teamsModel));
    }

    @Override
    public void deleteTeam(TeamsModel teamsModel) {
        executor.execute(() -> teamsModelDao.deleteTeam(teamsModel));
    }

    @Override
    public Single<List<TeamsModel>> getAllTeams() {
        return teamsModelDao.getAllTeams();
    }
}