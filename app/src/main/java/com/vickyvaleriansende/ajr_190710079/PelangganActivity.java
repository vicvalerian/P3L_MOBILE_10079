package com.vickyvaleriansende.ajr_190710079;

import static com.android.volley.Request.Method.GET;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vickyvaleriansende.ajr_190710079.api.PelangganApi;
import com.vickyvaleriansende.ajr_190710079.databinding.ActivityPelangganBinding;
import com.vickyvaleriansende.ajr_190710079.models.PelangganJson;
import com.vickyvaleriansende.ajr_190710079.models.PelangganResponse;
import com.vickyvaleriansende.ajr_190710079.models.PromoResponse;
import com.vickyvaleriansende.ajr_190710079.preferences.PelangganPreferences;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class PelangganActivity extends AppCompatActivity {

    private ActivityPelangganBinding binding;
    private PelangganPreferences pelangganPreferences;
    private static String[] JENIS_KELAMIN_LIST = new String[] {"Laki-Laki", "Perempuan"};
    private EditText edtiId, edtNama, edtAlamat, edtTglLahir, edtNotelp, edtEmail, edtKtp, edtSim;
    private AutoCompleteTextView edtJK;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pelanggan);

//        binding.btnLogOut.setOnClickListener(this);

        pelangganPreferences = new PelangganPreferences(this);
        queue = Volley.newRequestQueue(this);
        edtiId = findViewById(R.id.edtIdPelanggan);
        edtNama = findViewById(R.id.edtNamaPelanggan);
        edtAlamat = findViewById(R.id.edtAlamatPelanggan);
        edtTglLahir = findViewById(R.id.edtTglLahirPelanggan);
        edtNotelp = findViewById(R.id.edtNotelpPelanggan);
        edtEmail = findViewById(R.id.edtEmailPelanggan);
        edtKtp = findViewById(R.id.edtNoKTPPelanggan);
        edtSim = findViewById(R.id.edtNoSIMPelanggan);
        edtJK = findViewById(R.id.edtJKPelanggan);

        ArrayAdapter<String> adapterJenisKelamin = new ArrayAdapter<>(this, R.layout.item_list, JENIS_KELAMIN_LIST);
        edtJK.setAdapter(adapterJenisKelamin);
        getCustomerById();

//        binding.edtNamaPelanggan.getEditText().setText(pelangganPreferences.GetPelangganNow().getNama_pelanggan(), TextView.BufferType.EDITABLE);
    }

    private void getCustomerById() {
        pelangganPreferences = new PelangganPreferences(this);
        StringRequest stringRequest = new StringRequest(GET,
                PelangganApi.GET_BY_ID_URL+ pelangganPreferences.getIdPelanggan(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                PelangganResponse pelangganResponse = gson.fromJson(response, PelangganResponse.class);
                PelangganJson pelangganJson = pelangganResponse.getPelanggan();
                edtiId.setText(pelangganJson.getId_pelanggan());
                edtNama.setText(pelangganJson.getNama_pelanggan());
                edtAlamat.setText(pelangganJson.getAlamat_pelanggan());
                edtTglLahir.setText(pelangganJson.getTgl_lahir_pelanggan());
                edtNotelp.setText(pelangganJson.getNotelp_pelanggan());
                edtEmail.setText(pelangganJson.getEmail_pelanggan());
                edtKtp.setText(pelangganJson.getNo_ktp_pelanggan());
                edtSim.setText(pelangganJson.getNo_sim_pelanggan());
                edtJK.setText(pelangganJson.getJenis_kelamin_pelanggan(), false);
                Toast.makeText(PelangganActivity.this, pelangganResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(PelangganActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(PelangganActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        // Menambahkan request ke request queue
        queue.add(stringRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pelanggan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuProfilPelanggan:
                return true;
            case R.id.menuPromo:
                Intent moveShowPromo = new Intent(PelangganActivity.this, PromoActivity.class );
                startActivity(moveShowPromo);
                return true;
            case R.id.menuMobil:
                Intent moveShowMobil = new Intent(PelangganActivity.this, MobilActivity.class);
                startActivity(moveShowMobil);
                return true;
            case R.id.menuRiwayatPelanggan:
                Intent moveShowRiwayat = new Intent(PelangganActivity.this, RiwayatTransaksiPelangganActivity.class);
                startActivity(moveShowRiwayat);
                return true;
            case R.id.menuLogout:
                pelangganPreferences.Logout();

                Intent move = new Intent(this, LoginActivity.class);
                startActivity(move);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}