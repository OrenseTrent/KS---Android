package com.cloversoft.ks.android.activity;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.adapter.DrawerAdapter;
import com.cloversoft.ks.android.fragment.DefaultFragment;
import com.cloversoft.ks.android.fragment.main.HomeFragment;
import com.cloversoft.ks.android.fragment.main.SettingsFragment;
import com.cloversoft.ks.android.route.RouteActivity;
import com.cloversoft.ks.data.model.api.NavDrawerModel;
import com.cloversoft.ks.vendor.android.java.Keyboard;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends RouteActivity implements DrawerAdapter.ClickListener {
    public static final String TAG = MainActivity.class.getName().toString();


    private DrawerAdapter drawerAdapter;
    ColorStateList defaultColor;

    @BindView(R.id.homeCon)                     View homeCON;
    @BindView(R.id.scanCon)                     View scanCON;
    @BindView(R.id.settingsCON)                 View settingsCON;
    @BindView(R.id.homeIMG)                     ImageView homeIMG;
    @BindView(R.id.scanIMG)                     ImageView scanIMG;
    @BindView(R.id.settingsIMG)                 ImageView settingsIMG;
    @BindView(R.id.homeTXT)                     TextView homeTXT;
    @BindView(R.id.scanTXT)                     TextView scanTXT;
    @BindView(R.id.settingsTXT)                 TextView settingsTXT;
    @BindView(R.id.drawer_layout)               DrawerLayout drawer_layout;
    @BindView(R.id.profileNavIMG)               ImageView profileNavIMG;
    @BindView(R.id.profileBTN)                  ImageView profileBTN;
    @BindView(R.id.nameTXT)                     TextView nameTXT;
    @BindView(R.id.descTXT)                     TextView descTXT;
    @BindView(R.id.drawerLV)                    ListView drawerLV;

    @Override
    public int onLayoutSet() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewReady() {
        SetDrawer();
        defaultColor = homeTXT.getTextColors();
    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "home":
                openHomeFragment();
                break;
            case "settings":
                openSettingsFragment();
                break;
                default:
                    openDefaultFragment();
                break;
        }
    }

    public void openDefaultFragment(){
        switchFragment(DefaultFragment.newInstance());
    }
    public void openHomeFragment(){ switchFragment(HomeFragment.newInstance()); }
    public void openSettingsFragment(){ switchFragment(SettingsFragment.newInstance()); }


    public void setSelectedItem(String item) {
        drawerAdapter.setSelectedItem(item);
    }

    private void SetDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.setDrawerListener(toggle);
        toggle.syncState();

        drawerAdapter = new DrawerAdapter(getContext());
        drawerAdapter.setClickListener(this);
        drawerAdapter.setNewData(NavDrawer());

        drawerLV.setAdapter(drawerAdapter);
    }

    private List<NavDrawerModel> NavDrawer() {
        List<NavDrawerModel> navDrawerListModels = new ArrayList<>();

        NavDrawerModel navDrawerModel = new NavDrawerModel();
        navDrawerModel.id = 1;
        navDrawerModel.item = "Home";
        navDrawerListModels.add(navDrawerModel);

        navDrawerModel = new NavDrawerModel();
        navDrawerModel.id = 2;
        navDrawerModel.item = "Settings";
        navDrawerListModels.add(navDrawerModel);

        return navDrawerListModels;
    }

    public void drawer() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            drawer_layout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.menuBTN)
    void menuBTNOnClicked(){
        drawer();
    }


    @OnClick(R.id.profileNavIMG)
    void profileNavIMGOnClicked(){
        startProfileActivity("update_profile");
    }

    @OnClick(R.id.profileBTN)
    void profileBTNClicked(){
        startProfileActivity("update_profile");
    }

    @OnClick(R.id.homeCon)
    public void homeActives(){
        homeActive();
        openHomeFragment();
    }

    @OnClick(R.id.scanCon)
    public void scanActives(){
        scanActive();
        startProfileActivity("update_profile");
    }

    @OnClick(R.id.settingsCON)
    public void settingActives(){
        settingActive();
        openSettingsFragment();
    }


    @Override
    public void onItemClick(NavDrawerModel navDrawerModel) {
        drawer_layout.closeDrawer(GravityCompat.START);
        switch (navDrawerModel.id) {
            case 1:
                openHomeFragment();
                Keyboard.hideKeyboard(this);
                break;
            case 2:
                openSettingsFragment();
                Keyboard.hideKeyboard(this);
                break;
        }
    }

    public void homeActive(){
        homeCON.setSelected(true);
        homeIMG.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        homeTXT.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        scanCON.setSelected(false);
        scanIMG.clearColorFilter();
        scanTXT.setTextColor(defaultColor);
        settingsCON.setSelected(false);
        settingsIMG.clearColorFilter();
        settingsTXT.setTextColor(defaultColor);
    }

    public void scanActive(){
        homeCON.setSelected(false);
        homeIMG.clearColorFilter();
        homeTXT.setTextColor(defaultColor);
        scanCON.setSelected(true);
        scanIMG.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        scanTXT.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        settingsCON.setSelected(false);
        settingsIMG.clearColorFilter();
        settingsTXT.setTextColor(defaultColor);
    }

    public void settingActive(){
        homeCON.setSelected(false);
        homeIMG.clearColorFilter();
        homeTXT.setTextColor(defaultColor);
        scanCON.setSelected(false);
        scanIMG.clearColorFilter();
        scanTXT.setTextColor(defaultColor);
        settingsCON.setSelected(true);
        settingsIMG.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        settingsTXT.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
    }
}
