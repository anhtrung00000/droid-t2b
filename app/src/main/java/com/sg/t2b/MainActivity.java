package com.sg.t2b;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.sg.t2b.fragments.LoginFragment;
import com.sg.t2b.ui.login.LoginViewModel;
import com.sg.t2b.ui.login.LoginViewModelFactory;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public FrameLayout getMainLayout() {
        return findViewById(R.id.mainLayout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set up view
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //set up navigator
        Navigator.Instance().setMainActivity(this);
        Navigator.Instance().setupRoot(new LoginFragment());
//        //transparent status bar
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow();
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }
        setupStatusBar();
        //hide toolbar
//        getSupportActionBar().hide();
    }
    public void setupStatusBar() {
        //transparent status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}
