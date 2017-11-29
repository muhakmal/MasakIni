package com.baskom.masakini.subactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.baskom.masakini.MainActivity;
import com.baskom.masakini.R;

/**
 * Created by akmalmuhamad on 22/11/17.
 */

public class CartActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Keranjang Makanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            //do something before finish
            finish();
            Intent back = new Intent(CartActivity.this, MainActivity.class);
            startActivity(back);
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
        finish();
    }
}
