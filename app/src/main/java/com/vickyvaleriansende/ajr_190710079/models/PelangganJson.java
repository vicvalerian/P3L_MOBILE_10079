package com.vickyvaleriansende.ajr_190710079.models;

import androidx.databinding.BaseObservable;

public class PelangganJson extends BaseObservable {

    private String id_pelanggan;
    private String nama_pelanggan;
    private String alamat_pelanggan;
    private String tgl_lahir_pelanggan;
    private String jenis_kelamin_pelanggan;
    private String email_pelanggan;
    private String notelp_pelanggan;
    private String no_ktp_pelanggan;
    private String no_sim_pelanggan;
    private String password_pelanggan;
    private String status_pelanggan;

    public PelangganJson(String id_pelanggan, String nama_pelanggan, String alamat_pelanggan, String tgl_lahir_pelanggan, String jenis_kelamin_pelanggan, String email_pelanggan, String notelp_pelanggan, String no_ktp_pelanggan, String no_sim_pelanggan, String password_pelanggan, String status_pelanggan) {
        this.id_pelanggan = id_pelanggan;
        this.nama_pelanggan = nama_pelanggan;
        this.alamat_pelanggan = alamat_pelanggan;
        this.tgl_lahir_pelanggan = tgl_lahir_pelanggan;
        this.jenis_kelamin_pelanggan = jenis_kelamin_pelanggan;
        this.email_pelanggan = email_pelanggan;
        this.notelp_pelanggan = notelp_pelanggan;
        this.no_ktp_pelanggan = no_ktp_pelanggan;
        this.no_sim_pelanggan = no_sim_pelanggan;
        this.password_pelanggan = password_pelanggan;
        this.status_pelanggan = status_pelanggan;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getAlamat_pelanggan() {
        return alamat_pelanggan;
    }

    public void setAlamat_pelanggan(String alamat_pelanggan) {
        this.alamat_pelanggan = alamat_pelanggan;
    }

    public String getTgl_lahir_pelanggan() {
        return tgl_lahir_pelanggan;
    }

    public void setTgl_lahir_pelanggan(String tgl_lahir_pelanggan) {
        this.tgl_lahir_pelanggan = tgl_lahir_pelanggan;
    }

    public String getJenis_kelamin_pelanggan() {
        return jenis_kelamin_pelanggan;
    }

    public void setJenis_kelamin_pelanggan(String jenis_kelamin_pelanggan) {
        this.jenis_kelamin_pelanggan = jenis_kelamin_pelanggan;
    }

    public String getEmail_pelanggan() {
        return email_pelanggan;
    }

    public void setEmail_pelanggan(String email_pelanggan) {
        this.email_pelanggan = email_pelanggan;
    }

    public String getNotelp_pelanggan() {
        return notelp_pelanggan;
    }

    public void setNotelp_pelanggan(String notelp_pelanggan) {
        this.notelp_pelanggan = notelp_pelanggan;
    }

    public String getNo_ktp_pelanggan() {
        return no_ktp_pelanggan;
    }

    public void setNo_ktp_pelanggan(String no_ktp_pelanggan) {
        this.no_ktp_pelanggan = no_ktp_pelanggan;
    }

    public String getNo_sim_pelanggan() {
        return no_sim_pelanggan;
    }

    public void setNo_sim_pelanggan(String no_sim_pelanggan) {
        this.no_sim_pelanggan = no_sim_pelanggan;
    }

    public String getPassword_pelanggan() {
        return password_pelanggan;
    }

    public void setPassword_pelanggan(String password_pelanggan) {
        this.password_pelanggan = password_pelanggan;
    }

    public String getStatus_pelanggan() {
        return status_pelanggan;
    }

    public void setStatus_pelanggan(String status_pelanggan) {
        this.status_pelanggan = status_pelanggan;
    }
}
