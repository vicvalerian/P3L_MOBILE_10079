package com.vickyvaleriansende.ajr_190710079;

import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vickyvaleriansende.ajr_190710079.api.DriverApi;
import com.vickyvaleriansende.ajr_190710079.databinding.ActivityDriverBinding;
import com.vickyvaleriansende.ajr_190710079.models.DriverJson;
import com.vickyvaleriansende.ajr_190710079.models.DriverResponse;
import com.vickyvaleriansende.ajr_190710079.preferences.DriverPreferences;

import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DriverActivity extends AppCompatActivity {

    private ActivityDriverBinding binding;
    private DriverPreferences driverPreferences;
    private static String[] JENIS_KELAMIN_LIST = new String[] {"Laki-Laki", "Perempuan"};
    private static String[] STATUS_LIST = new String[] {"Tersedia", "Tidak Tersedia"};
    private EditText edtId, edtNama, edtAlamat, edtTglLahir, edtNotelp, edtEmail, edtRating, edtSewa, edtBahasa, edtPassword;
    private AutoCompleteTextView edtJK, edtStatus;
    private RequestQueue queue;
    private Button btnUpdate;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_driver);

        driverPreferences = new DriverPreferences(this);
        queue = Volley.newRequestQueue(this);
        edtId = findViewById(R.id.edtIdDriver);
        edtNama = findViewById(R.id.edtNamaDriver);
        edtAlamat = findViewById(R.id.edtAlamatDriver);
        edtTglLahir = findViewById(R.id.edtTglLahirDriver);
        edtNotelp = findViewById(R.id.edtNotelpDriver);
        edtEmail = findViewById(R.id.edtEmailDriver);
        edtRating = findViewById(R.id.edtRatingDriver);
        edtSewa = findViewById(R.id.edtSewaDriver);
        edtJK = findViewById(R.id.edtJKDriver);
        edtStatus = findViewById(R.id.edtStatusDriver);
        edtBahasa = findViewById(R.id.edtBahasaDriver);
        edtPassword = findViewById(R.id.edtPasswordDriver);

        ArrayAdapter<String> adapterJenisKelamin = new ArrayAdapter<>(this, R.layout.item_list, JENIS_KELAMIN_LIST);
        edtJK.setAdapter(adapterJenisKelamin);
        ArrayAdapter<String> adapterStatusDriver = new ArrayAdapter<>(this, R.layout.item_list, STATUS_LIST);
        edtStatus.setAdapter(adapterStatusDriver);
        getDriverById();

        DatePickerDialog.OnDateSetListener dateTglLahir = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);

                String myFormat="yyyy-MM-dd";
                SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
                edtTglLahir.setText(dateFormat.format(myCalendar.getTime()));
            }
        };

        edtTglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(DriverActivity.this, dateTglLahir, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfilDriver();
            }
        });
    }

    private class GetImage extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public GetImage(ImageView imageView) {
            this.imageView=imageView;
//            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...",Toast.LENGTH_SHORT).show();
        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage= BitmapFactory.decodeStream(in);
            } catch (Exception e) {
//                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

    private void updateProfilDriver() {
        driverPreferences = new DriverPreferences(this);
        DriverJson driverJson = new DriverJson(
                edtNama.getText().toString(), edtAlamat.getText().toString(), edtTglLahir.getText().toString(), edtJK.getText().toString(), edtBahasa.getText().toString(),
                edtNotelp.getText().toString(), edtEmail.getText().toString(), edtStatus.getText().toString(), edtPassword.getText().toString());

        StringRequest stringRequest = new StringRequest(POST, DriverApi.UPDATE_DRIVER_URL + driverPreferences.getIdDriver(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                DriverResponse driverResponse = gson.fromJson(response, DriverResponse.class);
                Toast.makeText(DriverActivity.this, driverResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(DriverActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(DriverActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
            // Menambahkan request body berupa object driver
            @Override
            public byte[] getBody() throws AuthFailureError {
                Gson gson = new Gson();
                 /* Serialisasi data dari java object driverResponse
                 menjadi JSON string menggunakan Gson */
                String requestBody = gson.toJson(driverJson);
                return requestBody.getBytes(StandardCharsets.UTF_8);
            }
            // Mendeklarasikan content type dari request body yang ditambahkan
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add(stringRequest);
    }

    private void getDriverById() {
        driverPreferences = new DriverPreferences(this);
        StringRequest stringRequest = new StringRequest(GET,
                DriverApi.GET_BY_ID_URL+ driverPreferences.getIdDriver(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                DriverResponse driverResponse = gson.fromJson(response, DriverResponse.class);
                DriverJson driverJson = driverResponse.getDriver();
                edtId.setText(driverJson.getId_driver());
                edtNama.setText(driverJson.getNama_driver());
                edtAlamat.setText(driverJson.getAlamat_driver());
                edtTglLahir.setText(driverJson.getTgl_lahir_driver());
                edtNotelp.setText(driverJson.getNotelp_driver());
                edtEmail.setText(driverJson.getEmail_driver());
                edtBahasa.setText(driverJson.getBahasa_driver());
                edtSewa.setText(String.valueOf(driverJson.getSewa_harian_driver()));
                edtRating.setText(String.valueOf(driverJson.getRating_driver()));
                edtJK.setText(driverJson.getJenis_kelamin_driver(), false);
                edtStatus.setText(driverJson.getStatus_driver(), false);
                new GetImage((ImageView) findViewById(R.id.foto_driver)).execute(DriverApi.BASE_URL_GAMBAR + "storage/" + driverJson.getFoto_driver());
                Toast.makeText(DriverActivity.this, driverResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(DriverActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(DriverActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
        inflater.inflate(R.menu.menu_driver, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuProfilDriver:
                return true;
            case R.id.menuRiwayatDriver:
                Intent moveShowProfil = new Intent(DriverActivity.this, RiwayatTransaksiDriverActivity.class );
                startActivity(moveShowProfil);
                return true;
            case R.id.menuLogout:
                driverPreferences.Logout();

                Intent move = new Intent(this, LoginActivity.class);
                startActivity(move);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}