package com.drcarter.databinding.sample.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.drcarter.databinding.sample.mvp.presenter.ActivityPresenter;

public class MainActivityPresenterImpl extends ActivityPresenter<MainActivityView> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    public void onPresenterButtonClick(String message) {
        StringBuilder sb = new StringBuilder(message);
        sb.append("\n").append("callback view : ").append("GOGO");

        if(hasView()) {
            getView().onPresenterClickCallback(sb.toString());
        }
    }
}
