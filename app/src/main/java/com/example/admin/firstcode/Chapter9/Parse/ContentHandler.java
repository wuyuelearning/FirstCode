package com.example.admin.firstcode.Chapter9.Parse;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by wuyue on 2018/5/30.
 *
 * 《第一行代码》 第二版 9.3.2 节
 * SAX 解析方法
 */

public class ContentHandler extends DefaultHandler{

    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;

    @Override
    public void startDocument() throws SAXException {
        id =new StringBuilder();
        name =new StringBuilder();
        version =new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 记录当前节点
        nodeName =localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 根据当前的节点名判断将内容添加到哪一个StringBuider
        if("id".equals(nodeName)){
            id.append(ch,start,length);
        } else  if("name".equals(nodeName)){
            name.append(ch,start,length);
        } else if("version".equals(nodeName)){
            version.append(ch,start,length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("app".equals(localName)) {
            Log.d("tag_xml", "id is " + id.toString().trim());
            Log.d("tag_xml", "name is " + name.toString().trim());
            Log.d("tag_xml", "version is " + version.toString().trim());
            //  将StringBuilder 清空
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
