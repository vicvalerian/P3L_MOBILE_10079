package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MobilResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<MobilJson> mobilList;

    public String getMessage(){
        return message;
    }

    public List<MobilJson> getMobilList() {
        return mobilList;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
