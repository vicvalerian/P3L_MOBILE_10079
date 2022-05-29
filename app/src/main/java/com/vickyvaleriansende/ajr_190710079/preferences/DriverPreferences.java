package com.vickyvaleriansende.ajr_190710079.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.vickyvaleriansende.ajr_190710079.models.DriverJson;
import com.vickyvaleriansende.ajr_190710079.models.Login;

public class DriverPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context con;

    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_ID_DRIVER = "id_driver";
    public static final String KEY_NAMA_DRIVER = "nama_driver";
    public static final String KEY_ALAMAT_DRIVER = "alamat_driver";
    public static final String KEY_TGL_LAHIR_DRIVER = "tgl_lahir_driver";
    public static final String KEY_JENIS_KELAMIN_DRIVER = "jenis_kelamin_driver";
    public static final String KEY_BAHASA_DRIVER = "bahasa_driver";
    public static final String KEY_FOTO_DRIVER = "foto_driver";
    public static final String KEY_NOTELP_DRIVER = "notelp_driver";
    public static final String KEY_EMAIL = "email_driver";
    public static final String KEY_SEWA_HARIAN_DRIVER = "sewa_harian_driver";
    public static final String KEY_STATUS_DRIVER = "status_driver";
    public static final String KEY_RATING_DRIVER = "rating_driver";
    public static final String KEY_PASSWORD = "password_driver";
    public static final String KEY_SIM_DRIVER = "sim_driver";
    public static final String KEY_SURAT_BEBAS_NAPZA = "surat_bebas_napza";
    public static final String KEY_SURAT_JIWA_JASMANI = "surat_jiwa_jasmani";
    public static final String KEY_SKCK_DRIVER = "skck_driver";

    public DriverPreferences(Context C){
        con = C;
        sharedPreferences = C.getSharedPreferences("DriverPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void SetLogin(DriverJson driver){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_ID_DRIVER, driver.getId_driver());
        editor.putString(KEY_NAMA_DRIVER, driver.getNama_driver());
        editor.putString(KEY_ALAMAT_DRIVER, driver.getAlamat_driver());
        editor.putString(KEY_TGL_LAHIR_DRIVER, driver.getTgl_lahir_driver());
        editor.putString(KEY_JENIS_KELAMIN_DRIVER, driver.getJenis_kelamin_driver());
        editor.putString(KEY_BAHASA_DRIVER, driver.getBahasa_driver());
        editor.putString(KEY_FOTO_DRIVER, driver.getFoto_driver());
        editor.putString(KEY_NOTELP_DRIVER, driver.getNotelp_driver());
        editor.putString(KEY_EMAIL, driver.getEmail_driver());
        editor.putFloat(KEY_SEWA_HARIAN_DRIVER, driver.getSewa_harian_driver());
        editor.putString(KEY_STATUS_DRIVER, driver.getStatus_driver());
        editor.putFloat(KEY_RATING_DRIVER, driver.getRating_driver());
        editor.putString(KEY_PASSWORD, driver.getPassword_driver());
        editor.putString(KEY_SIM_DRIVER, driver.getSim_driver());
        editor.putString(KEY_SURAT_BEBAS_NAPZA, driver.getSurat_bebas_napza());
        editor.putString(KEY_SURAT_JIWA_JASMANI, driver.getSurat_jiwa_jasmani());
        editor.putString(KEY_SKCK_DRIVER, driver.getSkck_driver());

        editor.commit();
    }

    public Login GetLogin(){
        String email, password;

        email = sharedPreferences.getString(KEY_EMAIL, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);
        return new Login(email,password);
    }

    public DriverJson GetDriverNow(){

        String id_driver;
        String nama_driver;
        String alamat_driver;
        String tgl_lahir_driver;
        String jenis_kelamin_driver;
        String bahasa_driver;
        String foto_driver;
        String notelp_driver;
        String email;
        float sewa_harian_driver;
        String status_driver;
        float rating_driver;
        String password;
        String sim_driver;
        String surat_bebas_napza;
        String surat_jiwa_jasmani;
        String skck_driver;

        id_driver = sharedPreferences.getString(KEY_ID_DRIVER, null);
        nama_driver = sharedPreferences.getString(KEY_NAMA_DRIVER, null);
        alamat_driver = sharedPreferences.getString(KEY_ALAMAT_DRIVER, null);
        tgl_lahir_driver = sharedPreferences.getString(KEY_TGL_LAHIR_DRIVER, null);
        jenis_kelamin_driver = sharedPreferences.getString(KEY_JENIS_KELAMIN_DRIVER, null);
        bahasa_driver = sharedPreferences.getString(KEY_BAHASA_DRIVER, null);
        foto_driver = sharedPreferences.getString(KEY_FOTO_DRIVER, null);
        notelp_driver = sharedPreferences.getString(KEY_NOTELP_DRIVER, null);
        email = sharedPreferences.getString(KEY_EMAIL, null);
        sewa_harian_driver = sharedPreferences.getFloat(KEY_SEWA_HARIAN_DRIVER, 0);
        status_driver = sharedPreferences.getString(KEY_STATUS_DRIVER, null);
        rating_driver = sharedPreferences.getFloat(KEY_RATING_DRIVER, 0);
        password = sharedPreferences.getString(KEY_PASSWORD, null);
        sim_driver = sharedPreferences.getString(KEY_SIM_DRIVER, null);
        surat_bebas_napza = sharedPreferences.getString(KEY_SURAT_BEBAS_NAPZA, null);
        surat_jiwa_jasmani = sharedPreferences.getString(KEY_SURAT_JIWA_JASMANI, null);
        skck_driver = sharedPreferences.getString(KEY_SKCK_DRIVER, null);

        return new DriverJson(id_driver, nama_driver, alamat_driver, tgl_lahir_driver, jenis_kelamin_driver,
                bahasa_driver, foto_driver, notelp_driver, email, sewa_harian_driver, status_driver, rating_driver,
                password, sim_driver, surat_bebas_napza, surat_jiwa_jasmani, skck_driver);
    }

    public boolean CheckLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public String getIdDriver(){
        return sharedPreferences.getString(KEY_ID_DRIVER, null);
    }

    public void Logout(){
        editor.clear();
        editor.commit();
    }
}
