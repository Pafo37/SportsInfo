package com.pavelkovachev.sportsinfo.bindings;

import android.databinding.BindingAdapter;

import com.pavelkovachev.sportsinfo.view.LoadingView;

public class LoadingViewBindings {

    @BindingAdapter("setProgressBarVisibility")
    public static void setProgressBarVisibility(LoadingView loadingView, boolean isVisible) {
        loadingView.setProgressBarVisibility(isVisible);
    }

    @BindingAdapter("setTextViewVisibility")
    public static void setTextViewVisibility(LoadingView loadingView, boolean isVisible) {
        loadingView.setTextViewVisibility(isVisible);
    }
}