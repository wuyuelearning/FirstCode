package com.example.admin.firstcode.Chapter4.NewsFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.firstcode.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wuyue on 2018/5/11.
 */

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chapter4_news_title_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_news_title);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        NewsAdapter adapter = new NewsAdapter(getNews());
        recyclerView.setAdapter(adapter);


        return view;
    }

    private List<NewsBean> getNews() {
        List<NewsBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsBean newsBean = new NewsBean();
            newsBean.setTitle("title :" + i);
            newsBean.setContect(getRandomContent("content  "+i+"  "));
            list.add(newsBean);
        }
        return list;
    }

    private String getRandomContent(String s) {
        Random random = new Random();
        int l = random.nextInt(20) + 1;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < l; i++) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.fl_news_content) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }


    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private List<NewsBean> newsBeanList;

        public NewsAdapter(List<NewsBean> newsBeanList) {
            this.newsBeanList = newsBeanList;
        }

        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter4_news_title_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsBean newsBean = newsBeanList.get(holder.getAdapterPosition());
                    if (isTwoPane) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.fg_news_content);
                        newsContentFragment.refresh(newsBean.getTitle(), newsBean.getContect());
                    } else {
                        NewsContentActivity.actionStart(getActivity(), newsBean.getTitle(), newsBean.getContect());
                    }
                }
            });


            return holder;
        }

        @Override
        public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {

            NewsBean newsBean = newsBeanList.get(position);
            holder.title.setText(newsBean.getTitle());
        }

        @Override
        public int getItemCount() {
            return newsBeanList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView title;

            public ViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.tv_news_title_item);
            }
        }
    }


}
