package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;



public class UserModel extends AndroidModel {
    @SerializedName("name")
    public String name;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public UserModel convertFromJson(String json) {
        return convertFromJson(json, UserModel.class);
    }
}
