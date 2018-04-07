package com.baskom.masakini.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.adapter.ItemKeranjangAdapter;
import com.baskom.masakini.adapter.ItemKeranjangCardViewHolder;
import com.baskom.masakini.model.ItemKeranjang;
import com.baskom.masakini.request.ItemKeranjangRequest;
import com.baskom.masakini.request.MasukRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemKeranjangActivity extends AppCompatActivity {
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    List<ItemKeranjang> itemKeranjangList = new ArrayList<>();
    RecyclerView recyclerView;
    ItemKeranjangAdapter adapter;
    ProgressBar progressBar;
    Toolbar toolbar;
    Button btnBayarKeranjang;
    public static int jumlahItemKeranjang;
    public static TextView tvTotalEstimasi;
    public int total;
    private ImageView imgKamuBelumBelanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_keranjang);
        toolbar = findViewById(R.id.toolbar_keranjang);
        setSupportActionBar(toolbar);
        imgKamuBelumBelanja = findViewById(R.id.img_kamu_belum_belanja);
        imgKamuBelumBelanja.setVisibility(View.VISIBLE);

        getSupportActionBar().setTitle("Keranjang Masakan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar = findViewById(R.id.progressBarItemKeranjang);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.recycler_view_cart);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        total = 0;
        tvTotalEstimasi = findViewById(R.id.tv_total_estimasi_item_keranjang);
        tvTotalEstimasi.setText(formatRupiah.format(total));

        btnBayarKeranjang = findViewById(R.id.btn_bayar_troli);
        btnBayarKeranjang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(ItemKeranjangActivity.this, PembelianKonfirmasiActivity.class);
              intent.putExtra("total", total);
              startActivity(intent);
            }
        });

        getItemKeranjangList();
    }

    public void getItemKeranjangList() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonArray jsonResponse = new JsonParser().parse(response).getAsJsonArray();
                Type listType = new TypeToken<List<ItemKeranjang>>(){}.getType();
                itemKeranjangList = new Gson().fromJson(jsonResponse, listType);
                adapter = new ItemKeranjangAdapter(itemKeranjangList, ItemKeranjangActivity.this);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
                jumlahItemKeranjang = adapter.getItemCount();

                for(int i = 0; i < itemKeranjangList.size(); i++){
                    int harga = 0;
                    for(int j = 0; j < itemKeranjangList.get(i).getProduk().size(); j++){
                        harga += itemKeranjangList.get(i).getProduk().get(j).getHarga();
                    }
                    total += harga;
                }
                tvTotalEstimasi.setText(formatRupiah.format(total));
            }
        };

        ItemKeranjangRequest request = new ItemKeranjangRequest(MasukRequest.getEmail(), responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, MainDrawerActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainDrawerActivity.class);
        startActivity(intent);
        finish();
    }

}
