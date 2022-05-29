package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanPenyewaanMobilResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanPenyewaanMobilJson> laporanPenyewaanMobilJsonList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanPenyewaanMobilJson> getlaporanPenyewaanMobilJsonList() {
        return laporanPenyewaanMobilJsonList;
    }

    public void setlaporanPenyewaanMobilJsonList(List<LaporanPenyewaanMobilJson> laporanPenyewaanMobilJsonList) {
        this.laporanPenyewaanMobilJsonList = laporanPenyewaanMobilJsonList;
    }
}
