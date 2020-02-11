package com.sg.t2b.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sg.t2b.Navigator;
import com.sg.t2b.R;
import com.sg.t2b.fragments.CallingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OfflineStaffViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.cv_submit)
    CardView cvSubmit;
    public OfflineStaffViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void setUpView(String url) {
    }
    @OnClick(R.id.cv_submit)
    public void gotoCalling() {
        Navigator.Instance().pushFragment(new CallingFragment());
    }
}
