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

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LeaguesViewModel extends BaseViewModel {

    private MutableLiveData<List<LeagueModel>> leaguesModelList = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();
    private MutableLiveData<String> leagueName = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLeagueClicked = new MutableLiveData<>();

    public MutableLiveData<List<LeagueModel>> getLeaguesList() {
        return leaguesModelList;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<Boolean> getIsLeagueClicked() {
        return isLeagueClicked;
    }

    public MutableLiveData<String> getLeagueName() {
        return leagueName;
    }

    @Inject
    SportsApiService apiService;

    @Inject
    LeagueDbService leagueDbService;

    @Inject
    public LeaguesViewModel() {
    }

    public void getLeagues(String sportName) {
        subscribeSingle(apiService.getLeagues(), new SingleObserver<LeaguesListResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                //NOT USED
            }

            @Override
            public void onSuccess(LeaguesListResponse leaguesListResponse) {
                if (leaguesListResponse != null) {
                    List<LeagueModel> leagueModels = new ArrayList<>();
                    Stream.of(leaguesListResponse.getLeagues())
                            .filter(sports -> sports.getStrSport().equals(sportName))
                            .forEach(leaguesResponse ->
                                    leagueModels.add(LeagueModel.convertToLeagueModel(leaguesResponse)));
                    leagueDbService.insertLeagues(leagueModels);
                    leaguesModelList.setValue(leagueModels);
                }
            }

            @Override
            public void onError(Throwable e) {
                isErrorShown.postValue(true);
            }
        });
    }

    public void onLeagueClicked(LeagueModel leagueModel) {
        leagueName.setValue(leagueModel.getLeagueName());
        isLeagueClicked.setValue(true);
    }
}