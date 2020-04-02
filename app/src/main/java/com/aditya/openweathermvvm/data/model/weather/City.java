package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    public final long id;

    @SerializedName("name")
    public final String name;

    @SerializedName("coord")
    public final Coord coord;

    @SerializedName("country")
    public final String country;

    @SerializedName("population")
    public final int population;

    @SerializedName("timezone")
    public final long timezone;

    @SerializedName("sunrise")
    public final long sunriseTime;

    @SerializedName("sunset")
    public final long sunsetTime;

    public City(long id, String name, Coord coord, String country, int population, long timezone,
                long sunriseTime, long sunsetTime) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
        this.timezone = timezone;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
    }
}
