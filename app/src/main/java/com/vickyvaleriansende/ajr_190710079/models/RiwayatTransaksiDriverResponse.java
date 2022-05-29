package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RiwayatTransaksiDriverResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<RiwayatTransaksiDriverJson> riwayatList;

    public String getMessage(){
        return message;
    }

    public List<RiwayatTransaksiDriverJson> getRiwayatList() {
        return riwayatList;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
