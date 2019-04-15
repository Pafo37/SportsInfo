package com.pavelkovachev.sportsinfo.ui.activity.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.ActivityMainBinding;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        setSupportActionBar(activityMainBinding.toolbar);
    }
}