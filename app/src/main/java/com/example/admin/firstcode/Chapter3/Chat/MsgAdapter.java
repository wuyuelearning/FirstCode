package com.example.admin.firstcode.Chapter3.Chat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.firstcode.R;

import java.util.List;

/**
 * Created by wuyue on 2018/5/8.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<MsgBean> msgBeanList;

    public MsgAdapter(List<MsgBean> msgBeanList) {
        this.msgBeanList = msgBeanList;
    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter3_chat_msg_item,parent,false);
        ViewHolder viewHolder =new  ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        MsgBean msgBean =msgBeanList.get(position);
            if(msgBean.getType() == MsgBean.TYPE_RECEIVED){
                holder.leftLinearLayout.setVisibility(View.VISIBLE);
                holder.rightLinearLayout.setVisibility(View.GONE);
                holder.leftMsg.setText(msgBean.getContent());
            } else if(msgBean.getType() == MsgBean.TYPE_SENT){
                holder.leftLinearLayout.setVisibility(View.GONE);
                holder.rightLinearLayout.setVisibility(View.VISIBLE);
                holder.rightMsg.setText(msgBean.getContent());
            }
    }

    @Override
    public int getItemCount() {
        return msgBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLinearLayout;
        LinearLayout rightLinearLayout;
        TextView leftMsg;
        TextView rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLinearLayout = itemView.findViewById(R.id.ll_msg_left);
            rightLinearLayout = itemView.findViewById(R.id.ll_msg_right);
            leftMsg = itemView.findViewById(R.id.tv_msg_left);
            rightMsg = itemView.findViewById(R.id.tv_msg_right);
        }
    }
}
