package com.cloversoft.ks.android.fragment.profile;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.ProfileActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.asksira.bsimagepicker.BSImagePicker;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Evanson on 2019-10-02.
 */

public class UpdateProfileFragment extends BaseFragment implements View.OnFocusChangeListener, BSImagePicker.OnSingleImageSelectedListener {
    public static final String TAG = UpdateProfileFragment.class.getName().toString();


    @BindView(R.id.fnameET)             EditText fnameET;
    @BindView(R.id.lnameET)             EditText lnameET;
    @BindView(R.id.numberET)            EditText numberET;
    @BindView(R.id.emailET)             EditText emailET;
    @BindView(R.id.fnameLineV)          View fnameLineV;
    @BindView(R.id.lnameLineV)          View lnameLineV;
    @BindView(R.id.numberLineV)         View numberLineV;
    @BindView(R.id.emailLineV)          View emailLineV;

    @BindView(R.id.profileIMG)          ImageView profileIMG;
    @BindView(R.id.uploadBTN)           TextView uploadBTN;

    public static UpdateProfileFragment newInstance() {
        UpdateProfileFragment fragment = new UpdateProfileFragment();

        return fragment;
    }

    private ProfileActivity profileActivity;


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_update_profile;
    }

    @Override
    public void onViewReady() {
        profileActivity = (ProfileActivity) getContext();
        fnameET.setOnFocusChangeListener(this);
        lnameET.setOnFocusChangeListener(this);
        numberET.setOnFocusChangeListener(this);
        emailET.setOnFocusChangeListener(this);
        profileActivity.setTitle("Profile");
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();

    }



    @OnClick(R.id.uploadBTN)
    void uploadBTNClicked(){
        openFileChooser();
    }

    @OnClick(R.id.doneBTN)
    void doneBTNClicked(){
        profileActivity.onBackPressed();
    }

    @OnClick(R.id.profileIMG)
    void profileIMGClicked(){
        openFileChooser();
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


    private void openFileChooser() {
        BSImagePicker pickerDialog = new BSImagePicker.Builder("com.cloversoft.ks.fileprovider").build();
        pickerDialog.show(getChildFragmentManager(), "picker");

    }


    @Override
    public void onSingleImageSelected(Uri uri, String tag) {

        Glide.with(getContext())
                .load(uri)
                .thumbnail(0.1f)
                .apply(new RequestOptions().placeholder(R.color.gray).error(R.color.gray))
                .into(profileIMG);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){

            case R.id.fnameET:

                if(hasFocus){
                    fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorPrimary));
                    lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));

                }else{
                    try{
                        fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    }catch (Exception ex){
                        Log.e("Exception: ", ex.getMessage());
                    }
                }
                break;


            case R.id.lnameET:

                if(hasFocus){
                    fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorPrimary));
                    numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));

                }else{
                    try{
                        fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    }catch (Exception ex){
                        Log.e("Exception: ", ex.getMessage());
                    }
                }
                break;


            case R.id.numberET:

                if(hasFocus){
                    fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorPrimary));
                    emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));

                }else{
                    try{
                        fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    }catch (Exception ex){
                        Log.e("Exception: ", ex.getMessage());
                    }
                }
                break;


            case R.id.emailET:

                if(hasFocus){
                    fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorPrimary));
                }else{
                    try{
                        fnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        lnameLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        numberLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                        emailLineV.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.gray));
                    }catch (Exception ex){
                        Log.e("Exception: ", ex.getMessage());
                    }
                }
                break;
        }
    }
}