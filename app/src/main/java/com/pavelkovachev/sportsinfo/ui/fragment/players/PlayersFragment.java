package com.pavelkovachev.sportsinfo.ui.fragment.players;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentPlayersBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class PlayersFragment extends BaseFragment<PlayersViewModel, FragmentPlayersBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_players;
    }

    @Override
    protected Class<PlayersViewModel> getViewModel() {
        return PlayersViewModel.class;
    }
}