package com.pavelkovachev.sportsinfo.ui.fragment.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.pavelkovachev.sportsinfo.view.LoadingView;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseViewModel extends ViewModel {

    private MutableLiveData<Boolean> progressBarVisibility = new MutableLiveData<>();
    private MutableLiveData<Boolean> textViewVisibility = new MutableLiveData<>();

    public MutableLiveData<Boolean> getTextViewVisibility() {
        return textViewVisibility;
    }

    public MutableLiveData<Boolean> getProgressBarVisibility() {
        return progressBarVisibility;
    }

    protected <T> void subscribeSingle(Single<T> singleObservable, SingleObserver<T> singleObserver) {
        setProgressBarVisibility(true);
        setTextViewVisibility(false);
        singleObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(singleObserver);
    }

    protected void setProgressBarVisibility(boolean isVisible) {
        progressBarVisibility.postValue(isVisible);
    }

    protected void setTextViewVisibility(boolean isVisible) {
        textViewVisibility.postValue(isVisible);
    }

}