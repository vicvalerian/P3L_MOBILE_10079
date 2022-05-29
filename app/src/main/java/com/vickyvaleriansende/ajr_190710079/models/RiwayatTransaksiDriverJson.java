package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class RiwayatTransaksiDriverJson {
    @SerializedName("id_detail_transaksi")
    private String id_detail_transaksi = null;

    @SerializedName("nama_pelanggan")
    private String nama_pelanggan = null;

    @SerializedName("nama_driver")
    private String nama_driver = null;

    @SerializedName("nama_pegawai")
    private String nama_pegawai = null;

    @SerializedName("nama_mobil")
    private String nama_mobil = null;

    @SerializedName("tgl_waktu_mulai_sewa")
    private String tgl_waktu_mulai_sewa;

    @SerializedName("tgl_waktu_akhir_sewa")
    private String tgl_waktu_akhir_sewa;

    @SerializedName("tgl_pengembalian")
    private String tgl_pengembalian;

    @SerializedName("jenis_transaksi")
    private String jenis_transaksi;

    @SerializedName("rating_driver_transaksi")
    private float rating_driver_transaksi;

    @SerializedName("denda_transaksi")
    private float denda_transaksi;

    @SerializedName("diskon_transaksi")
    private float diskon_transaksi;

    @SerializedName("jumlah_pembayaran")
    private float jumlah_pembayaran;

    @SerializedName("bukti_pembayaran")
    private String bukti_pembayaran;

    @SerializedName("status_transaksi")
    private String status_transaksi;

    public RiwayatTransaksiDriverJson(String id_detail_transaksi, String nama_pelanggan, String nama_driver, String nama_pegawai, String nama_mobil, String tgl_waktu_mulai_sewa, String tgl_waktu_akhir_sewa, String tgl_pengembalian, String jenis_transaksi, float rating_driver_transaksi, float denda_transaksi, float diskon_transaksi, float jumlah_pembayaran, String bukti_pembayaran, String status_transaksi) {
        this.id_detail_transaksi = id_detail_transaksi;
        this.nama_pelanggan = nama_pelanggan;
        this.nama_driver = nama_driver;
        this.nama_pegawai = nama_pegawai;
        this.nama_mobil = nama_mobil;
        this.tgl_waktu_mulai_sewa = tgl_waktu_mulai_sewa;
        this.tgl_waktu_akhir_sewa = tgl_waktu_akhir_sewa;
        this.tgl_pengembalian = tgl_pengembalian;
        this.jenis_transaksi = jenis_transaksi;
        this.rating_driver_transaksi = rating_driver_transaksi;
        this.denda_transaksi = denda_transaksi;
        this.diskon_transaksi = diskon_transaksi;
        this.jumlah_pembayaran = jumlah_pembayaran;
        this.bukti_pembayaran = bukti_pembayaran;
        this.status_transaksi = status_transaksi;
    }

    public String getId_detail_transaksi() {
        return id_detail_transaksi;
    }

    public void setId_detail_transaksi(String id_detail_transaksi) {
        this.id_detail_transaksi = id_detail_transaksi;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getNama_driver() {
        return nama_driver;
    }

    public void setNama_driver(String nama_driver) {
        this.nama_driver = nama_driver;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getTgl_waktu_mulai_sewa() {
        return tgl_waktu_mulai_sewa;
    }

    public void setTgl_waktu_mulai_sewa(String tgl_waktu_mulai_sewa) {
        this.tgl_waktu_mulai_sewa = tgl_waktu_mulai_sewa;
    }

    public String getTgl_waktu_akhir_sewa() {
        return tgl_waktu_akhir_sewa;
    }

    public void setTgl_waktu_akhir_sewa(String tgl_waktu_akhir_sewa) {
        this.tgl_waktu_akhir_sewa = tgl_waktu_akhir_sewa;
    }

    public String getTgl_pengembalian() {
        return tgl_pengembalian;
    }

    public void setTgl_pengembalian(String tgl_pengembalian) {
        this.tgl_pengembalian = tgl_pengembalian;
    }

    public String getJenis_transaksi() {
        return jenis_transaksi;
    }

    public void setJenis_transaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    public float getRating_driver_transaksi() {
        return rating_driver_transaksi;
    }

    public void setRating_driver_transaksi(float rating_driver_transaksi) {
        this.rating_driver_transaksi = rating_driver_transaksi;
    }

    public float getDenda_transaksi() {
        return denda_transaksi;
    }

    public void setDenda_transaksi(float denda_transaksi) {
        this.denda_transaksi = denda_transaksi;
    }

    public float getDiskon_transaksi() {
        return diskon_transaksi;
    }

    public void setDiskon_transaksi(float diskon_transaksi) {
        this.diskon_transaksi = diskon_transaksi;
    }

    public float getJumlah_pembayaran() {
        return jumlah_pembayaran;
    }

    public void setJumlah_pembayaran(float jumlah_pembayaran) {
        this.jumlah_pembayaran = jumlah_pembayaran;
    }

    public String getBukti_pembayaran() {
        return bukti_pembayaran;
    }

    public void setBukti_pembayaran(String bukti_pembayaran) {
        this.bukti_pembayaran = bukti_pembayaran;
    }

    public String getStatus_transaksi() {
        return status_transaksi;
    }

    public void setStatus_transaksi(String status_transaksi) {
        this.status_transaksi = status_transaksi;
    }
}
