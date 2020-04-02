package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lat")
    public final double latitude;
    @SerializedName("lon")
    public final double longitude;

    public Coord(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
