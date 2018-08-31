package com.zqs.butterknifedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zqs.butterknifedemo.adapter.AdapterActivity;
import com.zqs.butterknifedemo.fragment.SecondActivity;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * refer:
    https://www.jianshu.com/p/3678aafdabc7
    https://github.com/JakeWharton/butterknife

 * 绑定Activity
 *
 * 1. 多个事件绑定
 *      @OnClick({ R.id.door1, R.id.door2, R.id.door3 })  用{}中间用逗号隔开 , 快捷键选中多个自动生成
 * 2. @BindView
 * 3. @OnClick
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_tips)
    TextView tvTips;
    @BindView(R.id.tv_second)
    TextView tvSecond;

    @BindColor(R.color.colorAccent)
    int accentColor;
    @BindColor(R.color.colorPrimary)
    int primaryColor;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_tips, R.id.tv_second})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_tips:
                if (count % 2 == 0) tvTips.setTextColor(accentColor);
                else tvTips.setTextColor(primaryColor);
                count++;
                Intent intent2 = new Intent(MainActivity.this, AdapterActivity.class);
                startActivity(intent2);
                break;
            case R.id.tv_second:
                if (count % 2 == 0) tvSecond.setTextColor(accentColor);
                else tvSecond.setTextColor(primaryColor);
                count++;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

}
