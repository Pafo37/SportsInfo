package com.pavelkovachev.sportsinfo.ui.fragment.leagues;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentLeaguesBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

public class LeaguesFragment extends BaseFragment<LeaguesViewModel, FragmentLeaguesBinding> {

    private String sportName;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_leagues;
    }

    @Override
    protected Class<LeaguesViewModel> getViewModel() {
        return LeaguesViewModel.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sportName = getArguments().getString(Constants.BUNDLE_SPORT_NAME);

        viewModel.getLeagues(sportName);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(sportName);
        NavController navController = Navigation.findNavController(view);
        viewModel.getIsErrorShown().observe(this, isError -> {
            if (isError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });
        viewModel.getIsLeagueClicked().observe(this, isClicked -> {
            if (isClicked) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BUNDLE_LEAGUE_NAME, viewModel.getLeagueName().getValue());
                viewModel.getIsLeagueClicked().setValue(false);
                navController.navigate(R.id.action_leaguesFragment_to_teamsFragment, bundle);
            }
        });

        viewModel.getIsSeeMoreClicked().observe(this, isClicked -> {
            if (isClicked) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BUNDLE_LEAGUE_ID, viewModel.getLeagueId().getValue());
                bundle.putString(Constants.BUNDLE_LEAGUE_NAME, viewModel.getLeagueName().getValue());
                viewModel.getIsSeeMoreClicked().setValue(false);
                navController.navigate(R.id.action_leaguesFragment_to_leagueDetailsFragment, bundle);
            }
        });
    }
}