package com.drcarter.databinding.sample.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

public interface ActivityViewListener extends ViewListener {

    void onCreate(@Nullable Bundle savedInstanceState);

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
