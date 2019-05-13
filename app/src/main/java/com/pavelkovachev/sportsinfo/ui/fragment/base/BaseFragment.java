package com.pavelkovachev.sportsinfo.ui.fragment.base;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pavelkovachev.sportsinfo.App;
import com.pavelkovachev.sportsinfo.BR;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.dagger.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<V extends ViewModel, B extends ViewDataBinding> extends Fragment {

    protected V viewModel;
    protected B binding;

    @Inject
    ViewModelFactory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setVariable(BR.viewModel, viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.executePendingBindings();
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    protected abstract Class<V> getViewModel();

    protected void showErrorDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(message);
        builder.setNeutralButton(getString(R.string.ok_message), (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}