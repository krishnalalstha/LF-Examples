package com.lf.example.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by krish on 22/11/15.
 */
public class MyApplication extends Application {
    public static RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = getVolleyInstace();
    }


    public RequestQueue getVolleyInstace() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
            return mRequestQueue;
        } else {
            return mRequestQueue;
        }
    }
}
