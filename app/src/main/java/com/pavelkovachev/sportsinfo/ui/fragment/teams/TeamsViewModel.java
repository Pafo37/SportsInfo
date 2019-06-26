package com.pavelkovachev.sportsinfo.ui.fragment.teams;

import android.arch.lifecycle.MutableLiveData;

import com.annimon.stream.Stream;
import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.teams.TeamsListResponse;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModel;
import com.pavelkovachev.sportsinfo.services.TeamDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class TeamsViewModel extends BaseViewModel {

    private MutableLiveData<List<TeamModel>> teamsList = new MutableLiveData<>();

    public MutableLiveData<List<TeamModel>> getTeamsList() {
        return teamsList;
    }

    @Inject
    SportsApiService apiService;

    @Inject
    TeamDbService teamDbService;

    @Inject
    public TeamsViewModel() {
    }

    public void getTeams(String leagueName) {
        subscribeSingle(apiService.getTeams(leagueName), new SingleObserver<TeamsListResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(TeamsListResponse teamsListResponse) {
                if (teamsListResponse != null) {
                    List<TeamModel> teamModels = new ArrayList<>();
                    Stream.of(teamsListResponse.getTeams())
                            .forEach(teamsResponse ->
                                    teamModels.add(TeamModel.convertToTeamModel(teamsResponse)));
                    teamDbService.insertTeams(teamModels);
                    teamsList.postValue(teamModels);
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}