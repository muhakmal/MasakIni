package com.baskom.masakini.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.request.MasukRequest;
import com.baskom.masakini.model.Resep;
import com.baskom.masakini.model.Transaksi;
import com.baskom.masakini.request.TambahItemRequest;
import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by akmalmuhamad on 22/11/17.
 */

public class TroliActivity extends AppCompatActivity {

    List<Transaksi> transaksiList = new ArrayList<>();
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    Resep resep;
    Transaksi transaksi;
    Response.Listener<String> listenerLanjutBelanja, listenerKeranjang;
    Response.ErrorListener errorListenerLanjutBelanja, errorListenerKeranjang;
    ImageView imageTroli;
    Toolbar toolbar;
    LinearLayout textLinearLayoutTroli;
    Button btnBeli;
    TextView tvTotalEstimasi;
    TextView tvJudulTroli;
    TextView tvHargaProduk;
    RequestQueue queue;
    TambahItemRequest requestLanjutBelanja, requestKeranjang;
    int totalEstimasi;
    int hargaProduk;
    int jumlahPaket = 1;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troli);

        resep = (Resep) getIntent().getSerializableExtra("objekResep");
        toolbar = findViewById(R.id.toolbar);
        imageTroli = findViewById(R.id.image_troli);
        tvJudulTroli = findViewById(R.id.tv_judul_resep_troli);
        tvHargaProduk = findViewById(R.id.tv_harga_produk_troli);
        tvTotalEstimasi = findViewById(R.id.tv_total_estimasi_troli);
        textLinearLayoutTroli = findViewById(R.id.linear_text_troli);
        btnBeli = findViewById(R.id.btn_bayar_troli);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Beli Bahan Masakan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < resep.getProduk().size(); i++) {
            View view = getLayoutInflater().inflate(R.layout.text_bahan, textLinearLayoutTroli, false);
            TextView textViewNamaBahanTroli = view.findViewById(R.id.text_nama_bahan);
            TextView textViewTakaranTroli = view.findViewById(R.id.text_takaran_bahan);

            textViewNamaBahanTroli.setText(resep.getProduk().get(i).getNama());
            textViewTakaranTroli.setText(resep.getProduk().get(i).getTakaran());

            hargaProduk += resep.getProduk().get(i).getHarga();
            textLinearLayoutTroli.addView(view);
        }
        totalEstimasi = hargaProduk;
        Glide.with(imageTroli.getContext()).load(resep.getResepImage()).into(imageTroli);
        tvJudulTroli.setText("Bahan masakan " + resep.getJudulResep());
        tvHargaProduk.setText(formatRupiah.format(hargaProduk));
        tvTotalEstimasi.setText(formatRupiah.format(totalEstimasi));

        requestKeranjang = new TambahItemRequest(MasukRequest.getEmail(),resep.getJudulResep(), jumlahPaket, listenerKeranjang, errorListenerKeranjang);
        requestLanjutBelanja = new TambahItemRequest(MasukRequest.getEmail(), resep.getJudulResep(), jumlahPaket, listenerLanjutBelanja, errorListenerLanjutBelanja);

        //Volley Stuff
        listenerLanjutBelanja = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(TroliActivity.this, MainDrawerActivity.class);
                intent.putExtra("objekTroli", transaksi);
                intent.putExtra("totalEstimasi", totalEstimasi);
                startActivity(intent);
            }
        };

        listenerKeranjang = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intentItemKeranjang = new Intent(TroliActivity.this, ItemKeranjangActivity.class);
                intentItemKeranjang.putExtra("objekTroli", transaksi);
                intentItemKeranjang.putExtra("totalEstimasi", totalEstimasi);
                startActivity(intentItemKeranjang);
            }
        };

        errorListenerLanjutBelanja = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TroliActivity.this, error.toString(), Toast.LENGTH_LONG);
            }
        };
        errorListenerKeranjang = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TroliActivity.this, error.toString(), Toast.LENGTH_LONG);
            }
        };

        requestKeranjang = new TambahItemRequest(MasukRequest.getEmail(),resep.getJudulResep(), jumlahPaket, listenerKeranjang, errorListenerKeranjang);
        requestLanjutBelanja = new TambahItemRequest(MasukRequest.getEmail(), resep.getJudulResep(), jumlahPaket, listenerLanjutBelanja, errorListenerLanjutBelanja);
        queue = Volley.newRequestQueue(this);

        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TroliActivity.this);
                builder.setMessage("Bahan masakan berhasil dimasukkan ke Keranjang Belanja")
                        .setPositiveButton("Keranjang", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                queue.add(requestKeranjang);
                                Toast.makeText(TroliActivity.this,"Bahan masakan berhasil ditambahkan ke Keranjang",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Beranda", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                queue.add(requestLanjutBelanja);
                                Toast.makeText(TroliActivity.this,"Bahan masakan berhasil ditambahkan ke Keranjang",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
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
        Intent intent = new Intent(this, MainDrawerActivity.class);
        startActivity(intent);
    }
}
