package com.pavelkovachev.sportsinfo.ui.fragment.leaguedetails;

import android.arch.lifecycle.MutableLiveData;

import com.annimon.stream.Stream;
import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.leaguedetails.LeagueDetailsListResponse;
import com.pavelkovachev.sportsinfo.persistence.model.leaguedetails.LeagueDetailsModel;
import com.pavelkovachev.sportsinfo.services.LeagueDetailsDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LeagueDetailsViewModel extends BaseViewModel {

    @Inject
    LeagueDetailsDbService leagueDetailsDbService;
    @Inject
    SportsApiService apiService;

    @Inject
    public LeagueDetailsViewModel() {
    }

    private MutableLiveData<LeagueDetailsModel> leagueDetailsModel = new MutableLiveData<>();
    private MutableLiveData<String> sportName = new MutableLiveData<>();
    private MutableLiveData<String> leagueName = new MutableLiveData<>();
    private MutableLiveData<String> country = new MutableLiveData<>();
    private MutableLiveData<String> yearFormed = new MutableLiveData<>();
    private MutableLiveData<String> description = new MutableLiveData<>();
    private MutableLiveData<String> leagueLogo = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<String> getLeagueLogo() {
        return leagueLogo;
    }

    public MutableLiveData<String> getSportName() {
        return sportName;
    }

    public MutableLiveData<String> getLeagueName() {
        return leagueName;
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

    public void getLeagueDetails(String id) {
        subscribeSingle(apiService.getLeagueDetails(id),
                new SingleObserver<LeagueDetailsListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NOT USED
                    }

                    @Override
                    public void onSuccess(LeagueDetailsListResponse leagueDetailsListResponse) {
                        if (leagueDetailsListResponse.getLeagues() != null) {
                            setProgressBarVisibility(false);
                            leagueDetailsModel.setValue(LeagueDetailsModel.convertToLeagueDetailsModel(leagueDetailsListResponse.getLeagues().get(0)));
                            sportName.setValue(leagueDetailsModel.getValue().getSportName());
                            leagueName.setValue(leagueDetailsModel.getValue().getLeagueName());
                            country.setValue(leagueDetailsModel.getValue().getCountry());
                            yearFormed.setValue(leagueDetailsModel.getValue().getYearFormed());
                            description.setValue(leagueDetailsModel.getValue().getDescription());
                            leagueLogo.setValue(leagueDetailsModel.getValue().getLeagueLogo());
                            leagueDetailsDbService.insert(leagueDetailsModel.getValue());
                        } else {
                            isErrorShown.setValue(true);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        setProgressBarVisibility(false);
                        isErrorShown.setValue(true);
                    }
                });
    }
}