package com.aditya.openweathermvvm.data.model.weather;

public class Weather {

    public final long id;
    public final String main;
    public final String description;
    public final String icon;

    public Weather(long id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
}
