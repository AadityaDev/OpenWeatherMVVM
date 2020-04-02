package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

public class AllInfo {

    @SerializedName("temp")
    public final double temp;
    @SerializedName("feels_like")
    public final double feelsLike;
    @SerializedName("temp_min")
    public final double tempMin;
    @SerializedName("temp_max")
    public final double tempMax;
    @SerializedName("pressure")
    public final long pressure;
    @SerializedName("sea_level")
    public final long seaLevel;
    @SerializedName("grnd_level")
    public final long groundLevel;
    @SerializedName("humidity")
    public final long humidity;
    @SerializedName("temp_kf")
    public final double tempFarenheit;

    public AllInfo(double temp, double feelsLike, double tempMin, double tempMax, long pressure,
                   long seaLevel, long groundLevel, long humidity, double tempFarenheit) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.groundLevel = groundLevel;
        this.humidity = humidity;
        this.tempFarenheit = tempFarenheit;
    }
}
