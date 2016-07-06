package com.drcarter.databinding.sample.internal.di.component;

import com.drcarter.databinding.sample.internal.di.annotation.PerActivity;
import com.drcarter.databinding.sample.internal.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(
        modules = ActivityModule.class
)
public interface ActivityComponent {
}
