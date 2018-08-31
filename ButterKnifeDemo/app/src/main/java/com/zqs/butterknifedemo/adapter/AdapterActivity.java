package com.zqs.butterknifedemo.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.zqs.butterknifedemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zqs on 2018/8/31.
 */
public class AdapterActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;

    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adpter);
        ButterKnife.bind(this);

        //要显示的数据
        String[] strs = {"基神","B神","翔神","曹神","J神"};
        List<String> list = new ArrayList<>(Arrays.asList(strs));
        //创建ArrayAdapter
        adapter = new MyAdapter(this, list);
        listview.setAdapter(adapter);
    }
}
