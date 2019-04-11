package com.pavelkovachev.sportsinfo.ui.fragment.teamdetails;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class TeamDetailsFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_team_details;
    }

    @Override
    protected Class<TeamDetailViewModel> getViewModel() {
        return TeamDetailViewModel.class;
    }
}