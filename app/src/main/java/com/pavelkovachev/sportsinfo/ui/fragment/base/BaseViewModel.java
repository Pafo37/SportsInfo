package com.pavelkovachev.sportsinfo.ui.fragment.base;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModel;

import com.pavelkovachev.sportsinfo.App;
import com.pavelkovachev.sportsinfo.R;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseViewModel extends ViewModel {

    protected <T> void subscribeSingle(Single<T> singleObservable, SingleObserver<T> singleObserver) {
        singleObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(singleObserver);
    }

    protected void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(App.getInstance().getApplicationContext())
                .setTitle(App.getInstance().getResources().getString(R.string.error_message_title))
                .setMessage(App.getInstance().getResources().getString(R.string.error_message_description));
        builder.setNeutralButton(App.getInstance().getResources().getString(R.string.ok_message), (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}