package com.pavelkovachev.sportsinfo.ui.fragment.teamdetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentTeamDetailsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class TeamDetailsFragment extends BaseFragment<TeamDetailsViewModel, FragmentTeamDetailsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_team_details;
    }

    @Override
    protected Class<TeamDetailsViewModel> getViewModel() {
        return TeamDetailsViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String teamId = getArguments().getString(Constants.BUNDLE_TEAM_ID);
        String teamName = getArguments().getString(Constants.BUNDLE_TEAM_NAME);
        getActivity().setTitle(teamName);
        viewModel.getTeamDetails(teamId);
    }
}