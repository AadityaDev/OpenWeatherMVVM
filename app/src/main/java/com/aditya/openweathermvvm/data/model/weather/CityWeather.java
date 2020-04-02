package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityWeather {

    @SerializedName("cod")
    private String code;

    @SerializedName("message")
    private int message;

    @SerializedName("cnt")
    private int count;

    @SerializedName("list")
    private List<WeatherInfo> weatherInfoList;

    @SerializedName("city")
    private City city;

    public CityWeather() {

    }

//    public CityWeather(String code, int message, int count, List<WeatherInfo> weatherInfoList, City city) {
//        this.code = code;
//        this.message = message;
//        this.count = count;
//        this.weatherInfoList = weatherInfoList;
//        this.city = city;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<WeatherInfo> getWeatherInfoList() {
        return weatherInfoList;
    }

    public void setWeatherInfoList(List<WeatherInfo> weatherInfoList) {
        this.weatherInfoList = weatherInfoList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
