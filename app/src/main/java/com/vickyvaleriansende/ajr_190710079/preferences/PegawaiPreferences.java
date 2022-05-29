package com.vickyvaleriansende.ajr_190710079.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.vickyvaleriansende.ajr_190710079.models.Login;
import com.vickyvaleriansende.ajr_190710079.models.PegawaiJson;

public class PegawaiPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context con;

    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_ID_PEGAWAI = "id_pegawai";
    public static final String KEY_ID_JABATAN = "id_jabatan";
    public static final String KEY_NAMA_PEGAWAI = "nama_pegawai";
    public static final String KEY_ALAMAT_PEGAWAI =  "alamat_pegawai";
    public static final String KEY_TGL_LAHIR_PEGAWAI = "tgl_lahir_pegawai";
    public static final String KEY_JENIS_KELAMIN_PEGAWAI = "jenis_kelamin_pegawai";
    public static final String KEY_EMAIL = "email_pegawai";
    public static final String KEY_NOTELP_PEGAWAI = "notelp_pegawai";
    public static final String KEY_FOTO_PEGAWAI = "foto_pegawai";
    public static final String KEY_PASSWORD = "password_pegawai" ;

    public PegawaiPreferences(Context C){
        con = C;
        sharedPreferences = C.getSharedPreferences("PegawaiPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void SetLogin(PegawaiJson pegawai){
        editor.putBoolean(IS_LOGIN, true);
        editor.putInt(KEY_ID_PEGAWAI, pegawai.getId_pegawai());
        editor.putInt(KEY_ID_JABATAN, pegawai.getId_jabatan());
        editor.putString(KEY_NAMA_PEGAWAI, pegawai.getNama_pegawai());
        editor.putString(KEY_ALAMAT_PEGAWAI, pegawai.getAlamat_pegawai());
        editor.putString(KEY_TGL_LAHIR_PEGAWAI, pegawai.getTgl_lahir_pegawai());
        editor.putString(KEY_JENIS_KELAMIN_PEGAWAI, pegawai.getJenis_kelamin_pegawai());
        editor.putString(KEY_EMAIL, pegawai.getEmail_pegawai());
        editor.putString(KEY_NOTELP_PEGAWAI, pegawai.getNotelp_pegawai());
        editor.putString(KEY_FOTO_PEGAWAI, pegawai.getFoto_pegawai());
        editor.putString(KEY_PASSWORD, pegawai.getPassword_pegawai());

        editor.commit();
    }

    public Login GetLogin(){
        String email, password;

        email = sharedPreferences.getString(KEY_EMAIL, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);
        return new Login(email, password);
    }

    public PegawaiJson GetPegawaiNow(){

        int id_pegawai;
        int id_jabatan;
        String nama_pegawai;
        String alamat_pegawai;
        String tgl_lahir_pegawai;
        String jenis_kelamin_pegawai;
        String email;
        String notelp_pegawai;
        String foto_pegawai;
        String password;

        id_pegawai = sharedPreferences.getInt(KEY_ID_PEGAWAI, -1);
        id_jabatan = sharedPreferences.getInt(KEY_ID_PEGAWAI, -1);
        nama_pegawai = sharedPreferences.getString(KEY_NAMA_PEGAWAI, null);
        alamat_pegawai = sharedPreferences.getString(KEY_ALAMAT_PEGAWAI, null);
        tgl_lahir_pegawai = sharedPreferences.getString(KEY_TGL_LAHIR_PEGAWAI, null);
        jenis_kelamin_pegawai = sharedPreferences.getString(KEY_JENIS_KELAMIN_PEGAWAI, null);
        email = sharedPreferences.getString(KEY_EMAIL, null);
        notelp_pegawai = sharedPreferences.getString(KEY_NOTELP_PEGAWAI, null);
        foto_pegawai = sharedPreferences.getString(KEY_FOTO_PEGAWAI, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);

        return new PegawaiJson(id_pegawai, id_jabatan, nama_pegawai, alamat_pegawai, tgl_lahir_pegawai, jenis_kelamin_pegawai, email, notelp_pegawai, foto_pegawai, password);
    }

    public boolean CheckLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void Logout(){
        editor.clear();
        editor.commit();
    }
}
