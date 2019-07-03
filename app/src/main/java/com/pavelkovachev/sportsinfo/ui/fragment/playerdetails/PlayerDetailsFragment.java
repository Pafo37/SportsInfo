package com.pavelkovachev.sportsinfo.ui.fragment.playerdetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.pavelkovachev.sportsinfo.Constants;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String playerId = getArguments().getString(Constants.BUNDLE_PLAYER_ID);
        String teamId = getArguments().getString(Constants.BUNDLE_TEAM_ID);
        viewModel.getPlayerDetails(playerId, teamId);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getIsErrorShown().observe(this, onError -> {
            if (onError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });
    }
}