package com.baskom.masakini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baskom.masakini.R;

/**
 * Created by akmalmuhamad on 17/12/17.
 */

public class PembelianSelesaiActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmasi_selesai);

        Bundle harga = getIntent().getExtras();
        /*Intent intent = getIntent().*/

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konfirmasi Pembelian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvHargaTotal = findViewById(R.id.harga_selesai);
        Button btnRiwayatOrder = findViewById(R.id.btn_riwayatOrder_selesai);
        Button btnKembali = findViewById(R.id.btn_kembali_selesai);

        tvHargaTotal.setText("Rp "+ Integer.toString(harga.getInt("totalHarga")));

        btnRiwayatOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keRiwayat = new Intent(PembelianSelesaiActivity.this, RiwayatOrderActivity.class);
                startActivity(keRiwayat);
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keHome = new Intent(PembelianSelesaiActivity.this, MainDrawerActivity.class);
                startActivity(keHome);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
