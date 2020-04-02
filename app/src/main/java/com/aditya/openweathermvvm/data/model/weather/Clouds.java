package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    public final long all;

    public Clouds(long all) {
        this.all = all;
    }
}
