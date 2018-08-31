package com.zqs.butterknifedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zqs.butterknifedemo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 绑定Adapter
 *   1. ButterKnife.bind(this, view);  //在构造函数中, 进行对ViewHolder绑定View;
 */
public class MyAdapter extends BaseAdapter {
    List<String> source;
    Context context;
    LayoutInflater inflater;

    public MyAdapter(Context context, List<String> source) {
        this.context = context;
        this.source = source;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return source == null ? 0: source.size();
    }

    @Override
    public Object getItem(int position) {
        return source.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.adapter_item, parent,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
            holder.tvItemName.setText(source.get(position));
        }

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tv_item_name)
        TextView tvItemName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
