package com.example.admin.firstcode.Chapter7;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/21.
 * <p>
 * 这一部分为 书中7.4.2 节内容 实现跨程序数据共享
 * <p>
 * 需要创建另一个工程 把OtherProject.java和chapter7_other_project_activity.xml 代码写在另一个工程里
 * 现在写在这里是为了提交到gitHub上 较容易统一管理
 *
 * 在使用的时候需要先创建数据库  使用SQLiteDatabaseActivity.java 文件 点击   chapter6_sql_lite_activity.xml文件中
 * 的btn_create_sqlite_database  创建数据库 否侧无法添加add data ，会导致newUri为null
 * 即使 uri 和values 都有值
 */

public class OtherProject extends AppCompatActivity {

    // 当newId为某一值时，如为2 ，则在update多少次都只会更新index为2 的数据
    // 根据只在add中改变newId，这部分代码可以达到：更新（替换）最新的一条数据，删除最新的一条数据的效果


    //  只有在运行时先add一次数据 ，后面需要用到newId的update和delete才能有效，否则会为null
    private String newId;

    private static final String TAG = "myprovider";

    public static final String URI = "content://com.example.admin.firstcode.Chapter6.SQLite/book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter7_other_project_activity);

        Button btn_add_data = (Button) findViewById(R.id.btn_add_data);
        Button btn_update_data = (Button) findViewById(R.id.btn_update_data);
        Button btn_delete_data = (Button) findViewById(R.id.btn_delete_data);
        Button btn_query_data = (Button) findViewById(R.id.btn_query_data);

        btn_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 添加数据
                Uri uri = Uri.parse(URI);
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "George Martion");
                values.put("pages", "1040");
                values.put("price", 22.85);
                Uri newUri = getContentResolver().insert(uri, values);
                if (newUri != null) {
                    newId = newUri.getPathSegments().get(1);
                }
            }
        });

        btn_query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询数据
                Uri uri = Uri.parse(URI);
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        String pages = cursor.getString(cursor.getColumnIndex("pages"));
                        float price = cursor.getFloat(cursor.getColumnIndex("price"));

                        Log.d(TAG, "name  " + name);
                        Log.d(TAG, "author  " + author);
                        Log.d(TAG, "pages  " + pages);
                        Log.d(TAG, "price  " + price);
                    }
                    cursor.close();
                }
            }
        });

        btn_update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 更新数据
                Uri uri = Uri.parse(URI + "/" + newId);
                ContentValues values = new ContentValues();
                values.put("name", "A Storm of Sword");
                values.put("pages", "1216");
                values.put("price", 24.05);
                getContentResolver().update(uri, values, null, null);
            }
        });

        btn_delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 删除数据
                Uri uri = Uri.parse(URI + "/" + newId);
                getContentResolver().delete(uri, null, null);
            }
        });


    }
}
