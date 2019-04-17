package com.pavelkovachev.sportsinfo.ui.fragment.homescreen;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentHomescreenBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class HomeScreenFragment extends BaseFragment<HomeScreenViewModel, FragmentHomescreenBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_homescreen;
    }

    @Override
    protected Class<HomeScreenViewModel> getViewModel() {
        return HomeScreenViewModel.class;
    }
}