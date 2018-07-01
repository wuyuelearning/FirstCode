package com.example.admin.firstcode.Chapter11;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.example.admin.firstcode.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wuyue on 2018/6/13.
 */

public class LBSTestActivity extends AppCompatActivity {
    private TextView textView;
    private LocationClient mLocationClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.chapter11_lbs_test_activity);
        textView = (TextView) findViewById(R.id.tv_my_position);

        List<String> list = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(LBSTestActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            list.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(LBSTestActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            list.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(LBSTestActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            list.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!list.isEmpty()) {
            String[] permissions = list.toArray(new String[list.size()]);
            ActivityCompat.requestPermissions(LBSTestActivity.this, permissions, 1);
        } else {
            requestLocation();
        }
    }


    private void requestLocation() {
        initLoaction();
        mLocationClient.start();
    }


    private void initLoaction() {
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);
//        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    StringBuilder builder = new StringBuilder();
                    builder.append("纬度 ：").append(bdLocation.getLatitude()).append("\n");
                    builder.append("经度 ：").append(bdLocation.getLongitude()).append("\n");
                    builder.append("国家 ：").append(bdLocation.getCountry()).append("\n");
                    builder.append("省 ：").append(bdLocation.getProvince()).append("\n");
                    builder.append("市 ：").append(bdLocation.getCity()).append("\n");
                    builder.append("区 ：").append(bdLocation.getDistrict()).append("\n");
                    builder.append("街道：").append(bdLocation.getStreet()).append("\n");
                    builder.append("定位方式：");
                    if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
                        builder.append("GPS");
                    } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                        builder.append("网络定位");
                    }
                    textView.setText(builder.toString());
                }
            });
        }

    }
}
