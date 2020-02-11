package com.sg.t2b.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sg.t2b.R;
import com.sg.t2b.holder.ConsultListViewHolder;
import com.sg.t2b.holder.OfflineStaffViewHolder;

public class OfflineStaffAdapter extends RecyclerView.Adapter<OfflineStaffViewHolder> {

    @NonNull
    @Override
    public OfflineStaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_offline_staff_item, parent, false);
        OfflineStaffViewHolder vh = new OfflineStaffViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull OfflineStaffViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
