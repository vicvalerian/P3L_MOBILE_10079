package com.vickyvaleriansende.ajr_190710079.models;

import androidx.databinding.BaseObservable;

public class DriverJson extends BaseObservable{

    private String id_driver;
    private String nama_driver;
    private String alamat_driver;
    private String tgl_lahir_driver;
    private String jenis_kelamin_driver;
    private String bahasa_driver;
    private String foto_driver;
    private String notelp_driver;
    private String email_driver;
    private float sewa_harian_driver;
    private String status_driver;
    private float rating_driver;
    private String password_driver;
    private String sim_driver;
    private String surat_bebas_napza;
    private String surat_jiwa_jasmani;
    private String skck_driver;

    public DriverJson(String id_driver, String nama_driver, String alamat_driver, String tgl_lahir_driver, String jenis_kelamin_driver, String bahasa_driver, String foto_driver, String notelp_driver, String email_driver, float sewa_harian_driver, String status_driver, float rating_driver, String password_driver, String sim_driver, String surat_bebas_napza, String surat_jiwa_jasmani, String skck_driver) {
        this.id_driver = id_driver;
        this.nama_driver = nama_driver;
        this.alamat_driver = alamat_driver;
        this.tgl_lahir_driver = tgl_lahir_driver;
        this.jenis_kelamin_driver = jenis_kelamin_driver;
        this.bahasa_driver = bahasa_driver;
        this.foto_driver = foto_driver;
        this.notelp_driver = notelp_driver;
        this.email_driver = email_driver;
        this.sewa_harian_driver = sewa_harian_driver;
        this.status_driver = status_driver;
        this.rating_driver = rating_driver;
        this.password_driver = password_driver;
        this.sim_driver = sim_driver;
        this.surat_bebas_napza = surat_bebas_napza;
        this.surat_jiwa_jasmani = surat_jiwa_jasmani;
        this.skck_driver = skck_driver;
    }

    public DriverJson(String nama_driver, String alamat_driver, String tgl_lahir_driver, String jenis_kelamin_driver, String bahasa_driver, String notelp_driver, String email_driver, String status_driver, String password_driver) {
        this.nama_driver = nama_driver;
        this.alamat_driver = alamat_driver;
        this.tgl_lahir_driver = tgl_lahir_driver;
        this.jenis_kelamin_driver = jenis_kelamin_driver;
        this.bahasa_driver = bahasa_driver;
        this.notelp_driver = notelp_driver;
        this.email_driver = email_driver;
        this.status_driver = status_driver;
        this.password_driver = password_driver;
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

    public String getAlamat_driver() {
        return alamat_driver;
    }

    public void setAlamat_driver(String alamat_driver) {
        this.alamat_driver = alamat_driver;
    }

    public String getTgl_lahir_driver() {
        return tgl_lahir_driver;
    }

    public void setTgl_lahir_driver(String tgl_lahir_driver) {
        this.tgl_lahir_driver = tgl_lahir_driver;
    }

    public String getJenis_kelamin_driver() {
        return jenis_kelamin_driver;
    }

    public void setJenis_kelamin_driver(String jenis_kelamin_driver) {
        this.jenis_kelamin_driver = jenis_kelamin_driver;
    }

    public String getBahasa_driver() {
        return bahasa_driver;
    }

    public void setBahasa_driver(String bahasa_driver) {
        this.bahasa_driver = bahasa_driver;
    }

    public String getFoto_driver() {
        return foto_driver;
    }

    public void setFoto_driver(String foto_driver) {
        this.foto_driver = foto_driver;
    }

    public String getNotelp_driver() {
        return notelp_driver;
    }

    public void setNotelp_driver(String notelp_driver) {
        this.notelp_driver = notelp_driver;
    }

    public String getEmail_driver() {
        return email_driver;
    }

    public void setEmail_driver(String email_driver) {
        this.email_driver = email_driver;
    }

    public float getSewa_harian_driver() {
        return sewa_harian_driver;
    }

    public void setSewa_harian_driver(float sewa_harian_driver) {
        this.sewa_harian_driver = sewa_harian_driver;
    }

    public String getStatus_driver() {
        return status_driver;
    }

    public void setStatus_driver(String status_driver) {
        this.status_driver = status_driver;
    }

    public float getRating_driver() {
        return rating_driver;
    }

    public void setRating_driver(float rating_driver) {
        this.rating_driver = rating_driver;
    }

    public String getPassword_driver() {
        return password_driver;
    }

    public void setPassword_driver(String password_driver) {
        this.password_driver = password_driver;
    }

    public String getSim_driver() {
        return sim_driver;
    }

    public void setSim_driver(String sim_driver) {
        this.sim_driver = sim_driver;
    }

    public String getSurat_bebas_napza() {
        return surat_bebas_napza;
    }

    public void setSurat_bebas_napza(String surat_bebas_napza) {
        this.surat_bebas_napza = surat_bebas_napza;
    }

    public String getSurat_jiwa_jasmani() {
        return surat_jiwa_jasmani;
    }

    public void setSurat_jiwa_jasmani(String surat_jiwa_jasmani) {
        this.surat_jiwa_jasmani = surat_jiwa_jasmani;
    }

    public String getSkck_driver() {
        return skck_driver;
    }

    public void setSkck_driver(String skck_driver) {
        this.skck_driver = skck_driver;
    }
}

