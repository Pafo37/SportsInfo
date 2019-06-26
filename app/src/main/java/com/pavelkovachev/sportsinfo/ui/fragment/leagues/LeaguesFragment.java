package com.pavelkovachev.sportsinfo.ui.fragment.leagues;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentLeaguesBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class LeaguesFragment extends BaseFragment<LeaguesViewModel, FragmentLeaguesBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_leagues;
    }

    @Override
    protected Class<LeaguesViewModel> getViewModel() {
        return LeaguesViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String sportName = getArguments().getString(Constants.BUNDLE_SPORT_NAME);
        getActivity().setTitle(sportName);
        viewModel.getIsErrorShown().observe(this, isError -> {
            if (isError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });
        viewModel.getLeagues(sportName);
    }
}