package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherInfo {

    @SerializedName("dt")
    public final long id;
    @SerializedName("main")
    public final AllInfo allInfo;
    @SerializedName("weather")
    public final List<Weather> weather;
    @SerializedName("clouds")
    public final Clouds clouds;
    @SerializedName("wind")
    public final Wind wind;
    @SerializedName("snow")
    public final Snow snow;
    @SerializedName("sys")
    public final Sys sys;
    @SerializedName("dt_txt")
    public final String date;

    public WeatherInfo(long id, AllInfo allInfo, List<Weather> weather, Clouds clouds, Wind wind,
                       Snow snow, Sys sys, String date) {
        this.id = id;
        this.allInfo = allInfo;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.snow = snow;
        this.sys = sys;
        this.date = date;
    }
}
