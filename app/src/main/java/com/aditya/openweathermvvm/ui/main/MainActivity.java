package com.aditya.openweathermvvm.ui.main;

import android.os.Bundle;

import com.aditya.openweathermvvm.R;
import com.aditya.openweathermvvm.base.BaseActivity;
import com.aditya.openweathermvvm.ui.list.ListFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new ListFragment()).commit();
    }
}
