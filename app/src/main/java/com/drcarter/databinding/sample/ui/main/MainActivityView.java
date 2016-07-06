package com.drcarter.databinding.sample.ui.main;

import com.drcarter.databinding.sample.mvp.view.MVPView;

public interface MainActivityView extends MVPView {
    void onPresenterClickCallback(String message);
}
