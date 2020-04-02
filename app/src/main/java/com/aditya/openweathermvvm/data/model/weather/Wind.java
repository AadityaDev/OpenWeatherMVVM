package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    public final double speed;

    @SerializedName("deg")
    public final long degree;

    public Wind(double speed, long degree) {
        this.speed = speed;
        this.degree = degree;
    }
}
