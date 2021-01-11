package com.cloversoft.ks.android.fragment.main;

import android.util.Log;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class HomeFragment extends BaseFragment {
    public static final String TAG = HomeFragment.class.getName().toString();

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    private MainActivity mainActivity;

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_default;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setSelectedItem("home");
        mainActivity.setTitle("Home");
        mainActivity.homeActive();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onResponse(Auth.LoginResponse loginResponse){
        Log.e("Message", loginResponse.getData(BaseTransformer.class).msg);
    }
}
