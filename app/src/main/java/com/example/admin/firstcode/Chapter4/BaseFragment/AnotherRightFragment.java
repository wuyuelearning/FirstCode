package com.example.admin.firstcode.Chapter4.BaseFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.firstcode.R;

/**
 * Created by wuyue on 2018/5/10.
 */

public class AnotherRightFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.chapter4_another_right_fragment,container,false);
        doSomething();
        return view;
    }
    private void doSomething() {
        PadActivity2 context =(PadActivity2)getActivity();
        context.dos();

    }
}
