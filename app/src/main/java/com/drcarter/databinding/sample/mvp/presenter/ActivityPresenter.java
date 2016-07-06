package com.drcarter.databinding.sample.mvp.presenter;

import com.drcarter.databinding.sample.mvp.view.ActivityViewListener;
import com.drcarter.databinding.sample.mvp.view.MVPView;

public abstract class ActivityPresenter<V extends MVPView> implements Presenter, ActivityViewListener {

    protected V view;

    public void bindView(V view) {

        if (view == null) {
            throw new NullPointerException("Presenter V must be not null!!");
        }

        if (this.view != view) {
            if (this.view != null) {
                unbindView(this.view);
            }
            this.view = view;
        }
    }

    public void unbindView(V view) {

        if (view == null) {
            throw new NullPointerException("Presenter V must be not null!!");
        }

        if (view == this.view) {
            this.view = null;
        }
    }

    protected boolean hasView() {
        return view != null;
    }

    public V getView() {
        return view;
    }
}
