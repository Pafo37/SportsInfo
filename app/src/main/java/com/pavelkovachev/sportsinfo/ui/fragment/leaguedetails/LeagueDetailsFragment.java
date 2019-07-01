package com.pavelkovachev.sportsinfo.ui.fragment.leaguedetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentLeagueDetailsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class LeagueDetailsFragment extends BaseFragment<LeagueDetailsViewModel, FragmentLeagueDetailsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_league_details;
    }

    @Override
    protected Class<LeagueDetailsViewModel> getViewModel() {
        return LeagueDetailsViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String leagueId = getArguments().getString(Constants.BUNDLE_LEAGUE_ID);
        viewModel.getLeagueDetails(leagueId);

        viewModel.getIsErrorShown().observe(this, isError -> {
            if (isError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });
    }
}