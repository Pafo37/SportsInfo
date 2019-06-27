package com.pavelkovachev.sportsinfo.ui.fragment.teams;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentTeamsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class TeamsFragment extends BaseFragment<TeamsViewModel, FragmentTeamsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_teams;
    }

    @Override
    protected Class<TeamsViewModel> getViewModel() {
        return TeamsViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String leagueName = getArguments().getString(Constants.BUNDLE_LEAGUE_NAME);
        NavController navController = Navigation.findNavController(view);
        viewModel.getTeams(leagueName);

        viewModel.getIsTeamClicked().observe(this, isClicked -> {
            if (isClicked) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BUNDLE_TEAM_ID, viewModel.getTeamId().getValue());
                viewModel.getIsTeamClicked().setValue(false);
                navController.navigate(R.id.action_teamsFragment_to_playersFragment, bundle);
            }
        });

        viewModel.getIsErrorShown().observe(this, onError -> {
            if (onError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });
    }
}