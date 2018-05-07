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
 * 添加ViewHolder
 */

public class FruitBaseAdapter extends ArrayAdapter<FruitBean> {

    private int resourceId;

    public FruitBaseAdapter(@NonNull Context context, @LayoutRes int textViewResourceId, List<FruitBean> objects) {
        super(context, textViewResourceId, objects);
        resourceId= textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FruitBean fruitBean = getItem(position);
        View view  = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView fruitImage = view.findViewById(R.id.iv_fruit_image);
        TextView fruitName = view.findViewById(R.id.tv_fruit_name);
        fruitImage.setImageResource(fruitBean.getImageId());
        fruitName.setText(fruitBean.getName());
        return view;
    }
}
