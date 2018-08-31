package com.zqs.butterknifedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.zqs.butterknifedemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zqs on 2018/8/31.
 */
public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.frame_container)
    FrameLayout frameContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, MyFragment.create()).commit();
    }
}
