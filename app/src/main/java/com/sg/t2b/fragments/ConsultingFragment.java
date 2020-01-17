package com.sg.t2b.fragments;

import android.annotation.SuppressLint;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sg.t2b.Navigator;
import com.sg.t2b.R;
import com.sg.t2b.adapter.ConsultViewAdapter;
import com.sg.t2b.adapter.GridSpacingItemDecoration;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConsultingFragment extends Fragment {
    @BindView(R.id.rv_consulting)
    RecyclerView rvConsulting;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.btn_add)
    ImageButton btnAdd;
    private static ConsultingFragment _instant;
    public static ConsultingFragment Instant() {
        if(_instant == null)
            _instant = new ConsultingFragment();
        return _instant;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consulting_list, container, false);
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
//        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int spanCount = 2; // 3 columns
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), spanCount);
        rvConsulting.setLayoutManager(mLayoutManager);
        ConsultViewAdapter consultViewAdapter = new ConsultViewAdapter();
        rvConsulting.setAdapter(consultViewAdapter);
        int spacing = 120; // 50px
        boolean includeEdge = true;
        rvConsulting.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getActivity().getWindow();
            if (hidden) {
                w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }
            else {
                w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }
        }
    }
    @OnClick(R.id.btn_back)
    public void onBack() {
        Navigator.Instance().popBack();
    }
    @OnClick(R.id.btn_add)
    public void onAdd() {
        PowerMenu powerMenu = new PowerMenu.Builder(getContext())
                .setHeaderView(R.layout.layout_consulting_dialog_header) // header used for title
                .setFooterView(R.layout.layout_consulting_dialog_header) // footer used for yes and no buttons
                .addItem(new PowerMenuItem("This is DialogPowerMenu", false)) // this is body
                .setLifecycleOwner(this)
                .setAnimation(MenuAnimation.SHOW_UP_CENTER)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setWidth(800)
                .setSelectedEffect(false)
                .build();
        powerMenu.showAsAnchorCenter(this.getView());

    }
}
