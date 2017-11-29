package com.baskom.masakini.subactivity.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.baskom.masakini.MainActivity;
import com.baskom.masakini.R;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class RiwayatOrderActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_order);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        TextView textView = (TextView)findViewById(R.id.text_view);

        setSupportActionBar(toolbar);
        if(getIntent()!=null){
            textView.setText(getIntent().getStringExtra("string"));
        }

        getSupportActionBar().setTitle("Riwayat Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            Intent back = new Intent(RiwayatOrderActivity.this, MainActivity.class);
            startActivity(back);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
