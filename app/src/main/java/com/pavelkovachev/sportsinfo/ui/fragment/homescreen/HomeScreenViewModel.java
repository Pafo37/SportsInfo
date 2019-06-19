package com.pavelkovachev.sportsinfo.ui.fragment.homescreen;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.annimon.stream.Stream;
import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.sports.SportsListResponse;
import com.pavelkovachev.sportsinfo.network.response.sports.SportsResponse;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModel;
import com.pavelkovachev.sportsinfo.services.SportDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class HomeScreenViewModel extends BaseViewModel {

    private MutableLiveData<List<SportModel>> sportModelList = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();
    private MutableLiveData<String> sportName = new MutableLiveData<>();

    @Inject
    SportsApiService apiService;

    @Inject
    SportDbService sportDbService;

    public MutableLiveData<List<SportModel>> getSportsList() {
        return sportModelList;
    }

    @Inject
    public HomeScreenViewModel() {
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<String> getSportName(){
        return sportName;
    }

    void getSports() {

        subscribeSingle(apiService.getSports(), new SingleObserver<SportsListResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                //NOT USED
            }

            @Override
            public void onSuccess(SportsListResponse sportsListResponse) {
                if (sportsListResponse != null) {
                    List<SportModel> sportModels = new ArrayList<>();
                    Stream.of(sportsListResponse.getSports()).forEach(
                            sportsResponse ->
                                    sportModels.add(SportModel.convertToSportModel((SportsResponse) sportsResponse)));

                    sportDbService.insertSports(sportModels);
                    sportModelList.setValue(sportModels);
                }
            }

            @Override
            public void onError(Throwable e) {
                isErrorShown.postValue(true);
            }
        });
    }

    public void onSportClicked(SportModel sportModel) {
        sportName.setValue(sportModel.getSportName());
    }
}