package com.drcarter.databinding.sample.internal.di.module;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.drcarter.databinding.sample.internal.di.annotation.PerActivity;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private WeakReference<Activity> activity;

    public ActivityModule(@NonNull Activity activity) {
        this.activity = new WeakReference<>(activity);
    }

    @PerActivity
    @Provides
    Activity provideActivity() {
        return this.activity.get();
    }
}
