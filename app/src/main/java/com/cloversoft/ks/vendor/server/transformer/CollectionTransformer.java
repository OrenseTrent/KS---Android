package com.cloversoft.ks.vendor.server.transformer;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class CollectionTransformer<T> extends BaseTransformer{

    @SerializedName("data")
    public List<T> data;
}
