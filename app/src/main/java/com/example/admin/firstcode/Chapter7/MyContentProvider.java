package com.example.admin.firstcode.Chapter7;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.net.URI;


/**
 * Created by wuyue on 2018/5/21.
 */

public class MyContentProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;
    public static final int TABLE1_ITEM = 1;
    public static final int TABLE2_DIR = 2;
    public static final int TABLE2_ITEM = 3;

    public static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.admin.firstcode.Chapter7", "table1", TABLE1_DIR);
        uriMatcher.addURI("com.example.admin.firstcode.Chapter7", "table1/#", TABLE1_ITEM);
        uriMatcher.addURI("com.example.admin.firstcode.Chapter7", "table2", TABLE2_DIR);
        uriMatcher.addURI("com.example.admin.firstcode.Chapter7", "table2/#", TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                // 查询table1表中的所有数据
                break;
            case TABLE1_ITEM:
                // 查询table1表中的单条数据
                break;
            case TABLE2_DIR:
                // 查询table2表中的所有数据
                break;
            case TABLE2_ITEM:
                // 查询table2表中的单条数据
                break;
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.admin.firstcode.Chapter7.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.admin.firstcode.Chapter7.table1";

            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.admin.firstcode.Chapter7.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.admin.firstcode.Chapter7.table2";
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
