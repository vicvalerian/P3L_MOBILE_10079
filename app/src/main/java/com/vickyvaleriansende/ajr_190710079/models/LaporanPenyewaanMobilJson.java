package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class LaporanPenyewaanMobilJson {
    @SerializedName("tipe_mobil")
    private String tipe_mobil = null;

    @SerializedName("nama_mobil")
    private String nama_mobil = null;

    @SerializedName("jumlah_peminjaman")
    private int jumlah_peminjaman = 0;

    @SerializedName("jumlah_pendapatan_mobil")
    private int jumlah_pendapatan_mobil = 0;

    public LaporanPenyewaanMobilJson(String tipe_mobil, String nama_mobil, int jumlah_peminjaman, int jumlah_pendapatan_mobil) {
        this.tipe_mobil = tipe_mobil;
        this.nama_mobil = nama_mobil;
        this.jumlah_peminjaman = jumlah_peminjaman;
        this.jumlah_pendapatan_mobil = jumlah_pendapatan_mobil;
    }

    public String getTipe_mobil() {
        return tipe_mobil;
    }

    public void setTipe_mobil(String tipe_mobil) {
        this.tipe_mobil = tipe_mobil;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public int getJumlah_peminjaman() {
        return jumlah_peminjaman;
    }

    public void setJumlah_peminjaman(int jumlah_peminjaman) {
        this.jumlah_peminjaman = jumlah_peminjaman;
    }

    public int getJumlah_pendapatan_mobil() {
        return jumlah_pendapatan_mobil;
    }

    public void setJumlah_pendapatan_mobil(int jumlah_pendapatan_mobil) {
        this.jumlah_pendapatan_mobil = jumlah_pendapatan_mobil;
    }
}
