package com.pavelkovachev.sportsinfo.ui.fragment.leagues;


import android.util.Log;

import com.pavelkovachev.sportsinfo.persistence.model.leagues.LeaguesModel;
import com.pavelkovachev.sportsinfo.services.LeaguesServices;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LeaguesViewModel extends BaseViewModel {

    @Inject
    LeaguesServices leaguesServices;

    public void getAllLeagues() {
        subscribeSingle(leaguesServices.getAllLeagues(), new SingleObserver<List<LeaguesModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<LeaguesModel> leaguesModelList) {
                Log.d("ALABALA", "Banan");
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
