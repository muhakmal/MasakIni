package com.baskom.masakini.view;

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

import com.baskom.masakini.R;
import com.baskom.masakini.model.Resep;
import com.bumptech.glide.Glide;

import java.util.Date;

/**
 * Created by akmalmuhamad on 22/11/17.
 */

public class TroliActivity extends AppCompatActivity {

    Resep resep;

    //fungsi tanggal
    private String formatTanggal(Date date) {
        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL);
        return dateFormat.format(date);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troli);

        resep = (Resep) getIntent().getSerializableExtra("objekResep");


        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Beli Bahan Masakan");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tanggalTroli = findViewById(R.id.tanggal_troli);
        TextView judulTroli = findViewById(R.id.judul_resep_troli);
        TextView hargaTroli = findViewById(R.id.harga_troli);
        LinearLayout textLinearLayoutTroli = findViewById(R.id.linear_text_troli);
        ImageView imageTroli = findViewById(R.id.image_troli);
        Button tongsampahTroli = findViewById(R.id.tongsampah_troli);
        TextView totalEstimasi = findViewById(R.id.total_estimasi);
        TextView biayaPengiriman = findViewById(R.id.biaya_pengiriman);
        Button btnBeli = findViewById(R.id.btn_beli_troli);


        for (int i = 0; i < resep.getBahan().size(); i++) {
            View view = getLayoutInflater().inflate(R.layout.text_bahan, textLinearLayoutTroli, false);

            TextView textViewNamaBahanTroli = view.findViewById(R.id.text_nama_bahan);
            TextView textViewTakaranTroli = view.findViewById(R.id.text_takaran_bahan);
            textViewNamaBahanTroli.setText(resep.getBahan().get(i).getNama());
            textViewTakaranTroli.setText(resep.getBahan().get(i).getTakaran());

            textLinearLayoutTroli.addView(view);
        }

        tanggalTroli.setText(formatTanggal(new Date()));
        judulTroli.setText("Bahan Masakan Untuk " + resep.getJudulResep());
        hargaTroli.setText("Harga Bahan Masakan : 100.000,-");
        Glide.with(imageTroli.getContext()).load(resep.getResepImage()).into(imageTroli);
        totalEstimasi.setText("100.000,-");


        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(TroliActivity.this);
                builder.setMessage("Bahan masakan berhasil dimasukkan ke Keranjang Belanja")
                        .setPositiveButton("Bayar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //menuju page pembayaran
                                Intent intentPembayaran = new Intent(TroliActivity.this, PengirimanActivity.class);
                                startActivity(intentPembayaran);
                            }
                        })
                        .setNegativeButton("Lanjutkan Berbelanja", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //tambah disini untuk nambahin sesuatu ke troli

                                finish();
                            }
                        })
                        .show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //do something before finish
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
