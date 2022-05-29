package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class LaporanPendapatanTransaksiJson {
    @SerializedName("nama_pelanggan")
    private String nama_pelanggan = null;

    @SerializedName("nama_mobil")
    private String nama_mobil = null;

    @SerializedName("jenis_transaksi")
    private String jenis_transaksi = null;

    @SerializedName("jumlah_transaksi")
    private int jumlah_transaksi = 0;

    @SerializedName("pendapatan")
    private int pendapatan = 0;

    public LaporanPendapatanTransaksiJson(String nama_pelanggan, String nama_mobil, String jenis_transaksi, int jumlah_transaksi, int pendapatan) {
        this.nama_pelanggan = nama_pelanggan;
        this.nama_mobil = nama_mobil;
        this.jenis_transaksi = jenis_transaksi;
        this.jumlah_transaksi = jumlah_transaksi;
        this.pendapatan = pendapatan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getJenis_transaksi() {
        return jenis_transaksi;
    }

    public void setJenis_transaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(int jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
    }

    public int getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(int pendapatan) {
        this.pendapatan = pendapatan;
    }
}
