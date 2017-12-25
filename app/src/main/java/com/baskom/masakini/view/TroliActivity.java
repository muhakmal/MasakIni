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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.model.LoginRequest;
import com.baskom.masakini.model.Resep;
import com.baskom.masakini.model.Transaksi;
import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.Date;

/**
 * Created by akmalmuhamad on 22/11/17.
 */

public class TroliActivity extends AppCompatActivity {

    Resep resep;
    Transaksi transaksi;

    int hargaProduk;
    int totalEstimasi;
    int jumlahPaket = 1;
    int totalTakaran;

    Response.Listener<String> listener;
    Response.ErrorListener errorListener;
    TambahItemRequest request;
    RequestQueue queue;

    //fungsi tanggal
    private String formatTanggal(Date date) {
        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL);
        return dateFormat.format(date);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troli);

        resep = (Resep) getIntent().getSerializableExtra("objekResep");
        hargaProduk = 0;
        totalEstimasi = 0;

        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView imageTroli = findViewById(R.id.image_item_keranjang);
        TextView tanggalTroli = findViewById(R.id.tanggal_item_keranjang);
        TextView judulTroli = findViewById(R.id.judul_resep_item_keranjang);
        TextView tv_hargaTroli = findViewById(R.id.harga_item_keranjang);

        LinearLayout textLinearLayoutTroli = findViewById(R.id.linear_text_item_keranjang);
        Button btnBeli = findViewById(R.id.btn_bayar_keranjang);
        Button tongsampahTroli = findViewById(R.id.tongsampah_item_keranjang);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Beli Bahan Masakan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView tv_totalJumlahPaket = findViewById(R.id.total_jumlah_paket);
        final ElegantNumberButton btnNumberJumlahPaket = findViewById(R.id.btn_tambahJumlahPaket_item_keranjang);
        final TextView tv_totalEstimasi = findViewById(R.id.total_estimasi);

        //nampilin produk dan resep
        for (int i = 0; i < resep.getProduk().size(); i++) {
            View view = getLayoutInflater().inflate(R.layout.text_bahan, textLinearLayoutTroli, false);
            TextView textViewNamaBahanTroli = view.findViewById(R.id.text_nama_bahan);
            TextView textViewTakaranTroli = view.findViewById(R.id.text_takaran_bahan);

            textViewNamaBahanTroli.setText(resep.getProduk().get(i).getNama());
            textViewTakaranTroli.setText(resep.getProduk().get(i).getTakaran());

            hargaProduk += resep.getProduk().get(i).getHarga();
            textLinearLayoutTroli.addView(view);
        }

        tanggalTroli.setText(formatTanggal(new Date()));
        Glide.with(imageTroli.getContext()).load(resep.getResepImage()).into(imageTroli);
        judulTroli.setText("Bahan masakan " + resep.getJudulResep());
        tv_hargaTroli.setText("Harga Bahan " + hargaProduk);
        tv_totalEstimasi.setText("Rp." + Integer.toString(hargaProduk));
        btnNumberJumlahPaket.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahPaket = Integer.parseInt(btnNumberJumlahPaket.getNumber());

                if (jumlahPaket == 2) {
                    totalEstimasi = hargaProduk * 2;
                    //masih bingung misahin jumlah takaran dan metrik takaran(gram/kg/dll)
                    /*for (int i=0;i<resep.getProduk().size();i++){
                        TextView textViewJumlahTakaranChanged = view.findViewById(R.id.text_takaran_bahan);
                        StringTokenizer tokens = new StringTokenizer(resep.getProduk().get(i).getTakaran()," ");
                        //ngambil angka takaran aja
                        String angkaTakaran = tokens.nextToken();
                        String namaTakaran = tokens.nextToken();
                        totalTakaran = Integer.parseInt(angkaTakaran.toString())*2;
                        textViewJumlahTakaranChanged.setText(resep.getProduk().get(i).getTakaran());
                    }*/
                } else if (jumlahPaket == 1) {
                    totalEstimasi = hargaProduk;
                } else if (jumlahPaket == 3) {
                    totalEstimasi = hargaProduk * 3;
                }

                tv_totalEstimasi.setText("Rp." + Integer.toString(totalEstimasi));
                tv_totalJumlahPaket.setText(jumlahPaket + " Paket");
            }
        });
        totalEstimasi = hargaProduk;

        //Volley Stuff
        listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(TroliActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TroliActivity.this, error.toString(), Toast.LENGTH_LONG);
            }
        };

        request = new TambahItemRequest(LoginRequest.getEmail(), resep.getJudulResep(), jumlahPaket, listener, errorListener);
        queue = Volley.newRequestQueue(this);

        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TroliActivity.this);
                builder.setMessage("Bahan masakan berhasil dimasukkan ke Keranjang Belanja")
                        .setPositiveButton("Bayar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //menuju page pembayaran
                                Intent intentPembayaran = new Intent(TroliActivity.this, PembelianKonfirmasiActivity.class);
                                intentPembayaran.putExtra("objekTroli", transaksi);
                                intentPembayaran.putExtra("totalEstimasi", totalEstimasi);
                                startActivity(intentPembayaran);
                            }
                        })
                        .setNegativeButton("Lanjutkan Berbelanja", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //tambah disini untuk nambahin sesuatu ke troli
                                queue.add(request);
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
            //do something before finish
            finish();
            /*Intent back = new Intent(InfoAkunActivity.this, MainActivity.class);
            startActivity(back);*/
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
