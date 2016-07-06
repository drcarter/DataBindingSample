package com.drcarter.databinding.sample;

import com.drcarter.databinding.sample.internal.di.component.ApplicationComponent;
import com.drcarter.databinding.sample.internal.di.component.DaggerApplicationComponent;
import com.drcarter.databinding.sample.internal.di.module.ApplicationModule;

public class AppApplication extends android.app.Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initApplicationComponent();
    }

    private void initApplicationComponent() {

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
