package com.cloversoft.ks.vendor.server.transformer;

import com.google.gson.annotations.SerializedName;



public class SingleTransformer<T> extends BaseTransformer{

    @SerializedName("data")
    public T data;
}
