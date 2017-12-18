package com.baskom.masakini.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.baskom.masakini.R;
import com.githang.stepview.StepView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by akmalmuhamad on 17/12/17.
 */

public class SelesaiActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmasi_selesai);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konfirmasi Pembelian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        StepView stepView = findViewById(R.id.step_view);
        List<String> steps = Arrays.asList(new String[]{"Pengiriman", "Pembayaran", "Selesai"});
        stepView.setSteps(steps);
        stepView.selectedStep(3);

        Button btnRiwayatOrder = findViewById(R.id.btn_riwayatOrder_selesai);
        Button btnKembali = findViewById(R.id.btn_kembali_selesai);

        btnRiwayatOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keRiwayat = new Intent(SelesaiActivity.this, RiwayatOrderActivity.class);
                startActivity(keRiwayat);
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keHome = new Intent(SelesaiActivity.this, MainActivity.class);
                startActivity(keHome);
            }
        });
    }
}
