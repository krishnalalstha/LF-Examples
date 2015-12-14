package com.lf.example.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nen on 11/23/15.
 */
public class UserInfo {
    @SerializedName("name")
    public String userName;

    @SerializedName("address")
    public String address;

}
