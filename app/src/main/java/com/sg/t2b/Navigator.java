package com.sg.t2b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Navigator {
    private static Navigator _instance;
    private static MainActivity _mainActivity;

    private FragmentManager fragmentManager;
    private int enter_animation = 0;
    private int exit_animation = 0;

    public FragmentManager getFragmentManager()
    {
        if (fragmentManager == null)
        {
            fragmentManager = _mainActivity.getSupportFragmentManager();
        }
        return fragmentManager;
    }

    public void setMainActivity(MainActivity mainActivity) {
        _mainActivity = mainActivity;
    }

    public static MainActivity get_mainActivity() {
        return _mainActivity;
    }

    public static Navigator Instance()
    {
        if (_instance == null)
        {
            _instance = new Navigator(_mainActivity);
        }
        return _instance;
    }

    public Navigator(MainActivity activity)
    {
        _mainActivity = activity;
    }

    public void setupRoot(Fragment fragment) {
        navigateBetweenFragmentsIsRoot(fragment);
    }


    public void pushFragment(Fragment fragment) {
//        this.enter_animation = R.animator.enter_from_right;
//        this.exit_animation = R.animator.exit_to_left;
        navigateBetweenFragmentsNoneRoot(fragment);
    }

    public void popBack()
    {
        this.getFragmentManager().popBackStack();
    }

    //present a fragment upon the old fragment
    public void presentModal(Fragment fragment) {
//        this.enter_animation = R.animator.slide_up;
//        this.exit_animation = R.animator.keeping_old_fragment;

        this.navigateBetweenFragmentsNoneRoot(fragment);
    }

    private void navigateBetweenFragments(Fragment fragment, boolean isRoot) {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.setCustomAnimations(this.enter_animation, this.exit_animation, 0,0);
        if (fragment.isAdded())
        {
            ft.show(fragment);
        }else
        {
            ft.add(_mainActivity.getMainLayout().getId(), fragment);
            if (!isRoot)
            {
                ft.addToBackStack(fragment.getTag());
            }
        }
        for (Fragment frag:_mainActivity.getSupportFragmentManager().getFragments()) {
            if (frag != fragment)
            {
                ft.hide(frag);
            }
        }
        ft.commit();
    }

    private void navigateBetweenFragmentsNoneRoot(Fragment fragment) {
        navigateBetweenFragments(fragment, false);
    }

    private void navigateBetweenFragmentsIsRoot(Fragment fragment) {
        navigateBetweenFragments(fragment, true);
    }
}
