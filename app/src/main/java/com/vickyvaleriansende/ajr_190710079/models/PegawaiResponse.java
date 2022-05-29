package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class PegawaiResponse {
    private String message;

    @SerializedName("data")
    private PegawaiJson pegawai;

    public PegawaiJson getPegawai(){
        return pegawai;
    }

    public void setPegawai(PegawaiJson pegawai){
        this.pegawai = pegawai;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
