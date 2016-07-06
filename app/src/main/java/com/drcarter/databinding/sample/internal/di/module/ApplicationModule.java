package com.drcarter.databinding.sample.internal.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.drcarter.databinding.sample.AppApplication;
import com.drcarter.databinding.sample.internal.di.annotation.ApplicationContext;
import com.drcarter.databinding.sample.internal.di.annotation.PerApp;

import dagger.Module;
import dagger.Provides;

@PerApp
@Module
public class ApplicationModule {

    private AppApplication appApplication;

    public ApplicationModule(@NonNull AppApplication appApplication) {
        this.appApplication = appApplication;
    }

    @ApplicationContext
    @Provides
    Context provideContext() {
        return this.appApplication.getApplicationContext();
    }
}
