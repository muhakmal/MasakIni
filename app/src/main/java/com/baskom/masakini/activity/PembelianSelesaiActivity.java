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
import com.baskom.masakini.model.ItemTransaksi;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by akmalmuhamad on 17/12/17.
 */

public class PembelianSelesaiActivity extends AppCompatActivity{
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    android.support.v7.widget.Toolbar toolbar;

    ItemTransaksi transaksi;

    TextView nomorPesanan;
    TextView tvHargaTotal;
    Button btnRiwayatOrder;
    Button btnKembali;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmasi_selesai);

        transaksi = (ItemTransaksi) getIntent().getSerializableExtra("objekTroli");

        Bundle harga = getIntent().getExtras();
        /*Intent intentTotalEstimasi = getIntent().*/

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konfirmasi Pembelian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nomorPesanan = findViewById(R.id.tv_nomor_pesanan);
        tvHargaTotal = findViewById(R.id.harga_selesai);
        btnRiwayatOrder = findViewById(R.id.btn_riwayatOrder_selesai);
        btnKembali = findViewById(R.id.btn_kembali_selesai);

        tvHargaTotal.setText(formatRupiah.format(harga.getInt("totalHarga")));

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
