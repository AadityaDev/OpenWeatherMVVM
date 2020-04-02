package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

public class Snow {

    @SerializedName("3h")
    public final double dense;

    public Snow(double dense) {
        this.dense = dense;
    }
}
