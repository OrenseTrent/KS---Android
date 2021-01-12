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

    @BindView(R.id.loginTXT)                    TextView loginTXT;
    @BindView(R.id.registerTXT)                 TextView registerTXT;
    @BindView(R.id.loginUsernameET)             EditText loginUsernameET;
    @BindView(R.id.loginPasswordET)             EditText loginPasswordET;
    @BindView(R.id.loginBTN)                    TextView loginBTN;
    @BindView(R.id.shopBTN)                     TextView shopBTN;
    @BindView(R.id.usernameET)                  EditText usernameET;
    @BindView(R.id.passwordET)                  EditText passwordET;
    @BindView(R.id.confirmpassET)               EditText confirmpassET;
    @BindView(R.id.numberET)                    EditText numberET;
    @BindView(R.id.referralET)                  EditText referralET;
    @BindView(R.id.registerBTN)                 TextView registerBTN;
    @BindView(R.id.registerLayout)              View registerLayout;
    @BindView(R.id.loginLayout)                 View loginLayout;

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
        loginTXT.setOnClickListener(this);
        registerTXT.setOnClickListener(this);
        loginBTN.setOnClickListener(this);
        shopBTN.setOnClickListener(this);
        registerBTN.setOnClickListener(this);
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
            case R.id.loginBTN:
                landingActivity.startMainActivity("home");
              break;
            case R.id.registerBTN:
                landingActivity.startRegisterActivity("signup");
                break;
            case R.id.loginTXT:
                registerLayout.setVisibility(View.GONE);
                loginLayout.setVisibility(View.VISIBLE);
                registerBTN.setVisibility(View.GONE);
                loginBTN.setVisibility(View.VISIBLE);
                loginTXT.setBackgroundResource(R.drawable.circular_tv);
                registerTXT.setBackgroundResource(0);
                break;
            case R.id.registerTXT:
                loginLayout.setVisibility(View.GONE);
                registerLayout.setVisibility(View.VISIBLE);
                registerBTN.setVisibility(View.VISIBLE);
                loginBTN.setVisibility(View.GONE);
                loginTXT.setBackgroundResource(0);
                registerTXT.setBackgroundResource(R.drawable.circular_tv);
                break;


        }

    }
}
