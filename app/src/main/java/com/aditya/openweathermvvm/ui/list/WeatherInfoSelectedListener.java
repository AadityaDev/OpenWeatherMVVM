package com.aditya.openweathermvvm.ui.list;

import com.aditya.openweathermvvm.data.model.weather.WeatherInfo;

public interface WeatherInfoSelectedListener {

    void onWeatherSelected(WeatherInfo weatherInfo, String country);

}
