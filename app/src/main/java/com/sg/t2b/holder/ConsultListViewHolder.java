package com.sg.t2b.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sg.t2b.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConsultListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_consult)
    ImageView iv_consult;
    public ConsultListViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void setUpView(String url) {
//        Glide.with(this.itemView)
//                .
    }
}
