package com.example.myweibo.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myweibo.R;

public class BaseFragment extends Fragment {

    private FrameLayout mFrameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=loadView(inflater,container);
        mFrameLayout=view.findViewById(R.id.base_container);
        initView(view);
        initListener();
        return view;
    }

    protected void initListener() {
    }

    protected View loadView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_fragment,container,false);
    }

    protected void initView(View view) {

    }
}
