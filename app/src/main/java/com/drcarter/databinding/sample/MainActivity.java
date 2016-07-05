package com.drcarter.databinding.sample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.drcarter.databinding.sample.databinding.ActivityMainBinding;
import com.drcarter.databinding.sample.handler.MainEventHandler;

public class MainActivity extends AppCompatActivity implements MainEventHandler {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setHandler(this);
        activityMainBinding.textTitle.setText("start!!!");
    }

    @Override
    public void onChangeTitleClick(View view) {
        if (view.getId() == R.id.buttonChangeTitle) {
            Toast.makeText(this, "onChangeTitleClick : " + view.getId(), Toast.LENGTH_SHORT).show();
        }

        activityMainBinding.textTitle.setText("Title Change complete!!");
    }
}
