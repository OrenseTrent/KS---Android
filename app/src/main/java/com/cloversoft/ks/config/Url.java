package com.cloversoft.ks.config;

import com.cloversoft.ks.vendor.android.java.security.SecurityLayer;



public class Url extends SecurityLayer {
    public static final String PRODUCTION_URL = decrypt("https://www.appgradingtechnology.com");
    public static final String DEBUG_URL = decrypt("https://www.appgradingtechnology.com");

    public static final String APP = App.production ? PRODUCTION_URL : DEBUG_URL;
}
