package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanTop5PelangganResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanTop5PelangganJson> laporanTop5PelangganJsonList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanTop5PelangganJson> getLaporanTop5PelangganJsonList() {
        return laporanTop5PelangganJsonList;
    }

    public void setLaporanTop5PelangganJsonList(List<LaporanTop5PelangganJson> laporanTop5PelangganJsonList) {
        this.laporanTop5PelangganJsonList = laporanTop5PelangganJsonList;
    }
}
