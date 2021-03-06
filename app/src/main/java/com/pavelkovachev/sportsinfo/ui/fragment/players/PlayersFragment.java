package com.pavelkovachev.sportsinfo.ui.fragment.players;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentPlayerDetailsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class PlayersFragment extends BaseFragment<PlayersViewModel, FragmentPlayerDetailsBinding> {

    private String teamId;
    private String teamName;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_players;
    }

    @Override
    protected Class<PlayersViewModel> getViewModel() {
        return PlayersViewModel.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teamId = getArguments().getString(Constants.BUNDLE_TEAM_ID);
        teamName = getArguments().getString(Constants.BUNDLE_TEAM_NAME);
        viewModel.getPlayers(teamId);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        getActivity().setTitle(teamName);

        viewModel.getIsErrorShown().observe(this, onError -> {
            if (onError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });

        viewModel.getIsPlayerClicked().observe(this, isClicked -> {
            if (isClicked) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BUNDLE_PLAYER_ID, viewModel.getPlayerId().getValue());
                bundle.putString(Constants.BUNDLE_TEAM_ID, teamId);
                bundle.putString(Constants.BUNDLE_PLAYER_NAME, viewModel.getPlayerName().getValue());
                viewModel.getIsPlayerClicked().setValue(false);
                navController.navigate(R.id.action_playersFragment_to_playerDetailsFragment, bundle);
            }
        });
    }
}