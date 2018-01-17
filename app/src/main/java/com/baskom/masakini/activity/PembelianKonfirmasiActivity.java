package com.baskom.masakini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.adapter.ItemKeranjangCardViewHolder;
import com.baskom.masakini.model.Transaksi;
import com.baskom.masakini.request.MasukRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by akmalmuhamad on 15/12/17.
 */

public class PembelianKonfirmasiActivity extends AppCompatActivity {
    private static final String PEMBELIAN_KONFIRMASI_REQUEST = "http://masakini.xyz/masakiniapi/Infoakun.php?email=";
    String email;

    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    Transaksi transaksi;

    ProgressBar progressBar;
    TextView tvNama;
    TextView tvAlamat;
    TextView tvnoHp;
    Button btnSelanjutnya;
    RadioButton radioButtonCOD;

    TextView btnUbah;
    TextView tvHargaBahan;
    TextView tvBiayaPengiriman;
    TextView tvTotal;
    int totalEstimasi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmasi_pengiriman);

        transaksi = (Transaksi) getIntent().getSerializableExtra("objekTroli");
        Intent intent = getIntent();
        totalEstimasi = intent.getIntExtra("total", 5);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konfirmasi Pembelian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progressBar_konfirmasi);
        tvNama = findViewById(R.id.tv_nama_lengkap_konfirmasi);
        tvAlamat = findViewById(R.id.tv_alamt_lengkap_konfirmasi);
        tvnoHp = findViewById(R.id.tv_no_hp_konfirmasi);
        btnSelanjutnya = findViewById(R.id.selanjutnya);
        radioButtonCOD = findViewById(R.id.radio_button_COD);

        btnUbah = findViewById(R.id.btn_ubah);
        tvHargaBahan = findViewById(R.id.tv_harga_bahan_masakan);
        tvBiayaPengiriman = findViewById(R.id.tv_biaya_pengiriman);
        tvTotal = findViewById(R.id.total_harga);
        tvHargaBahan.setText(formatRupiah.format(totalEstimasi));
        tvTotal.setText(formatRupiah.format(totalEstimasi + 20000));

        email = MasukRequest.getEmail();
        progressBar.setVisibility(View.VISIBLE);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    tvNama.setText(jsonResponse.getString("name"));
                    tvnoHp.setText(jsonResponse.getString("noHP"));
                    tvAlamat.setText(jsonResponse.getString("alamat"));
                    progressBar.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvNama.setText("Gagal mengambil dari database");
                tvAlamat.setText("Gagal mengambil dari database");
                tvnoHp.setText("Gagal mengambil dari database");
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, PEMBELIAN_KONFIRMASI_REQUEST + email,
                responseListener, responseErrorListener);
        queue.add(request);

        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PembelianKonfirmasiActivity.this, PembelianSelesaiActivity.class);
                intent.putExtra("totalHarga", totalEstimasi+20000);
                startActivity(intent);
                finish();
            }
        });

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PembelianKonfirmasiActivity.this, InfoAkunActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
