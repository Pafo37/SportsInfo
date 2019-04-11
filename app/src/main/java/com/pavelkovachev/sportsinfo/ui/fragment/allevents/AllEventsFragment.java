package com.pavelkovachev.sportsinfo.ui.fragment.allevents;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class AllEventsFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_all_events;
    }

    @Override
    protected Class<AllEventsViewModel> getViewModel() {
        return AllEventsViewModel.class;
    }
}