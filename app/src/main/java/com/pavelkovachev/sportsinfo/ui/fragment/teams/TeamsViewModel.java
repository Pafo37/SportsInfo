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

import io.reactivex.Single;
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
    private MutableLiveData<String> teamName = new MutableLiveData<>();
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

    public MutableLiveData<String> getTeamName() {
        return teamName;
    }

    public void getTeams(String leagueName) {

        subscribeSingle(Single.zip(
                apiService.getTeams(leagueName).onErrorReturnItem(new TeamsListResponse()),
                teamDbService.getAllTeams(),
                this::getDataFromApiAndDb),
                new SingleObserver<List<TeamModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NOT USED
                    }

                    @Override
                    public void onSuccess(List<TeamModel> teamModelList) {
                        teamDbService.insertTeams(teamModelList);
                        teamsList.postValue(teamModelList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isErrorShown.setValue(true);
                    }
                });
    }

    private List<TeamModel> getDataFromApiAndDb(TeamsListResponse teamsListResponse,
                                                List<TeamModel> teamModelList) {
        List<TeamModel> teamModels = new ArrayList<>();
        if (teamsListResponse.getTeams() != null) {
            Stream.of(teamsListResponse.getTeams())
                    .forEach(teamsResponse ->
                            teamModels.add(TeamModel.convertToTeamModel(teamsResponse)));
        } else if (teamModelList.size() != 0) {
            return teamModelList;
        } else {
            throw new NullPointerException();
        }

        return teamModels;

    }

    public void onTeamClicked(TeamModel teamModel) {
        teamName.setValue(teamModel.getTeamName());
        teamId.setValue(teamModel.getTeamId());
        isTeamClicked.setValue(true);
    }

    public void onSeeMoreClicked(TeamModel teamModel) {
        teamName.setValue(teamModel.getTeamName());
        teamId.setValue(teamModel.getTeamId());
        isSeeMoreClicked.setValue(true);
    }
}