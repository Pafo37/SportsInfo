package com.pavelkovachev.sportsinfo.ui.fragment.allevents;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentAllEventsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class AllEventsFragment extends BaseFragment<AllEventsViewModel, FragmentAllEventsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_all_events;
    }

    @Override
    protected Class<AllEventsViewModel> getViewModel() {
        return AllEventsViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getEventDate().setValue(getArguments().getString(Constants.BUNDLE_DATE));
        viewModel.getAllEvents();
        viewModel.getIsErrorShown().observe(this, isError -> {
            if (isError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });
    }
}