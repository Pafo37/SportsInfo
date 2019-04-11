package com.pavelkovachev.sportsinfo.ui.activity.main;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.ActivityMainBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.leagues.LeaguesViewModel;


import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    LeaguesViewModel leaguesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        setSupportActionBar(activityMainBinding.toolbar);
      /*  leaguesViewModel = ViewModelProviders.of(this).get(LeaguesViewModel.class);
        leaguesViewModel.getAllLeagues();*/
    }
}