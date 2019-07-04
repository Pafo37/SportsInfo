package com.pavelkovachev.sportsinfo.ui.fragment.teamdetails;

import android.arch.lifecycle.MutableLiveData;

import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.teams.TeamsListResponse;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModel;
import com.pavelkovachev.sportsinfo.services.TeamDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class TeamDetailsViewModel extends BaseViewModel {

    @Inject
    public TeamDetailsViewModel() {
    }

    @Inject
    SportsApiService apiService;

    @Inject
    TeamDbService teamDbService;

    private MutableLiveData<TeamModel> teamDetails = new MutableLiveData<>();
    private MutableLiveData<String> teamLogo = new MutableLiveData<>();
    private MutableLiveData<String> sport = new MutableLiveData<>();
    private MutableLiveData<String> teamName = new MutableLiveData<>();
    private MutableLiveData<String> country = new MutableLiveData<>();
    private MutableLiveData<String> yearFormed = new MutableLiveData<>();
    private MutableLiveData<String> description = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<String> getTeamLogo() {
        return teamLogo;
    }

    public MutableLiveData<String> getSport() {
        return sport;
    }

    public MutableLiveData<String> getTeamName() {
        return teamName;
    }

    public MutableLiveData<String> getCountry() {
        return country;
    }

    public MutableLiveData<String> getYearFormed() {
        return yearFormed;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public void getTeamDetails(String id) {
        subscribeSingle(apiService.getTeamDetails(id), new SingleObserver<TeamsListResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                //NOT USED
            }

            @Override
            public void onSuccess(TeamsListResponse teamsListResponse) {
                if (teamsListResponse.getTeams() != null) {
                    teamDetails.setValue(TeamModel.convertToTeamModel(teamsListResponse.getTeams().get(0)));
                    teamLogo.setValue(teamDetails.getValue().getTeamLogo());
                    sport.setValue(teamDetails.getValue().getSportName());
                    teamName.setValue(teamDetails.getValue().getTeamName());
                    country.setValue(teamDetails.getValue().getTeamCountry());
                    yearFormed.setValue(teamDetails.getValue().getTeamYearFormed());
                    description.setValue(teamDetails.getValue().getTeamDescription());
                    teamDbService.insertTeam(teamDetails.getValue());
                }
            }

            @Override
            public void onError(Throwable e) {
                isErrorShown.setValue(true);
            }
        });
    }
}