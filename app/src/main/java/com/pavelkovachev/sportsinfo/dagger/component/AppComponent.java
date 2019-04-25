package com.pavelkovachev.sportsinfo.dagger.component;


import com.pavelkovachev.sportsinfo.App;
import com.pavelkovachev.sportsinfo.dagger.modules.ApplicationModule;
import com.pavelkovachev.sportsinfo.dagger.modules.RoomModule;
import com.pavelkovachev.sportsinfo.dagger.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ViewModelModule.class,
        AndroidInjectionModule.class,
        RoomModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Override
    void inject(DaggerApplication instance);

    void inject(App app);
}