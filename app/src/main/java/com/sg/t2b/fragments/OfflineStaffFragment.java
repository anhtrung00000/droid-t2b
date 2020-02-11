package com.sg.t2b.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sg.t2b.Navigator;
import com.sg.t2b.R;
import com.sg.t2b.adapter.ConsultViewAdapter;
import com.sg.t2b.adapter.OfflineStaffAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OfflineStaffFragment extends Fragment {
    @BindView(R.id.rv_offline_staff)
    RecyclerView rvOfflineStaff;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offline_staff, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getActivity().getWindow();
            w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        toolbar.setTitle("");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvOfflineStaff.setLayoutManager(layoutManager);
        OfflineStaffAdapter offlineStaffAdapter = new OfflineStaffAdapter();
        rvOfflineStaff.setAdapter(offlineStaffAdapter);
    }

    public interface DemoAction {
        void openCall();
    }
}
