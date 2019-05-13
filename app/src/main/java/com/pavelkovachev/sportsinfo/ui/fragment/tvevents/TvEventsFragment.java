package com.pavelkovachev.sportsinfo.ui.fragment.tvevents;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentTvEventsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class TvEventsFragment extends BaseFragment<TvEventsViewModel, FragmentTvEventsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tv_events;
    }

    @Override
    protected Class<TvEventsViewModel> getViewModel() {
        return TvEventsViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            viewModel.getEventDate().setValue(getArguments().getString(Constants.BUNDLE_DATE));
        }
        viewModel.getTvEvents();
        viewModel.getIsErrorShown().observe(this, isError -> {
            if (isError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });
    }
}