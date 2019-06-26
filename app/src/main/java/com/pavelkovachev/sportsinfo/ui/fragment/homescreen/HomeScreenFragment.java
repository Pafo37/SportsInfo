package com.pavelkovachev.sportsinfo.ui.fragment.homescreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pavelkovachev.sportsinfo.Constants;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        viewModel.getSports();
        viewModel.getIsErrorShown().observe(this, isError -> {
            if (isError) {
                showErrorDialog(getString(R.string.error_message_title),
                        getString(R.string.error_message_description));
                viewModel.getIsErrorShown().setValue(false);
            }
        });

        viewModel.getIsSportClicked().observe(this, isClicked -> {
            if (isClicked) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BUNDLE_SPORT_NAME, viewModel.getSportName().getValue());
                viewModel.getIsSportClicked().setValue(false);
                navController.navigate(R.id.action_homescreen_fragment_to_leaguesFragment, bundle);
            }
        });
    }
}