package com.aditya.openweathermvvm.data.rest;

import androidx.annotation.NonNull;

import com.aditya.openweathermvvm.data.model.weather.CityWeather;
import com.aditya.openweathermvvm.data.model.weather.WeatherInfo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WeatherService {

    @GET("https://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=bacb0be049111d369c30de80db6bd99a")
    Single<List<WeatherInfo>> getWeatherInfoList();

    @GET("https://api.openweathermap.org/data/2.5/forecast?q=Delhi,India&appid=bacb0be049111d369c30de80db6bd99a")
    Single<CityWeather> getDelhiWeatherInfoList();

    @GET("https://api.openweathermap.org/data/2.5/forecast?q=Delhi,India&appid=bacb0be049111d369c30de80db6bd99a")
    Single<CityWeather> getCountryWeatherInfoList(@NonNull String countryCode);

}
