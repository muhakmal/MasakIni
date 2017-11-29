package com.baskom.masakini.subactivity.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baskom.masakini.MainActivity;
import com.baskom.masakini.R;
import com.baskom.masakini.userarea.LoginActivity;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class InfoAkunActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        TextView textView = (TextView)findViewById(R.id.text_view);
        Button btnKeluar = (Button)findViewById(R.id.btn_keluar);
        btnKeluar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentKeluar = new Intent(InfoAkunActivity.this, LoginActivity.class);
                intentKeluar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentKeluar);
                InfoAkunActivity.this.finish();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Info Akun");
        if(getIntent()!=null){
            textView.setText(getIntent().getStringExtra("string"));
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            //do something before finish
            finish();
            Intent back = new Intent(InfoAkunActivity.this, MainActivity.class);
            startActivity(back);
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
        finish();
    }
}
