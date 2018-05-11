package com.example.admin.firstcode.Chapter4.NewsFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/11.
 */

public class NewsContentFragment extends Fragment{
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view  =inflater.inflate(R.layout.chapter4_news_content_fragment_double,container,false);
        return view;
    }

    public void refresh(String newsTitle ,String newsContent){
        View visibilityLayout = view.findViewById(R.id.ll_news_visibility);
        visibilityLayout.setVisibility(View.VISIBLE);

        TextView title = view.findViewById(R.id.tv_news_title);
        TextView content = view.findViewById(R.id.tv_news_content);

        title.setText(newsTitle);
        content.setText(newsContent);
    }
}
