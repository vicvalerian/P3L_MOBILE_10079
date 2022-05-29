package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class PromoJson {
    @SerializedName("id_promo")
    private int id_promo = 0;

    @SerializedName("kode_promo")
    private String kode_promo;

    @SerializedName("jenis_promo")
    private String jenis_promo;

    @SerializedName("keterangan_promo")
    private String keterangan_promo;

    @SerializedName("diskon_promo")
    private String diskon_promo;

    @SerializedName("status_promo")
    private String status_promo;

    public PromoJson(int id_promo, String kode_promo, String jenis_promo, String keterangan_promo, String diskon_promo, String status_promo) {
        this.id_promo = id_promo;
        this.kode_promo = kode_promo;
        this.jenis_promo = jenis_promo;
        this.keterangan_promo = keterangan_promo;
        this.diskon_promo = diskon_promo;
        this.status_promo = status_promo;
    }

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public String getKode_promo() {
        return kode_promo;
    }

    public void setKode_promo(String kode_promo) {
        this.kode_promo = kode_promo;
    }

    public String getJenis_promo() {
        return jenis_promo;
    }

    public void setJenis_promo(String jenis_promo) {
        this.jenis_promo = jenis_promo;
    }

    public String getKeterangan_promo() {
        return keterangan_promo;
    }

    public void setKeterangan_promo(String keterangan_promo) {
        this.keterangan_promo = keterangan_promo;
    }

    public String getDiskon_promo() {
        return diskon_promo;
    }

    public void setDiskon_promo(String diskon_promo) {
        this.diskon_promo = diskon_promo;
    }

    public String getStatus_promo() {
        return status_promo;
    }

    public void setStatus_promo(String status_promo) {
        this.status_promo = status_promo;
    }
}
