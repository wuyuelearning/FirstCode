package com.example.admin.firstcode.Chapter3.Chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.firstcode.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wuyue on 2018/5/8.
 */

public class ChatActivity extends AppCompatActivity {
    private List<MsgBean> msgBeanList = new ArrayList<>();

    private EditText et_edit_msg;
    private Button btn_send_msg;
    RecyclerView recyclerView;
    MsgAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_chat_activity);
        initMsg();
        initView();
    }

    private void initView() {
        et_edit_msg = (EditText) findViewById(R.id.et_edit_msg);
        btn_send_msg = (Button) findViewById(R.id.btn_send_msg);

        recyclerView = (RecyclerView) findViewById(R.id.rv_chat_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MsgAdapter(msgBeanList);
        recyclerView.setAdapter(adapter);

        btn_send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputMsg = et_edit_msg.getText().toString();
                if (!"".equals(inputMsg)) {
                    MsgBean msgBean = new MsgBean(inputMsg, MsgBean.TYPE_SENT);
                    Random random = new Random();
                    int ran = random.nextInt(2);
                    if (ran == 0) {
                        msgBean = new MsgBean(inputMsg, MsgBean.TYPE_RECEIVED);
                    }
                    msgBeanList.add(msgBean);
                    adapter.notifyItemInserted(msgBeanList.size() - 1);
                    recyclerView.scrollToPosition(msgBeanList.size() - 1);
                    et_edit_msg.setText("");
                }
            }
        });
    }

    private void initMsg() {
        MsgBean m1 = new MsgBean("111", MsgBean.TYPE_RECEIVED);
        msgBeanList.add(m1);
        MsgBean m2 = new MsgBean("222", MsgBean.TYPE_SENT);
        msgBeanList.add(m2);
        MsgBean m3 = new MsgBean("333", MsgBean.TYPE_RECEIVED);
        msgBeanList.add(m3);
    }
}
