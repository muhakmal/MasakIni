package com.baskom.masakini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.model.Resep;
import com.bumptech.glide.Glide;
import com.matrixxun.starry.badgetextview.MaterialBadgeTextView;

/**
 * Created by akmalmuhamad on 04/12/17.
 */

public class ResepDetilActivity extends AppCompatActivity {

    Resep resep;
    TextView textViewJudul;
    TextView textViewSubjudul;
    TextView textViewPenjelasan;
    TextView textViewWaktu;
    TextView textViewTingkat;
    TextView textViewOrang;
    LinearLayout linearLayoutBahan;
    LinearLayout linearLayoutStep;
    ImageView imageView;
    Button btn_beli;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_detil);

        resep = (Resep) getIntent().getSerializableExtra("objekResep");

        textViewJudul = findViewById(R.id.judul_resep_detil);
        textViewSubjudul = findViewById(R.id.deskripsi_detil);
        textViewPenjelasan = findViewById(R.id.penjelasan_resep);
        textViewWaktu = findViewById(R.id.durasi_teks_detil);
        textViewTingkat = findViewById(R.id.kesulitan_detil);
        textViewOrang = findViewById(R.id.untuk_berapa_orang_detil);

        linearLayoutBahan = findViewById(R.id.linear_bahanMasakan);
        linearLayoutStep = findViewById(R.id.linear_caraMemasak);
        imageView = findViewById(R.id.main_image_banner);
        Button btn_beli = findViewById(R.id.btn_beli);
        btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent troliIntent = new Intent(view.getContext(), TroliActivity.class);
                troliIntent.putExtra("objekResep", resep);
                startActivity(troliIntent);
            }
        });


        //untuk munculin nama bahan dan takaran
        for (int i = 0; i < resep.getBahan().size(); i++) {
            View view = getLayoutInflater().inflate(R.layout.text_bahan, linearLayoutBahan, false);

            TextView textViewNamaBahan = view.findViewById(R.id.text_nama_bahan);
            TextView textViewTakaran = view.findViewById(R.id.text_takaran_bahan);

            textViewNamaBahan.setText(resep.getBahan().get(i).getNama());
            textViewTakaran.setText(resep.getBahan().get(i).getTakaran());

            linearLayoutBahan.addView(view);
        }

        //untuk munculin judul step
        for (int i = 1; i < resep.getStep().size(); i++) {
            View view = getLayoutInflater().inflate(R.layout.text_step, linearLayoutStep, false);

            MaterialBadgeTextView drawableCountStep = view.findViewById(R.id.drawable_count_step);
            TextView textViewJudulStep = view.findViewById(R.id.text_judul_step);
            TextView textViewPenjelasanStep = view.findViewById(R.id.text_penjelasan_step);

            drawableCountStep.setBadgeCount(i);
            textViewJudulStep.setText(resep.getStep().get(i).getJudul());
            textViewPenjelasanStep.setText(resep.getStep().get(i).getPenjelasan());

            linearLayoutStep.addView(view);
        }

        //setter untuk setiap variabel ke dalam XML
        Glide.with(imageView.getContext()).load(resep.getResepImage()).into(imageView);
        textViewJudul.setText(resep.getJudulResep());
        textViewSubjudul.setText(resep.getSubJudulResep());
        textViewPenjelasan.setText(resep.getPenjelasanResep());
        textViewTingkat.setText(resep.getTingkatKesulitan());
        textViewOrang.setText(resep.getUntukBerapaOrang());
        textViewWaktu.setText(resep.getWaktuMemasak());

    }

}
