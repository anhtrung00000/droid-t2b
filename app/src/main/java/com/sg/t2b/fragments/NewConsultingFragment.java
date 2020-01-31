package com.sg.t2b.fragments;

import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sg.t2b.Navigator;
import com.sg.t2b.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewConsultingFragment extends Fragment {
    private static NewConsultingFragment _instance;
    private boolean _isPersonal;
    //layout properties
    @BindView(R.id.et_description)
    EditText etDescription;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    public static NewConsultingFragment Instance(boolean isPersonal) {
        if (_instance == null) _instance = new NewConsultingFragment();
        _instance._isPersonal = isPersonal;
        return _instance;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_personal_consulting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //update value base on personal flag
        if (!_isPersonal) {
            toolbarTitle.setText("Tạo đơn tư vấn doanh nghiệp");
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
            // Gets the layout params that will allow you to resize the layout
            ViewGroup.LayoutParams params = etDescription.getLayoutParams();
            // Changes the height and width to the specified *pixels*
            params.height = height;
            etDescription.setLayoutParams(params);
        }
    }
    @OnClick(R.id.btn_back)
    public void onBack() {
        Navigator.Instance().popBack();
    }
}
