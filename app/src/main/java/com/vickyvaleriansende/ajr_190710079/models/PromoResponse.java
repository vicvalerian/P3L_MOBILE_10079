package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PromoResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<PromoJson> promoList;

    public String getMessage(){
        return message;
    }

    public List<PromoJson> getPromoList() {
        return promoList;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
