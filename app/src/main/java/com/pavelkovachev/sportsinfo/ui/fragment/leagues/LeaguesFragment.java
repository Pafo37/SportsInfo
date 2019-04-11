package com.pavelkovachev.sportsinfo.ui.fragment.leagues;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class LeaguesFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.item_leagues;
    }

    @Override
    protected Class<LeaguesViewModel> getViewModel() {
        return LeaguesViewModel.class;
    }
}