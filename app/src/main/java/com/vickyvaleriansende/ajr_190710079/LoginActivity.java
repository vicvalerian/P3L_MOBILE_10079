package com.vickyvaleriansende.ajr_190710079;

import static com.android.volley.Request.Method.POST;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vickyvaleriansende.ajr_190710079.api.LoginApi;
import com.vickyvaleriansende.ajr_190710079.databinding.ActivityLoginBinding;
import com.vickyvaleriansende.ajr_190710079.models.DriverJson;
import com.vickyvaleriansende.ajr_190710079.models.DriverResponse;
import com.vickyvaleriansende.ajr_190710079.models.Login;
import com.vickyvaleriansende.ajr_190710079.models.PegawaiJson;
import com.vickyvaleriansende.ajr_190710079.models.PegawaiResponse;
import com.vickyvaleriansende.ajr_190710079.models.PelangganJson;
import com.vickyvaleriansende.ajr_190710079.models.PelangganResponse;
import com.vickyvaleriansende.ajr_190710079.preferences.DriverPreferences;
import com.vickyvaleriansende.ajr_190710079.preferences.PegawaiPreferences;
import com.vickyvaleriansende.ajr_190710079.preferences.PelangganPreferences;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityLoginBinding binding;
    private Login loginData;
    private RequestQueue queue;
    private PelangganPreferences pelangganpref;
    private DriverPreferences driverpref;
    private PegawaiPreferences pegawaipref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        queue = Volley.newRequestQueue(this.getApplicationContext());

        loginData = new Login("","");

        binding.setLogin(loginData);
        binding.btnLogin.setOnClickListener(this);

        pelangganpref = new PelangganPreferences(this);
        driverpref = new DriverPreferences(this);
        pegawaipref = new PegawaiPreferences(this);

        CheckLogin();
    }

    @Override
    public void onClick(View view){
        if(CekKosong()){
            String email = loginData.getEmail();
            String password = loginData.getPassword();

            Login(new Login(email, password));
        }
        else{
            Toast.makeText(this, "Email dan Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean CekKosong() {
        if(binding.edtUsername.getEditText().getText().toString().isEmpty()) {
            return false;
        }else if(binding.edtPassword.getEditText().getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }

    private void CheckLogin() {
        if(pelangganpref.CheckLogin()){
            Intent next = new Intent(this, PelangganActivity.class);
            startActivity(next);
            finish();
        }
        else if(driverpref.CheckLogin()){
            Intent next = new Intent(this, DriverActivity.class);
            startActivity(next);
            finish();
        }
        else if(pegawaipref.CheckLogin()){
            Intent next = new Intent(this, PegawaiActivity.class);
            startActivity(next);
            finish();
        }
    }

    private void Login(Login login) {
        setLoading(true);

        final StringRequest stringRequest = new StringRequest(POST, LoginApi.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        DriverResponse driverResponse = gson.fromJson(response, DriverResponse.class);
                        PelangganResponse pelangganResponse = gson.fromJson(response, PelangganResponse.class);
                        PegawaiResponse pegawaiResponse = gson.fromJson(response, PegawaiResponse.class);

                        DriverJson driver = driverResponse.getDriver();
                        PelangganJson pelanggan = pelangganResponse.getPelanggan();
                        PegawaiJson pegawai = pegawaiResponse.getPegawai();

                        setLoading(false);
//                        Log.d("ID DRIVER", String.valueOf(driver.getId_driver()));

                        if(pelanggan.getId_pelanggan() != null){
                            Toast.makeText(LoginActivity.this, pelangganResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent returnIntent = new Intent();
                            setResult(Activity.RESULT_OK, returnIntent);

                            PelangganJson pelangganPref = new PelangganJson(pelanggan.getId_pelanggan(), pelanggan.getNama_pelanggan(), pelanggan.getAlamat_pelanggan(), pelanggan.getTgl_lahir_pelanggan(),
                                    pelanggan.getJenis_kelamin_pelanggan(), pelanggan.getEmail_pelanggan(), pelanggan.getNotelp_pelanggan(), pelanggan.getNo_ktp_pelanggan(), pelanggan.getNo_sim_pelanggan(),
                                    pelanggan.getPassword_pelanggan(), pelanggan.getStatus_pelanggan());

                            LoginActivity.this.pelangganpref.SetLogin(pelangganPref);
                            CheckLogin();

                        }
                        else if(pegawai.getId_pegawai() != 0 && pegawai.getId_jabatan() == 1){
                            Toast.makeText(LoginActivity.this, pegawaiResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent returnIntent = new Intent();
                            setResult(Activity.RESULT_OK, returnIntent);

                            PegawaiJson pegawaiPref = new PegawaiJson(pegawai.getId_pegawai(), pegawai.getId_jabatan(), pegawai.getNama_pegawai(), pegawai.getAlamat_pegawai(), pegawai.getTgl_lahir_pegawai(),
                                    pegawai.getJenis_kelamin_pegawai(), pegawai.getEmail_pegawai(), pegawai.getNotelp_pegawai(), pegawai.getFoto_pegawai(), pegawai.getPassword_pegawai());

                            LoginActivity.this.pegawaipref.SetLogin(pegawaiPref);
                            CheckLogin();
                        }
                        else if(driver.getId_driver() != null){
                            Toast.makeText(LoginActivity.this, driverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent returnIntent = new Intent();
                            setResult(Activity.RESULT_OK, returnIntent);

                            DriverJson driverPref = new DriverJson(driver.getId_driver(), driver.getNama_driver(), driver.getAlamat_driver(), driver.getTgl_lahir_driver(),
                                    driver.getJenis_kelamin_driver(), driver.getBahasa_driver(), driver.getFoto_driver(), driver.getNotelp_driver(), driver.getEmail_driver(),
                                    driver.getSewa_harian_driver(), driver.getStatus_driver(), driver.getRating_driver(), driver.getPassword_driver(), driver.getSim_driver(),
                                    driver.getSurat_bebas_napza(), driver.getSurat_jiwa_jasmani(), driver.getSkck_driver());

                            LoginActivity.this.driverpref.SetLogin(driverPref);

                            CheckLogin();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        setLoading(false);

                        try {
                            String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            JSONObject errors = new JSONObject(responseBody);

                            Toast.makeText(LoginActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Accept", "application/json");

                        return headers;
                    }
                    @Override
                    public String getBodyContentType() {
                        return "application/json";
                    }
                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        Gson gson = new Gson();
                        String requestBody = gson.toJson(login);

                        return requestBody.getBytes(StandardCharsets.UTF_8);
                    }
                };
        queue.add(stringRequest);
    }

    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//            binding.layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//            binding.layoutLoading.setVisibility(View.GONE);
        }
    }
}