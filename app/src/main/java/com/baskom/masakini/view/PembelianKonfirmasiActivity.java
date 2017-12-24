package com.baskom.masakini.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.model.Resep;
import com.baskom.masakini.model.Transaksi;

/**
 * Created by akmalmuhamad on 15/12/17.
 */

public class PembelianKonfirmasiActivity extends AppCompatActivity {

    Transaksi transaksi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmasi_pengiriman);

        transaksi = (Transaksi) getIntent().getSerializableExtra("objekTroli");

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konfirmasi Pembelian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnSelanjutnya = findViewById(R.id.selanjutnya);
        RadioButton radioButtonCOD = findViewById(R.id.radio_button_COD);
        TextView btnUbah = findViewById(R.id.btn_ubah);
        TextView tvHargaBahan = findViewById(R.id.tv_harga_bahan_masakan);
        TextView tvBiayaPengiriman = findViewById(R.id.tv_biaya_pengiriman);
        TextView tvTotal = findViewById(R.id.tv_total_yang_harus_dibayar);


        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PembelianKonfirmasiActivity.this, PembelianSelesaiActivity.class);
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
