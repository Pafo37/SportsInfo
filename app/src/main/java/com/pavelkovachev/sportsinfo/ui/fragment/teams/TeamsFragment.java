package com.pavelkovachev.sportsinfo.ui.fragment.teams;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class TeamsFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_teams;
    }

    @Override
    protected Class<TeamsViewModel> getViewModel() {
        return TeamsViewModel.class;
    }
}