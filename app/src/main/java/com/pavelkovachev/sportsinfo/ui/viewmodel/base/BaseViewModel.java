package com.pavelkovachev.sportsinfo.ui.viewmodel.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseViewModel extends ViewModel {

    protected <T> void subscribeSingle(Single<T> singleObservable, SingleObserver<T> singleObserver) {
        singleObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(singleObserver);
    }
}