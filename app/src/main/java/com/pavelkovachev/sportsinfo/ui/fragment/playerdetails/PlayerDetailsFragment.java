package com.pavelkovachev.sportsinfo.ui.fragment.playerdetails;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentPlayerDetailsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class PlayerDetailsFragment extends BaseFragment<PlayerDetailViewModel, FragmentPlayerDetailsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_player_details;
    }

    @Override
    protected Class<PlayerDetailViewModel> getViewModel() {
        return PlayerDetailViewModel.class;
    }
}