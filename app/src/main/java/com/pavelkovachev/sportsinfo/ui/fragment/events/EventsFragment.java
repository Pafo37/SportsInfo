package com.pavelkovachev.sportsinfo.ui.fragment.events;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class EventsFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_events;
    }

    @Override
    protected Class<EventsViewModel> getViewModel() {
        return EventsViewModel.class;
    }
}