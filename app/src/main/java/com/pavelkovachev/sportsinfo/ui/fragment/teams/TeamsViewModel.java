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

    @Inject
    SportsApiService apiService;

    @Inject
    TeamDbService teamDbService;

    @Inject
    public TeamsViewModel() {
    }

    private MutableLiveData<List<TeamModel>> teamsList = new MutableLiveData<>();
    private MutableLiveData<String> teamId = new MutableLiveData<>();
    private MutableLiveData<Boolean> isTeamClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> isSeeMoreClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsSeeMoreClicked() {
        return isSeeMoreClicked;
    }

    public MutableLiveData<List<TeamModel>> getTeamsList() {
        return teamsList;
    }

    public MutableLiveData<Boolean> getIsTeamClicked() {
        return isTeamClicked;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<String> getTeamId() {
        return teamId;
    }

    public void getTeams(String leagueName) {
        subscribeSingle(apiService.getTeams(leagueName), new SingleObserver<TeamsListResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                //NOT USED
            }

            @Override
            public void onSuccess(TeamsListResponse teamsListResponse) {
                if (teamsListResponse.getTeams() != null) {
                    List<TeamModel> teamModels = new ArrayList<>();
                    Stream.of(teamsListResponse.getTeams())
                            .forEach(teamsResponse ->
                                    teamModels.add(TeamModel.convertToTeamModel(teamsResponse)));
                    teamDbService.insertTeams(teamModels);
                    teamsList.postValue(teamModels);
                } else {
                    isErrorShown.setValue(true);
                }
            }

            @Override
            public void onError(Throwable e) {
                isErrorShown.setValue(true);
            }
        });
    }

    public void onTeamClicked(TeamModel teamModel) {
        teamId.setValue(teamModel.getTeamId());
        isTeamClicked.setValue(true);
    }

    public void onSeeMoreClicked(TeamModel teamModel) {
        teamId.setValue(teamModel.getTeamId());
        isSeeMoreClicked.setValue(true);
    }
}