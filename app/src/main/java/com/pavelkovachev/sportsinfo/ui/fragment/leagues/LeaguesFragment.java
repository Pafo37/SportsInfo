package com.pavelkovachev.sportsinfo.ui.fragment.leagues;

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
}