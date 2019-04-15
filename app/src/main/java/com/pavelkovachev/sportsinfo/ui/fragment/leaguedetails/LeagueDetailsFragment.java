package com.pavelkovachev.sportsinfo.ui.fragment.leaguedetails;

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
}