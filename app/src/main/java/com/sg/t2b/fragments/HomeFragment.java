package com.sg.t2b.fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sg.t2b.Navigator;
import com.sg.t2b.R;
import com.sg.t2b.adapter.SliderAdapterExample;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {
    @BindView(R.id.ll_consulting)
    LinearLayout llConsulting;
    @BindView(R.id.iv_consulting)
    ImageView ivConsulting;
    @BindView(R.id.imageSlider)
    SliderView sliderView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_kh, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sliderView.setSliderAdapter(new SliderAdapterExample(this.getContext()));
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(1); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        //set up llConsulting
        ivConsulting.setClickable(true);
        ivConsulting.setEnabled(true);
        ivConsulting.setOnClickListener(v -> {
            Navigator.Instance().pushFragment(ConsultingFragment.Instant());
        });
    }
    @OnClick(R.id.ln_offline_staff)
    public void gotoOfflineList() {
        Navigator.Instance().pushFragment(new OfflineStaffFragment());
    }
    @OnClick(R.id.ib_notification)
    public void gotoNotifications() {
        Navigator.Instance().pushFragment(new NotificationFragment());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getActivity().getWindow();
//            Fragment fragment = Navigator.Instance().getCurrentFragment();
//            if (fragment instanceof HomeFragment) {
//                String v = "";
//            }
//            if (!hidden) {//dang hien thi
//                w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            }
//        }
    }
}
