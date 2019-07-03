package com.pavelkovachev.sportsinfo.ui.fragment.leagues;


import android.arch.lifecycle.MutableLiveData;

import com.annimon.stream.Stream;
import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.leagues.LeaguesListResponse;
import com.pavelkovachev.sportsinfo.persistence.model.league.LeagueModel;
import com.pavelkovachev.sportsinfo.persistence.model.team.TeamModel;
import com.pavelkovachev.sportsinfo.services.LeagueDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LeaguesViewModel extends BaseViewModel {

    @Inject
    SportsApiService apiService;

    @Inject
    LeagueDbService leagueDbService;

    @Inject
    public LeaguesViewModel() {
    }

    private MutableLiveData<List<LeagueModel>> leaguesModelList = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();
    private MutableLiveData<String> leagueName = new MutableLiveData<>();
    private MutableLiveData<String> leagueId = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLeagueClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> isSeeMoreClicked = new MutableLiveData<>();

    public MutableLiveData<List<LeagueModel>> getLeaguesList() {
        return leaguesModelList;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<Boolean> getIsLeagueClicked() {
        return isLeagueClicked;
    }

    public MutableLiveData<String> getLeagueId() {
        return leagueId;
    }

    public MutableLiveData<Boolean> getIsSeeMoreClicked() {
        return isSeeMoreClicked;
    }

    public MutableLiveData<String> getLeagueName() {
        return leagueName;
    }

    public void getLeagues(String sportName) {
        subscribeSingle(Single.zip(apiService.getLeagues(),
                leagueDbService.getAllLeagues(),
                this::getDataFromApiAndDb), new SingleObserver<List<LeagueModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                //NOT USED
            }

            @Override
            public void onSuccess(List<LeagueModel> leagueModelList) {
                List<LeagueModel> leagueModels = new ArrayList<>();
                Stream.of(leagueModelList)
                        .filter(sports -> sports.getLeagueSport().equals(sportName))
                        .forEach(leagueModels::add);
                leagueDbService.insertLeagues(leagueModels);
                leaguesModelList.setValue(leagueModels);
            }

            @Override
            public void onError(Throwable e) {
                isErrorShown.postValue(true);
            }
        });
    }

    private List<LeagueModel> getDataFromApiAndDb(LeaguesListResponse leaguesListResponse,
                                                  List<LeagueModel> leagueModelList) {
        List<LeagueModel> leagueModels = new ArrayList<>();
        if (leaguesListResponse.getLeagues() != null) {
            Stream.of(leaguesListResponse.getLeagues())
                    .forEach(leaguesResponse ->
                            leagueModels.add(LeagueModel.convertToLeagueModel(leaguesResponse)));
        } else {
            isErrorShown.postValue(true);
            return leagueModelList;
        }
        return leagueModels;
    }

    public void onLeagueClicked(LeagueModel leagueModel) {
        leagueName.setValue(leagueModel.getLeagueName());
        isLeagueClicked.setValue(true);
    }

    public void onSeeMoreClicked(LeagueModel leagueModel) {
        leagueId.setValue(leagueModel.getLeagueId());
        isSeeMoreClicked.setValue(true);
    }
}