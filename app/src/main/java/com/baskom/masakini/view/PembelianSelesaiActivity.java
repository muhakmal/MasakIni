package com.baskom.masakini.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.baskom.masakini.R;

/**
 * Created by akmalmuhamad on 17/12/17.
 */

public class PembelianSelesaiActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmasi_selesai);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konfirmasi Pembelian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnRiwayatOrder = findViewById(R.id.btn_riwayatOrder_selesai);
        Button btnKembali = findViewById(R.id.btn_kembali_selesai);

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
                Intent keHome = new Intent(PembelianSelesaiActivity.this, MainActivity.class);
                startActivity(keHome);
            }
        });
    }
}
