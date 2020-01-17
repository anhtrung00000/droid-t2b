package com.sg.t2b.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sg.t2b.R;
import com.sg.t2b.holder.ConsultListViewHolder;

public class ConsultViewAdapter extends RecyclerView.Adapter<ConsultListViewHolder> {
    @NonNull
    @Override
    public ConsultListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_consulting_item_grid, parent, false);
        int height = parent.getMeasuredHeight() / 4;
        view.setMinimumHeight(height);

        ConsultListViewHolder vh = new ConsultListViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultListViewHolder holder, int position) {
        holder.setUpView("");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
