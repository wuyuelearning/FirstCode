package com.example.admin.firstcode.Chapter3.Chat;

/**
 * Created by wuyue on 2018/5/8.
 */

public class MsgBean {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;

    public MsgBean (String content ,int type){
        this.content =content;
        this.type =type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
