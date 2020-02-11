package com.sg.t2b.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sg.t2b.R;
import com.sg.t2b.holder.OfflineStaffViewHolder;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_notification_item, parent, false);
        NotificationViewHolder vh = new NotificationViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
