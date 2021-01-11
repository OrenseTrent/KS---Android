package com.cloversoft.ks.android.fragment.landing;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.LandingActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;



public class LoginFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = LoginFragment.class.getName().toString();

    private LandingActivity landingActivity;

//    @BindView(R.id.emailET)             EditText emailET;
//    @BindView(R.id.passET)              EditText passET;
//    @BindView(R.id.loginBTN)            TextView loginBTN;
//    @BindView(R.id.signUpBTN)           TextView signUpBTN;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewReady() {
        landingActivity = (LandingActivity) getContext();
//        loginBTN.setOnClickListener(this);
//        signUpBTN.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.loginBTN:
//                landingActivity.startMainActivity("home");
//              break;
//            case R.id.signUpBTN:
//                landingActivity.startRegisterActivity("signup");
//                break;


        }

    }
}
