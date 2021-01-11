package com.cloversoft.ks.android.route;

import android.content.Intent;
import android.os.Bundle;

import com.cloversoft.ks.android.activity.LandingActivity;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.android.activity.ProfileActivity;
import com.cloversoft.ks.android.activity.RegisterActivity;
import com.cloversoft.ks.vendor.android.base.BaseActivity;
import com.cloversoft.ks.vendor.android.base.RouteManager;


public class RouteActivity extends BaseActivity {

    public void startMainActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(MainActivity.class)
                .addActivityTag("main")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
    }

    public void startRegisterActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(RegisterActivity.class)
                .addActivityTag("register")
                .addFragmentTag(fragmentTAG)
                .startActivity();
    }

    public void startLandingActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(LandingActivity.class)
                .addActivityTag("landing")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
    }

    public void startProfileActivity(String fragmentTAG){
        Bundle bundle = new Bundle();
        RouteManager.Route.with(this)
                .addActivityClass(ProfileActivity.class)
                .addActivityTag("cash_in")
                .addFragmentTag(fragmentTAG)
                .startActivity();
    }


//    @Subscribe
//    public void invalidToken(InvalidToken invalidToken){
//        Log.e("Token", "Expired");
//        EventBus.getDefault().unregister(this);
//        UserData.insert(new UserModel());
//        UserData.insert(UserData.TOKEN_EXPIRED, true);
//        startLandingActivity();
//    }
}
