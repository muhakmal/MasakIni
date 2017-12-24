package com.baskom.masakini.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baskom.masakini.R;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView imageTroli = findViewById(R.id.image_troli);
        TextView tanggalTroli = findViewById(R.id.tanggal_troli);
        TextView judulTroli = findViewById(R.id.judul_resep_troli);
        TextView tv_hargaTroli = findViewById(R.id.harga_troli);

        LinearLayout textLinearLayoutTroli = findViewById(R.id.linear_text_troli);
        Button btnBeli = findViewById(R.id.btn_beli_troli);
        Button tongsampahTroli = findViewById(R.id.tongsampah_troli);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Beli Bahan Masakan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView tv_totalJumlahPaket = findViewById(R.id.total_jumlah_paket);
        final ElegantNumberButton btnNumberJumlahPaket = findViewById(R.id.btn_tambahJumlahPaket);
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
        judulTroli.setText("Bahan masakan untuk " + resep.getJudulResep());
        tv_hargaTroli.setText("Estimasi harga bahan masakan : " + hargaProduk + ",-");
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
                } else {

                }

                tv_totalEstimasi.setText("Rp." + Integer.toString(totalEstimasi));
                tv_totalJumlahPaket.setText(jumlahPaket + " Paket");
            }
        });


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
    public void onBackPressed() {
        finish();
    }
}
