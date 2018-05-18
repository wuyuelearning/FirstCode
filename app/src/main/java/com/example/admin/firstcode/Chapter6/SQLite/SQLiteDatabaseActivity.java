package com.example.admin.firstcode.Chapter6.SQLite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/17.
 * 创建SQLLite数据库
 */

public class SQLiteDatabaseActivity extends AppCompatActivity {

    private MyDatabaseHelper myDatabaseHelper ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter6_sql_lite_activity);

        myDatabaseHelper =new MyDatabaseHelper(this,"BookStore.db",null,2);

        //  创建数据库
        Button btn_create_sqlite_database = (Button)findViewById(R.id.btn_create_sqlite_database);
        btn_create_sqlite_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.getWritableDatabase();
            }
        });


        //  添加数据
        Button btn_add_data = (Button)findViewById(R.id.btn_add_data);
        btn_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db =myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues =new ContentValues();
                // 第一组数据
                contentValues.put("name","The Da Vinci Code");
                contentValues.put("author","Dan Brown");
                contentValues.put("page",454);
                contentValues.put("price",16.96);
                db.insert("Book",null,contentValues);
                contentValues.clear();
                // 第二组数据
                contentValues.put("name","The Lost Symbol");
                contentValues.put("author","Dan Brown");
                contentValues.put("page",510);
                contentValues.put("price",19.95);
                db.insert("Book",null,contentValues);
            }
        });


    }
}
