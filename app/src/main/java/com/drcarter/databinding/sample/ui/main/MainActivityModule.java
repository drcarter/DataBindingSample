package com.drcarter.databinding.sample.ui.main;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.drcarter.databinding.sample.internal.di.module.ActivityModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class MainActivityModule extends ActivityModule {

    public MainActivityModule(@NonNull Activity activity) {
        super(activity);
    }

    @Provides
    public MainActivityPresenterImpl provideMainActivityPresenterImpl() {
        return new MainActivityPresenterImpl();
    }
}
