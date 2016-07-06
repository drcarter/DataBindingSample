package com.drcarter.databinding.sample.ui.main;

import android.support.annotation.NonNull;

import com.drcarter.databinding.sample.internal.di.annotation.PerActivity;
import com.drcarter.databinding.sample.internal.di.component.ActivityComponent;
import com.drcarter.databinding.sample.internal.di.component.ApplicationComponent;

import dagger.Component;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                MainActivityModule.class
        }
)
public interface MainActivityComponent extends ActivityComponent {

    void inject(@NonNull MainActivity mainActivity);

    MainActivityPresenterImpl getMainActivityPresenterImpl();
}
