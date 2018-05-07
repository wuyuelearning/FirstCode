package com.example.admin.firstcode.Chapter3.ListView;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.firstcode.Chapter3.FruitBean;
import com.example.admin.firstcode.R;

import java.util.List;

/**
 * Created by wuyue on 2018/5/7.
 * 添加ViewHolder缓存
 */

public class FruitViewHolderAdapter extends ArrayAdapter<FruitBean> {
    private int resourceId;

    public FruitViewHolderAdapter(@NonNull Context context, @LayoutRes int textViewResourceId, List<FruitBean> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FruitBean fruitBean = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder =new ViewHolder();
            viewHolder.fruitImage =view.findViewById(R.id.iv_fruit_image); //  缓存
            viewHolder.fruitName =view.findViewById(R.id.tv_fruit_name);
            view.setTag(viewHolder);
        } else {
            view =convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruitBean.getImageId());
        viewHolder.fruitName.setText(fruitBean.getName());
        return view ;
    }

    // 内容主要由Item中控件决定
    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
