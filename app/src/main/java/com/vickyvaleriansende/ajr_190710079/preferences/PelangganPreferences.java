package com.vickyvaleriansende.ajr_190710079.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.vickyvaleriansende.ajr_190710079.models.Login;
import com.vickyvaleriansende.ajr_190710079.models.PelangganJson;

public class PelangganPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context con;

    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_ID_PELANGGAN = "id_pelanggan";
    public static final String KEY_NAMA_PELANGGAN = "nama_pelanggan";
    public static final String KEY_ALAMAT_PELANGGAN = "alamat_pelanggan";
    public static final String KEY_TGL_LAHIR_PELANGGAN =  "tgl_lahir_pelanggan";
    public static final String KEY_JENIS_KELAMIN_PELANGGAN = "jenis_kelamin_pelanggan";
    public static final String KEY_EMAIL = "email_pelanggan";
    public static final String KEY_NOTELP_PELANGGAN = "notelp_pelanggan";
    public static final String KEY_NO_KTP_PELANGGAN = "no_ktp_pelanggan";
    public static final String KEY_NO_SIM_PELANGGAN = "no_sim_pelanggan";
    public static final String KEY_PASSWORD = "password_pelanggan" ;
    public static final String KEY_STATUS_PELANGGAN = "status_pelanggan";

    public PelangganPreferences(Context C){
        con = C;
        sharedPreferences = C.getSharedPreferences("PelangganPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void SetLogin(PelangganJson pelanggan){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_ID_PELANGGAN, pelanggan.getId_pelanggan());
        editor.putString(KEY_NAMA_PELANGGAN, pelanggan.getNama_pelanggan());
        editor.putString(KEY_ALAMAT_PELANGGAN, pelanggan.getAlamat_pelanggan());
        editor.putString(KEY_TGL_LAHIR_PELANGGAN, pelanggan.getTgl_lahir_pelanggan());
        editor.putString(KEY_JENIS_KELAMIN_PELANGGAN, pelanggan.getJenis_kelamin_pelanggan());
        editor.putString(KEY_EMAIL, pelanggan.getEmail_pelanggan());
        editor.putString(KEY_NOTELP_PELANGGAN, pelanggan.getNotelp_pelanggan());
        editor.putString(KEY_NO_KTP_PELANGGAN, pelanggan.getNo_ktp_pelanggan());
        editor.putString(KEY_NO_SIM_PELANGGAN, pelanggan.getNo_sim_pelanggan());
        editor.putString(KEY_PASSWORD, pelanggan.getPassword_pelanggan());
        editor.putString(KEY_STATUS_PELANGGAN, pelanggan.getStatus_pelanggan());

        editor.commit();
    }

    public Login GetLogin(){
        String email, password;

        email = sharedPreferences.getString(KEY_EMAIL, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);
        return new Login(email, password);
    }

    public PelangganJson GetPelangganNow(){

        String id_pelanggan;
        String nama_pelanggan;
        String alamat_pelanggan;
        String tgl_lahir_pelanggan;
        String jenis_kelamin_pelanggan;
        String email;
        String notelp_pelanggan;
        String no_ktp_pelanggan;
        String no_sim_pelanggan;
        String password;
        String status_pelanggan;

        id_pelanggan = sharedPreferences.getString(KEY_ID_PELANGGAN, null);
        nama_pelanggan = sharedPreferences.getString(KEY_NAMA_PELANGGAN, null);
        alamat_pelanggan = sharedPreferences.getString(KEY_ALAMAT_PELANGGAN, null);
        tgl_lahir_pelanggan = sharedPreferences.getString(KEY_TGL_LAHIR_PELANGGAN, null);
        jenis_kelamin_pelanggan = sharedPreferences.getString(KEY_JENIS_KELAMIN_PELANGGAN, null);
        email = sharedPreferences.getString(KEY_EMAIL, null);
        notelp_pelanggan = sharedPreferences.getString(KEY_NOTELP_PELANGGAN, null);
        no_ktp_pelanggan = sharedPreferences.getString(KEY_NO_KTP_PELANGGAN, null);
        no_sim_pelanggan = sharedPreferences.getString(KEY_NO_SIM_PELANGGAN, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);
        status_pelanggan = sharedPreferences.getString(KEY_STATUS_PELANGGAN, null);

        return new PelangganJson(id_pelanggan, nama_pelanggan, alamat_pelanggan, tgl_lahir_pelanggan, jenis_kelamin_pelanggan, email, notelp_pelanggan, no_ktp_pelanggan, no_sim_pelanggan, password, status_pelanggan);
    }

    public boolean CheckLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public String getIdPelanggan(){
        return sharedPreferences.getString(KEY_ID_PELANGGAN, null);
    }

    public void Logout(){
        editor.clear();
        editor.commit();
    }
}
