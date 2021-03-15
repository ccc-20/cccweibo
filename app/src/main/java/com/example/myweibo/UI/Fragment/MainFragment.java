package com.example.myweibo.UI.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myweibo.R;
import com.example.myweibo.base.BaseFragment;

import at.markushi.ui.CircleButton;

public class MainFragment extends BaseFragment {

    private CircleButton mButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview= inflater.inflate(R.layout.fragment_main,container,false);
        initView(rootview);
        return rootview;
    }

    @Override
    protected void initView(View view) {
        mButton=view.findViewById(R.id.add);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SendActivity.class);
                startActivity(intent);
            }
        });
    }
}
