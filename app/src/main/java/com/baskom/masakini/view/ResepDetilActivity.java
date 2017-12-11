package com.baskom.masakini.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.model.Resep;

/**
 * Created by akmalmuhamad on 04/12/17.
 */

public class ResepDetilActivity extends AppCompatActivity{

    Resep resep;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_resep_detil);

        resep = (Resep) getIntent().getSerializableExtra("objekResep");

        TextView textViewJudul = findViewById(R.id.judul_resep_detil);
        TextView textViewSubjudul = findViewById(R.id.deskripsi_detil);
        TextView textViewPenjelasan = findViewById(R.id.penjelasan_resep);
        TextView textViewWaktu = findViewById(R.id.durasi_teks_detil);
        TextView textViewTingkat = findViewById(R.id.kesulitan_detil);
        TextView textViewOrang = findViewById(R.id.untuk_berapa_orang_detil);
        LinearLayout linearLayoutBahan = findViewById(R.id.linear_bahanMasakan);
        LinearLayout linearLayoutStep = findViewById(R.id.linear_caraMemasak);
        ImageView imageView = findViewById(R.id.main_image_banner);

        Button btn_beli = findViewById(R.id.btn_beli);
        btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent troliIntent = new Intent(ResepDetilActivity.this, CartActivity.class);
                ResepDetilActivity.this.startActivity(troliIntent);
            }
        });


        for(int i = 0; i < resep.getBahan().size(); i++){
            View view = getLayoutInflater().inflate(R.layout.text_bahan, linearLayoutBahan, false);

            TextView textViewNamaBahan = view.findViewById(R.id.text_nama_bahan);
            TextView textViewTakaran = view.findViewById(R.id.text_takaran_bahan);
            textViewNamaBahan.setText(resep.getBahan().get(i).getNama());
            textViewTakaran.setText(resep.getBahan().get(i).getTakaran());

            linearLayoutBahan.addView(view);
        }

        for(int i = 0; i < resep.getStep().size(); i++){
            View view = getLayoutInflater().inflate(R.layout.text_step, linearLayoutStep, false);

            TextView textViewJudulStep = view.findViewById(R.id.text_judul_step);
            TextView textViewPenjelasanStep = view.findViewById(R.id.text_penjelasan_step);
            textViewJudulStep.setText(resep.getStep().get(i).getJudul());
            textViewPenjelasanStep.setText(resep.getStep().get(i).getPenjelasan());

            linearLayoutStep.addView(view);
        }

        imageView.setImageResource(resep.getResepImage());
        textViewJudul.setText(resep.getJudulResep());
        textViewSubjudul.setText(resep.getSubJudulResep());
        textViewPenjelasan.setText(resep.getPenjelasanResep());
        textViewTingkat.setText(resep.getTingkatKesulitan());
        textViewOrang.setText(resep.getUntukBerapaOrang());
        textViewWaktu.setText(resep.getWaktuMemasak());

    }

}
