package com.pavelkovachev.sportsinfo.ui.fragment.teamdetails;

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
}