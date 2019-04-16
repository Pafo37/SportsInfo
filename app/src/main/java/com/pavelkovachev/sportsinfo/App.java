package com.pavelkovachev.sportsinfo;

import com.pavelkovachev.sportsinfo.dagger.component.DaggerAppComponent;
import com.pavelkovachev.sportsinfo.dagger.modules.ApplicationModule;
import com.pavelkovachev.sportsinfo.dagger.modules.RoomModule;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder()
                .roomModule(new RoomModule(this))
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}