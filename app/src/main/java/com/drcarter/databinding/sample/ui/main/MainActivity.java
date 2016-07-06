package com.drcarter.databinding.sample.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.drcarter.databinding.sample.R;
import com.drcarter.databinding.sample.base.activity.BaseActivity;
import com.drcarter.databinding.sample.databinding.ActivityMainBinding;
import com.drcarter.databinding.sample.handler.MainEventHandler;
import com.drcarter.databinding.sample.internal.di.component.ActivityComponent;
import com.drcarter.databinding.sample.mvp.presenter.Presenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityView, MainEventHandler {

    ActivityMainBinding activityMainBinding;

    @Inject
    MainActivityPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setHandler(this);
        activityMainBinding.textTitle.setText("start!!!");
    }

    @Override
    protected void onInit() {
        presenter.bindView(this);
    }

    @Override
    protected ActivityComponent getInitializeCompoent() {
        return DaggerMainActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build();
    }

    @Override
    protected void onInject(@Nullable ActivityComponent component) {
        if (component != null) {
            ((MainActivityComponent) component).inject(this);
        }
    }

    @Nullable
    @Override
    protected Presenter getViewListener() {
        return presenter;
    }

    @Override
    public void onChangeTitleClick(View view) {
        if (view.getId() == R.id.buttonChangeTitle) {
            Toast.makeText(this, "onChangeTitleClick : " + view.getId(), Toast.LENGTH_SHORT).show();
        }

        activityMainBinding.textTitle.setText("Title Change complete!!");
    }

    @Override
    public void onMVPPresenterUse(View view) {
        presenter.onPresenterButtonClick("presenter click");
    }

    @Override
    public void onPresenterClickCallback(String message) {
        activityMainBinding.textTitle.setText(message);
    }
}
