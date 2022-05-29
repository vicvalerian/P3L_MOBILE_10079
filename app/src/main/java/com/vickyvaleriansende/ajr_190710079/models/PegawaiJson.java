package com.vickyvaleriansende.ajr_190710079.models;

public class PegawaiJson {

    private int id_pegawai;
    private int id_jabatan;
    private String nama_pegawai;
    private String alamat_pegawai;
    private String tgl_lahir_pegawai;
    private String jenis_kelamin_pegawai;
    private String email_pegawai;
    private String notelp_pegawai;
    private String foto_pegawai;
    private String password_pegawai;

    public PegawaiJson(int id_pegawai, int id_jabatan, String nama_pegawai, String alamat_pegawai, String tgl_lahir_pegawai, String jenis_kelamin_pegawai, String email_pegawai, String notelp_pegawai, String foto_pegawai, String password_pegawai) {
        this.id_pegawai = id_pegawai;
        this.id_jabatan = id_jabatan;
        this.nama_pegawai = nama_pegawai;
        this.alamat_pegawai = alamat_pegawai;
        this.tgl_lahir_pegawai = tgl_lahir_pegawai;
        this.jenis_kelamin_pegawai = jenis_kelamin_pegawai;
        this.email_pegawai = email_pegawai;
        this.notelp_pegawai = notelp_pegawai;
        this.foto_pegawai = foto_pegawai;
        this.password_pegawai = password_pegawai;
    }

    public String getJenis_kelamin_pegawai() {
        return jenis_kelamin_pegawai;
    }

    public void setJenis_kelamin_pegawai(String jenis_kelamin_pegawai) {
        this.jenis_kelamin_pegawai = jenis_kelamin_pegawai;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getAlamat_pegawai() {
        return alamat_pegawai;
    }

    public void setAlamat_pegawai(String alamat_pegawai) {
        this.alamat_pegawai = alamat_pegawai;
    }

    public String getTgl_lahir_pegawai() {
        return tgl_lahir_pegawai;
    }

    public void setTgl_lahir_pegawai(String tgl_lahir_pegawai) {
        this.tgl_lahir_pegawai = tgl_lahir_pegawai;
    }

    public String getEmail_pegawai() {
        return email_pegawai;
    }

    public void setEmail_pegawai(String email_pegawai) {
        this.email_pegawai = email_pegawai;
    }

    public String getNotelp_pegawai() {
        return notelp_pegawai;
    }

    public void setNotelp_pegawai(String notelp_pegawai) {
        this.notelp_pegawai = notelp_pegawai;
    }

    public String getFoto_pegawai() {
        return foto_pegawai;
    }

    public void setFoto_pegawai(String foto_pegawai) {
        this.foto_pegawai = foto_pegawai;
    }

    public String getPassword_pegawai() {
        return password_pegawai;
    }

    public void setPassword_pegawai(String password_pegawai) {
        this.password_pegawai = password_pegawai;
    }
}
