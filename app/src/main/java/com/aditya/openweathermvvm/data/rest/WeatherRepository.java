package com.aditya.openweathermvvm.data.rest;

import androidx.annotation.NonNull;

import com.aditya.openweathermvvm.data.model.weather.CityWeather;
import com.aditya.openweathermvvm.data.model.weather.WeatherInfo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class WeatherRepository {

    private final WeatherService weatherService;

    @Inject
    public WeatherRepository(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    public Single<List<WeatherInfo>> getWeatherInfoLists() {
//        return weatherService.getWeatherInfoList();
//    }

    public Single<CityWeather> getDelhiWeatherInfoLists() {
        return weatherService.getDelhiWeatherInfoList();
    }

//    public Single<CityWeather> getCountryWeatherInfoList(@NonNull String countryCode) {
//        return weatherService.getCountryWeatherInfoList(countryCode);
//    }

}
