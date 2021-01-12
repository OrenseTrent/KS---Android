package com.cloversoft.ks.android.fragment.main;

import android.util.Log;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;


public class HomeFragment extends BaseFragment {
    public static final String TAG = HomeFragment.class.getName().toString();

    private MainActivity mainActivity;


    @BindView(R.id.sliderLayout)            SliderLayout sliderLayout;
    @BindView(R.id.gameRV)                  RecyclerView gameRV;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();
        setupSlider();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setTitle("Home");
        mainActivity.homeActive();
    }

    private void setupSlider(){
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(3); //set scroll delay in seconds :
        for (int i = 0; i <= 2; i++) {

            SliderView sliderView = new SliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.banner_1);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.banner_2);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.banner_3);
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
//                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
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
