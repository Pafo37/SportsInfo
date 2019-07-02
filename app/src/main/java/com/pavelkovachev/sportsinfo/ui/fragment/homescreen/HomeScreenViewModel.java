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

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

public class HomeScreenViewModel extends BaseViewModel {

    @Inject
    SportsApiService apiService;

    @Inject
    SportDbService sportDbService;

    @Inject
    public HomeScreenViewModel() {
    }

    private MutableLiveData<List<SportModel>> sportModelList = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();
    private MutableLiveData<String> sportName = new MutableLiveData<>();
    private MutableLiveData<Boolean> isSportClicked = new MutableLiveData<>();

    public MutableLiveData<List<SportModel>> getSportsList() {
        return sportModelList;
    }

    public MutableLiveData<Boolean> getIsSportClicked() {
        return isSportClicked;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<String> getSportName() {
        return sportName;
    }

    public void getSports() {
        subscribeSingle(
                Single.zip(
                        apiService.getSports().onErrorReturnItem(new SportsListResponse()),
                        sportDbService.getAllSports(),
                        this::getDataFromDbAndApi), new SingleObserver<List<SportModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<SportModel> sportList) {
                        sportDbService.insertSports(sportList);
                        sportModelList.setValue(sportList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isErrorShown.postValue(true);
                    }
                }
        );
    }

    private List<SportModel> getDataFromDbAndApi(SportsListResponse sportsListResponse, List<SportModel> sportModelList) {
        List<SportModel> sportModels = new ArrayList<>();
        if (sportsListResponse.getSports() != null) {
            Stream.of(sportsListResponse.getSports()).
                    forEach(sportsResponse ->
                            sportModels.add(SportModel.convertToSportModel(sportsResponse)));
        } else {
            if (sportModelList.size() == 0) {
                isErrorShown.postValue(true);
            }
            return sportModelList;
        }
        if (sportModels.size() > sportModelList.size()) {
            return sportModels;
        }
        return sportModels;
    }

    public void onSportClicked(SportModel sportModel) {
        sportName.setValue(sportModel.getSportName());
        isSportClicked.setValue(true);
    }
}