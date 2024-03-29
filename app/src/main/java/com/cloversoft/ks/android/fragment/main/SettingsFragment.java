package com.cloversoft.ks.android.fragment.main;

import android.util.Log;
import android.widget.TextView;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;



public class SettingsFragment extends BaseFragment {
    public static final String TAG = SettingsFragment.class.getName().toString();

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @BindView(R.id.logoutBTN)                   TextView logoutBTN;

    private MainActivity mainActivity;


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_settings;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setTitle("Settings");
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

    @OnClick(R.id.logoutBTN)
    void logoutBTNClicked(){
        mainActivity.startLandingActivity("");
    }

}
