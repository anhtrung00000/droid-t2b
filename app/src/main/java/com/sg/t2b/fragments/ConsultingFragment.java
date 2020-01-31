package com.sg.t2b.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

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
    @BindView(R.id.ln_transparent)
    LinearLayout lnTransparent;
    @BindView(R.id.ln_subMain)
    LinearLayout lnSubMain;
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
        lnTransparent.setVisibility(View.GONE);
        lnSubMain.setVisibility(View.GONE);
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

//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getActivity().getWindow();
//            if (hidden) {
//                w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            }
//            else {
//                w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            }
//        }
//    }
    @OnClick(R.id.btn_back)
    public void onBack() {
        Navigator.Instance().popBack();
    }
    @OnClick(R.id.btn_add)
    public void onAdd() {
        lnTransparent.setVisibility(View.VISIBLE);
        lnSubMain.setVisibility(View.VISIBLE);
//        lnSubMain.animate()
//                .translationY(0)
//                .setDuration(500);
    }
    @OnClick(R.id.ln_subMain)
    public void onDissmissPopup() {
//        lnSubMain.animate()
//                .translationY(lnSubMain.getHeight())
//                .setDuration(500)
//                .setListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        lnTransparent.setVisibility(View.GONE);
//                        lnSubMain.setVisibility(View.GONE);
//                    }
//                });
        lnTransparent.setVisibility(View.GONE);
        lnSubMain.setVisibility(View.GONE);
    }
    @OnClick(R.id.btn_personal)
    public void onPersonal() {
        Navigator.Instance().pushFragment(NewConsultingFragment.Instance(true));
        lnTransparent.setVisibility(View.GONE);
        lnSubMain.setVisibility(View.GONE);
    }
    @OnClick(R.id.btn_bussiness)
    public void onBuzz() {
        Navigator.Instance().pushFragment(NewConsultingFragment.Instance(false));
        lnTransparent.setVisibility(View.GONE);
        lnSubMain.setVisibility(View.GONE);
    }
}
