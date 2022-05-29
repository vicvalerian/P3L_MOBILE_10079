package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class LoginResponse {
    private String message;

    @SerializedName("login")
    private List<Login> loginList;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public List<Login> getLoginList(){
        return loginList;
    }

    public void setLoginList(List<Login> loginList){
        this.loginList = loginList;
    }
}
