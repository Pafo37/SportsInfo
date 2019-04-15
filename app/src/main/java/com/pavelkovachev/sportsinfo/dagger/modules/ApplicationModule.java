package com.pavelkovachev.sportsinfo.dagger.modules;


import android.app.Application;

import com.pavelkovachev.sportsinfo.AppExecutor;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    AppExecutor provideAppExecutor() {
        return new AppExecutor(Executors.newSingleThreadExecutor());
    }
}