package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

public class MobilJson {
    @SerializedName("id_mobil")
    private int id_mobil = 0;

    @SerializedName("plat_mobil")
    private String plat_mobil;

    @SerializedName("nama_mobil")
    private String nama_mobil;

    @SerializedName("tipe_mobil")
    private String tipe_mobil;

    @SerializedName("jenis_transmisi")
    private String jenis_transmisi;

    @SerializedName("jenis_bahan_bakar")
    private String jenis_bahan_bakar;

    @SerializedName("volume_bahan_bakar")
    private String volume_bahan_bakar;

    @SerializedName("warna_mobil")
    private String warna_mobil;

    @SerializedName("kapasitas_penumpang")
    private String kapasitas_penumpang;

    @SerializedName("fasilitas_mobil")
    private String fasilitas_mobil;

    @SerializedName("no_stnk")
    private String no_stnk;

    @SerializedName("kategori_aset")
    private String kategori_aset;

    @SerializedName("sewa_harian_mobil")
    private float sewa_harian_mobil;

    @SerializedName("volume_bagasi")
    private String volume_bagasi;

    @SerializedName("foto_mobil")
    private String foto_mobil;

    @SerializedName("status_mobil")
    private String status_mobil;

    public MobilJson(int id_mobil, String plat_mobil, String nama_mobil, String tipe_mobil, String jenis_transmisi, String jenis_bahan_bakar, String volume_bahan_bakar, String warna_mobil, String kapasitas_penumpang, String fasilitas_mobil, String no_stnk, String kategori_aset, float sewa_harian_mobil, String volume_bagasi, String foto_mobil, String status_mobil) {
        this.id_mobil = id_mobil;
        this.plat_mobil = plat_mobil;
        this.nama_mobil = nama_mobil;
        this.tipe_mobil = tipe_mobil;
        this.jenis_transmisi = jenis_transmisi;
        this.jenis_bahan_bakar = jenis_bahan_bakar;
        this.volume_bahan_bakar = volume_bahan_bakar;
        this.warna_mobil = warna_mobil;
        this.kapasitas_penumpang = kapasitas_penumpang;
        this.fasilitas_mobil = fasilitas_mobil;
        this.no_stnk = no_stnk;
        this.kategori_aset = kategori_aset;
        this.sewa_harian_mobil = sewa_harian_mobil;
        this.volume_bagasi = volume_bagasi;
        this.foto_mobil = foto_mobil;
        this.status_mobil = status_mobil;
    }

    public int getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(int id_mobil) {
        this.id_mobil = id_mobil;
    }

    public String getPlat_mobil() {
        return plat_mobil;
    }

    public void setPlat_mobil(String plat_mobil) {
        this.plat_mobil = plat_mobil;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getTipe_mobil() {
        return tipe_mobil;
    }

    public void setTipe_mobil(String tipe_mobil) {
        this.tipe_mobil = tipe_mobil;
    }

    public String getJenis_transmisi() {
        return jenis_transmisi;
    }

    public void setJenis_transmisi(String jenis_transmisi) {
        this.jenis_transmisi = jenis_transmisi;
    }

    public String getJenis_bahan_bakar() {
        return jenis_bahan_bakar;
    }

    public void setJenis_bahan_bakar(String jenis_bahan_bakar) {
        this.jenis_bahan_bakar = jenis_bahan_bakar;
    }

    public String getVolume_bahan_bakar() {
        return volume_bahan_bakar;
    }

    public void setVolume_bahan_bakar(String volume_bahan_bakar) {
        this.volume_bahan_bakar = volume_bahan_bakar;
    }

    public String getWarna_mobil() {
        return warna_mobil;
    }

    public void setWarna_mobil(String warna_mobil) {
        this.warna_mobil = warna_mobil;
    }

    public String getKapasitas_penumpang() {
        return kapasitas_penumpang;
    }

    public void setKapasitas_penumpang(String kapasitas_penumpang) {
        this.kapasitas_penumpang = kapasitas_penumpang;
    }

    public String getFasilitas_mobil() {
        return fasilitas_mobil;
    }

    public void setFasilitas_mobil(String fasilitas_mobil) {
        this.fasilitas_mobil = fasilitas_mobil;
    }

    public String getNo_stnk() {
        return no_stnk;
    }

    public void setNo_stnk(String no_stnk) {
        this.no_stnk = no_stnk;
    }

    public String getKategori_aset() {
        return kategori_aset;
    }

    public void setKategori_aset(String kategori_aset) {
        this.kategori_aset = kategori_aset;
    }

    public float getSewa_harian_mobil() {
        return sewa_harian_mobil;
    }

    public void setSewa_harian_mobil(float sewa_harian_mobil) {
        this.sewa_harian_mobil = sewa_harian_mobil;
    }

    public String getVolume_bagasi() {
        return volume_bagasi;
    }

    public void setVolume_bagasi(String volume_bagasi) {
        this.volume_bagasi = volume_bagasi;
    }

    public String getFoto_mobil() {
        return foto_mobil;
    }

    public void setFoto_mobil(String foto_mobil) {
        this.foto_mobil = foto_mobil;
    }

    public String getStatus_mobil() {
        return status_mobil;
    }

    public void setStatus_mobil(String status_mobil) {
        this.status_mobil = status_mobil;
    }
}
