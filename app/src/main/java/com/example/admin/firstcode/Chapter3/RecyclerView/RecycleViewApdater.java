package com.example.admin.firstcode.Chapter3.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.firstcode.Chapter3.FruitBean;
import com.example.admin.firstcode.R;

import java.util.List;

/**
 * Created by wuyue on 2018/5/7.
 */

public class RecycleViewApdater extends RecyclerView.Adapter<RecycleViewApdater.ViewHolder> {

    private List<FruitBean> fruitBeanList;

    public RecycleViewApdater(List<FruitBean> fruitBeanList) {
        this.fruitBeanList = fruitBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter3_rv_grid_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                FruitBean fruitBean =fruitBeanList.get(position);
                Toast.makeText(v.getContext(),"click view  "+fruitBean.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                FruitBean fruitBean =fruitBeanList.get(position);
                Toast.makeText(v.getContext(),"click image  "+fruitBean.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                FruitBean fruitBean =fruitBeanList.get(position);
                Toast.makeText(v.getContext(),"click text  "+fruitBean.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FruitBean fruitBean = fruitBeanList.get(position);
        holder.fruitImage.setImageResource(fruitBean.getImageId());
        holder.fruitName.setText(fruitBean.getName());
    }

    @Override
    public int getItemCount() {
        return fruitBeanList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView =view;
            fruitImage = view.findViewById(R.id.iv_fruit_image);
            fruitName = view.findViewById(R.id.tv_fruit_name);
        }
    }

}
