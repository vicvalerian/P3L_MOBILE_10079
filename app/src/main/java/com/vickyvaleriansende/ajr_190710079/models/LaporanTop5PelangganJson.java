package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class LaporanTop5PelangganJson {
    @SerializedName("nama_pelanggan")
    private String nama_pelanggan = null;

    @SerializedName("jumlah_transaksi")
    private int jumlah_transaksi = 0;

    public LaporanTop5PelangganJson(String nama_pelanggan, int jumlah_transaksi) {
        this.nama_pelanggan = nama_pelanggan;
        this.jumlah_transaksi = jumlah_transaksi;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(int jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
    }
}
