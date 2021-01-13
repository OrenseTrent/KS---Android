package com.cloversoft.ks.android.fragment.main;

import android.util.Log;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.android.adapter.DefaultRecyclerViewAdapter;
import com.cloversoft.ks.android.adapter.HomeGameRecyclerViewAdapter;
import com.cloversoft.ks.data.model.api.SampleModel;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomeFragment extends BaseFragment {
    public static final String TAG = HomeFragment.class.getName().toString();

    private MainActivity mainActivity;
    private HomeGameRecyclerViewAdapter homeGameRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;


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
        setUpListView();
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

    private void setUpListView(){
        homeGameRecyclerViewAdapter = new HomeGameRecyclerViewAdapter(getContext());
        homeGameRecyclerViewAdapter.setNewData(getDefaultData());
        linearLayoutManager = new LinearLayoutManager(getContext());
        gameRV.setLayoutManager(linearLayoutManager);
        gameRV.setAdapter(homeGameRecyclerViewAdapter);
    }

    private List<SampleModel> getDefaultData(){
        List<SampleModel> androidModels = new ArrayList<>();
        SampleModel defaultItem;
            defaultItem = new SampleModel();
            defaultItem.id = 1;
            defaultItem.image = R.drawable.cas1;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 2;
            defaultItem.image = R.drawable.cas2;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 3;
            defaultItem.image = R.drawable.cas3;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 4;
            defaultItem.image = R.drawable.cas4;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 5;
            defaultItem.image = R.drawable.a_35;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 6;
            defaultItem.image = R.drawable.cas6;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 7;
            defaultItem.image = R.drawable.sports1;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 8;
            defaultItem.image = R.drawable.sports2;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 9;
            defaultItem.image = R.drawable.sports3;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 10;
            defaultItem.image = R.drawable.es1;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 11;
            defaultItem.image = R.drawable.es2;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 12;
            defaultItem.image = R.drawable.e3;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 13;
            defaultItem.image = R.drawable.es4;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 14;
            defaultItem.image = R.drawable.poker1;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 15;
            defaultItem.image = R.drawable.poker2;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 16;
            defaultItem.image = R.drawable.slot1;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 17;
            defaultItem.image = R.drawable.slot2;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 18;
            defaultItem.image = R.drawable.slot3;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 19;
            defaultItem.image = R.drawable.slot4;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 20;
            defaultItem.image = R.drawable.slot5;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 21;
            defaultItem.image = R.drawable.slot6;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 22;
            defaultItem.image = R.drawable.slot7;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 23;
            defaultItem.image = R.drawable.lottery1;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 24;
            defaultItem.image = R.drawable.lottery2;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 25;
            defaultItem.image = R.drawable.lottery3;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 26;
            defaultItem.image = R.drawable.lottery4;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 27;
            defaultItem.image = R.drawable.lottery5;
            androidModels.add(defaultItem);

            defaultItem = new SampleModel();
            defaultItem.id = 28;
            defaultItem.image = R.drawable.lottery6;
            androidModels.add(defaultItem);

        return androidModels;
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
