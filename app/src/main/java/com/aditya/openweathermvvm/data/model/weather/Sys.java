package com.aditya.openweathermvvm.data.model.weather;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("pod")
    public final String pod;

    public Sys(String pod) {
        this.pod = pod;
    }
}
