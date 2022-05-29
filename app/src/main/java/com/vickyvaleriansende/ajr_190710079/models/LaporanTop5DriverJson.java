package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class LaporanTop5DriverJson {
    @SerializedName("id_driver")
    private String id_driver = null;

    @SerializedName("nama_driver")
    private String nama_driver = null;

    @SerializedName("jumlah_transaksi")
    private int jumlah_transaksi = 0;

    public LaporanTop5DriverJson(String id_driver, String nama_driver, int jumlah_transaksi) {
        this.id_driver = id_driver;
        this.nama_driver = nama_driver;
        this.jumlah_transaksi = jumlah_transaksi;
    }

    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(String id_driver) {
        this.id_driver = id_driver;
    }

    public String getNama_driver() {
        return nama_driver;
    }

    public void setNama_driver(String nama_driver) {
        this.nama_driver = nama_driver;
    }

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(int jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
    }
}
