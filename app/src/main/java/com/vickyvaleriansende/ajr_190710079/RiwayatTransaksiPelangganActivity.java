package com.vickyvaleriansende.ajr_190710079;

import static com.android.volley.Request.Method.GET;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vickyvaleriansende.ajr_190710079.adapters.RiwayatTransaksiPelangganAdapter;
import com.vickyvaleriansende.ajr_190710079.api.PelangganApi;
import com.vickyvaleriansende.ajr_190710079.models.RiwayatTransaksiPelangganResponse;
import com.vickyvaleriansende.ajr_190710079.preferences.PelangganPreferences;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RiwayatTransaksiPelangganActivity extends AppCompatActivity {

    public static final int LAUNCH_ADD_ACTIVITY = 123;
    private SwipeRefreshLayout srRiwayat;
    private RiwayatTransaksiPelangganAdapter adapter;
    private SearchView svRiwayat;
    private LinearLayout layoutLoading;
    private RequestQueue queue;
    PelangganPreferences pelangganPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_transaksi_pelanggan);

        pelangganPref = new PelangganPreferences(this);
        // Pendeklarasian request queue
        queue = Volley.newRequestQueue(this);
        layoutLoading = findViewById(R.id.layout_loading);
        srRiwayat = findViewById(R.id.sr_riwayattransaksi);
        svRiwayat = findViewById(R.id.SearchRiwayatTransaksi);
        srRiwayat.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllRiwayat();
            }
        });
        svRiwayat.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        RecyclerView rvRiwayat = findViewById(R.id.rv_riwayattransaksi);
        adapter = new RiwayatTransaksiPelangganAdapter(new ArrayList<>(), this);
        rvRiwayat.setLayoutManager(new LinearLayoutManager(RiwayatTransaksiPelangganActivity.this,
                LinearLayoutManager.VERTICAL, false));
        rvRiwayat.setAdapter(adapter);
        getAllRiwayat();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_ADD_ACTIVITY && resultCode == Activity.RESULT_OK)
            getAllRiwayat();
    }

    private void getAllRiwayat() {
        srRiwayat.setRefreshing(true);
        StringRequest stringRequest = new StringRequest(GET,
                PelangganApi.GET_ALL_DETAIL_TRANSAKSI_PELANGGAN_URL+ pelangganPref.getIdPelanggan(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                RiwayatTransaksiPelangganResponse riwayatResponse = gson.fromJson(response, RiwayatTransaksiPelangganResponse.class);
                adapter.setRiwayatList(riwayatResponse.getRiwayatList());
                adapter.getFilter().filter(svRiwayat.getQuery());
                Toast.makeText(RiwayatTransaksiPelangganActivity.this, riwayatResponse.getMessage(), Toast.LENGTH_SHORT).show();
                srRiwayat.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                srRiwayat.setRefreshing(false);
                try {
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(RiwayatTransaksiPelangganActivity.this,
                            errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(RiwayatTransaksiPelangganActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
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

    // Fungsi untuk menampilkan layout loading
    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.GONE);
        }
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
                Intent moveShowProfil = new Intent(RiwayatTransaksiPelangganActivity.this, PelangganActivity.class );
                startActivity(moveShowProfil);
                return true;
            case R.id.menuPromo:
                Intent moveShowPromo = new Intent(RiwayatTransaksiPelangganActivity.this, PromoActivity.class );
                startActivity(moveShowPromo);
                return true;
            case R.id.menuMobil:
                Intent moveShowMobil = new Intent(RiwayatTransaksiPelangganActivity.this, MobilActivity.class );
                startActivity(moveShowMobil);
                return true;
            case R.id.menuRiwayatPelanggan:
                return true;
            case R.id.menuLogout:
                pelangganPref.Logout();

                Intent move = new Intent(this, LoginActivity.class);
                startActivity(move);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}