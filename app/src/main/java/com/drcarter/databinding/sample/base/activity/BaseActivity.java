package com.drcarter.databinding.sample.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.drcarter.databinding.sample.AppApplication;
import com.drcarter.databinding.sample.internal.di.component.ActivityComponent;
import com.drcarter.databinding.sample.internal.di.component.ApplicationComponent;
import com.drcarter.databinding.sample.internal.di.component.HasComponent;
import com.drcarter.databinding.sample.mvp.presenter.Presenter;
import com.drcarter.databinding.sample.mvp.view.ActivityViewListener;

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {

    protected abstract void onInit();

    protected abstract ActivityComponent getInitializeCompoent();

    protected abstract void onInject(@Nullable ActivityComponent component);

    @Nullable
    protected abstract Presenter getViewListener();

    protected ActivityViewListener viewListener;

    private ActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.component = getInitializeCompoent();
        if (this.component != null) {
            onInject(this.component);
        }

        onInit();

        viewListener = (ActivityViewListener) getViewListener();

        if (viewListener != null) {
            viewListener.onCreate(savedInstanceState);
        }
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AppApplication) getApplication()).getApplicationComponent();
    }

    @Override
    public ActivityComponent getComponent() {
        return this.component;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (viewListener != null) {
            viewListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (viewListener != null) {
            viewListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (viewListener != null) {
            viewListener.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (viewListener != null) {
            viewListener.onDestroy();
        }
    }
}
