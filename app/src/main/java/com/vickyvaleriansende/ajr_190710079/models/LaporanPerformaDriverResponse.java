package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanPerformaDriverResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanPerformaDriverJson> laporanPerformaDriverJsonList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanPerformaDriverJson> getLaporanPerformaDriverJsonList() {
        return laporanPerformaDriverJsonList;
    }

    public void setLaporanPerformaDriverJsonList(List<LaporanPerformaDriverJson> laporanPerformaDriverJsonList) {
        this.laporanPerformaDriverJsonList = laporanPerformaDriverJsonList;
    }
}
