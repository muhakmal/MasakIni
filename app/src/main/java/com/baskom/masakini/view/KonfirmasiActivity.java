package com.baskom.masakini.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.baskom.masakini.R;
import com.githang.stepview.StepView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by akmalmuhamad on 15/12/17.
 */

public class KonfirmasiActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_konfirmasi);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konfirmasi Pembelian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        StepView mStepView = (StepView) findViewById(R.id.step_view);

        List<String> steps = Arrays.asList(new String[]{"Pengiriman", "Pembayaran", "Selesai"});
        mStepView.setSteps(steps);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
