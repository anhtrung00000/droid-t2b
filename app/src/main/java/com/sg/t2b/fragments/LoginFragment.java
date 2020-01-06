package com.sg.t2b.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sg.t2b.Navigator;
import com.sg.t2b.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return  view;
    }
    @OnClick(R.id.btn_login)
    public void login()
    {
        Navigator.Instance().pushFragment(new SignUpFragment());
    }
}
