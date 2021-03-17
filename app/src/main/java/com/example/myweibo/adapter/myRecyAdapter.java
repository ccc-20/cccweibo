package com.example.myweibo.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myRecyAdapter extends RecyclerView.Adapter<myRecyAdapter.hodler> {

    private ArrayList<String> list=new ArrayList();

    @NonNull
    @Override
    public hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull hodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class hodler extends RecyclerView.ViewHolder {
        public hodler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
