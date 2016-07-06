package com.drcarter.databinding.sample.internal.di.component;

import com.drcarter.databinding.sample.internal.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
        }
)
public interface ApplicationComponent {
}
