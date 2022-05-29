package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class PelangganResponse {
    private String message;

    @SerializedName("data")
    private PelangganJson pelanggan;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public PelangganJson getPelanggan(){
        return pelanggan;
    }

    public void setCustomer(PelangganJson pelanggan){
        this.pelanggan = pelanggan;
    }
}
