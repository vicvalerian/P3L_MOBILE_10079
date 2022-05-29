package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanTop5DriverResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanTop5DriverJson> laporanTop5DriverJsonList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanTop5DriverJson> getLaporanTop5DriverJsonList() {
        return laporanTop5DriverJsonList;
    }

    public void setLaporanTop5DriverJsonList(List<LaporanTop5DriverJson> laporanTop5DriverJsonList) {
        this.laporanTop5DriverJsonList = laporanTop5DriverJsonList;
    }
}
