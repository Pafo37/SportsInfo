package com.pavelkovachev.sportsinfo.ui.fragment.tvevents;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentTvEventsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class TvEventsFragment extends BaseFragment<TvEventsViewModel, FragmentTvEventsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tv_events;
    }

    @Override
    protected Class<TvEventsViewModel> getViewModel() {
        return TvEventsViewModel.class;
    }
}