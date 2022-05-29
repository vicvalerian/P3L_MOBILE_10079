package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class DriverResponse {
    private String message;

    @SerializedName("data")
    private DriverJson driver;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public DriverJson getDriver(){
        return driver;
    }

    public void setDriver(DriverJson driver){
        this.driver = driver;
    }
}
