package com.example.admin.firstcode.Chapter9.Parse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;

import com.example.admin.firstcode.R;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wuyue on 2018/5/30.
 */

public class ParseXMLActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isPull = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter9_parse_xml_activity);

        Button btn_parse_xml_pull = (Button) findViewById(R.id.btn_parse_xml_pull);
        btn_parse_xml_pull.setOnClickListener(this);
        Button btn_parse_xml_sax = (Button) findViewById(R.id.btn_parse_xml_sax);
        btn_parse_xml_sax.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_parse_xml_pull:
                isPull = true;
                break;
            case R.id.btn_parse_xml_sax:
                isPull = false;
                break;
            default:
                break;
        }
        sendRequestWithOkHttp();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();

                    if (isPull) {
                        Request request = new Request.Builder()
                                .url("http://127.0.0.1/get_data_pull.xml")
                                .build();
                        Response response = client.newCall(request).execute();
                        String responseData = response.body().string();
                        parseXMLWithPull(responseData);
                    } else {
                        Request request = new Request.Builder()
                                .url("http://127.0.0.1/get_data_sax.xml")
                                .build();
                        Response response = client.newCall(request).execute();
                        String responseData = response.body().string();
                        parseXMLWithSAX(responseData);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));

            int eventType = xmlPullParser.getEventType();

            String id = "";
            String name = "";
            String version = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();

                switch (eventType) {
                    // 开始某一解析节点
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                    }
                    break;
                    //  完成某一节点解析
                    case XmlPullParser.END_TAG: {
                        if ("app".equals(nodeName)) {
                            Log.d("tag_xml", "id is " + id);
                            Log.d("tag_xml", "name is " + name);
                            Log.d("tag_xml", "version is " + version);
                        }
                    }
                    break;

                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            // 将ContentHandler 的实例设置到XMLReader中
            reader.setContentHandler(handler);
            // 开始解析
            reader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
