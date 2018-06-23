package com.example.admin.firstcode.Chapter13;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/6/23.
 * 序列化 发送
 *
 * Lambda 表达式
 */

public class Chapter13Activity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter13_lambda_activity);
        initView();
//        serialization();
        lambda();

    }


    /**     序列化    */
    private void serialization (){
        // Serializable 序列化
        Person person = new Person();
        person.setAge(12);
        person.setName("Tom");
        Intent intent =new Intent(this,SecondActivity.class);
        intent.putExtra("person_data",person);
        startActivity(intent);

        // Parcelable 序列化
        Person2 person2 =new Person2();
        person2.setName("jack");
        person2.setAddress("a");
        person2.setAge(12);
        Intent intent1 =new Intent(this,SecondActivity.class);
        intent1.getParcelableExtra("person2_data");
        startActivity(intent1);
    }


    /**   Lambda 表达式*/

    private void lambda(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(()->{

        }).start();

        Runnable runnable =new Runnable() {
            @Override
            public void run() {

            }
        };

        Runnable runnable1=()->{

        };

        LambdaListener lambdaListener=(String a,int b) ->{
            String result = a+b;
            return result;
        };

        lambdaTest((a,b)->{
            String result = a+b;
            return result;
        });
    }

    private void lambdaTest(LambdaListener lambdaListener){
        String a="hello";
        int b =10;
        String result = lambdaListener.doSomething(a,b);
        Log.d("TAG",result);

    }

    private void initView(){

        Button btn_normal = (Button)findViewById(R.id.btn_normal);
        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Chapter13Activity.this,"normal",Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_lambda=(Button)findViewById(R.id.btn_lambda);
        btn_lambda.setOnClickListener((v)->{
            Toast.makeText(Chapter13Activity.this,"lambda",Toast.LENGTH_SHORT).show();

        });
    }
}
