package com.example.admin.firstcode.Chapter12;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.firstcode.R;

import java.util.List;

/**
 * Created by wuyue on 2018/6/19.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<FruitBean> list;
    private Context context;

    public FruitAdapter(List<FruitBean> list) {
        this.list = list;
    }

    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }

        final View view = LayoutInflater.from(context).inflate(R.layout.chapter12_fruit_item, parent, false);


        final ViewHolder viewHolder =new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                FruitBean fruitBean =list.get(position);
                Intent intent =new Intent(context,FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME,fruitBean.getName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruitBean.getImageId());
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
        FruitBean fruitBean = list.get(position);
        holder.textView.setText(fruitBean.getName());
        Glide.with(context).load(fruitBean.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = (ImageView) itemView.findViewById(R.id.iv_fruit_img);
            textView = (TextView) itemView.findViewById(R.id.tv_fruit);

        }
    }
}
