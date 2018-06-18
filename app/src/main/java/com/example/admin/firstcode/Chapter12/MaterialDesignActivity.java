package com.example.admin.firstcode.Chapter12;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/
 * ToolBar
 * 菜单滑动 ：DrawerLayouyt  NavigationView
 * 悬浮按钮和可交互提示 FloatingActionButton
 */

public class MaterialDesignActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter12_toolbar_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_toolBar);
        setSupportActionBar(toolbar);

        setmDrawerLayout();

        setmNavigationView();

        setmFloatingActionButton();
    }


    /*** ToolBar   begin***/
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
    /*** ToolBar   end***/


    /*** DrawerLayouyt   begin***/
    private void setmDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.chapter3_unselected);
        }
    }
    /*** DrawerLayouyt   end***/


    /*** NavigationView   begin***/
    private void setmNavigationView() {
        mNavigationView = (NavigationView) findViewById(R.id.nv_nav_view);
        mNavigationView.setCheckedItem(R.id.it_call);  //  默认选中的项
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();  //在此处处理点击事件
                return false;
            }
        });
    }
    /*** NavigationView   end***/


    /*****FloatingActionButton begin**/
    private void setmFloatingActionButton() {
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab_button);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialDesignActivity.this, "You clicked FloatingActionButton", Toast.LENGTH_SHORT).show();
                //  将v改为mDrawerLayout 则CoordinatorLayout 不会将snackbar 弹起
                Snackbar.make(v, "Data delete", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MaterialDesignActivity.this, "Data restored", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }

    /*****FloatingActionButton end**/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.it_backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it_delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it_setting:
                Toast.makeText(this, "You clicked Setting", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }


}
