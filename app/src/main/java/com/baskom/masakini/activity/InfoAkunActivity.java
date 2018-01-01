package com.baskom.masakini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.request.MasukRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class InfoAkunActivity extends AppCompatActivity{
    private static final String INFOAKUN_REQUEST_URL = "http://masakini.xyz/masakiniapi/Infoakun.php?email=";
    String email;

    TextView textId;
    EditText textEmail;
    EditText textName;
    EditText textNoHp;
    EditText textAlamat;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Info Akun");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button btnSimpan = findViewById(R.id.btn_simpan_infoakun);
        Button btnKeluar = (Button)findViewById(R.id.btn_keluar);

        textId = findViewById(R.id.text_view_id);
        textEmail = findViewById(R.id.text_view_email);
        textName = findViewById(R.id.text_view_nama);
        textNoHp = findViewById(R.id.et_no_handphone);
        textAlamat = findViewById(R.id.text_view_alamat);


        ////Tarik info akun dari database berdasarkan email
        email = MasukRequest.getEmail();

        //Response Listener buat requestnya
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    textId.setText(jsonResponse.getString("userid"));
                    textEmail.setText(jsonResponse.getString("email"), TextView.BufferType.EDITABLE);
                    textName.setText(jsonResponse.getString("name"), TextView.BufferType.EDITABLE);
                    textNoHp.setText(jsonResponse.getString("noHP"), TextView.BufferType.EDITABLE);
                    textAlamat.setText(jsonResponse.getString("alamat"), TextView.BufferType.EDITABLE);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };

        //Response Error Listener buat requestnya
        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textId.setText("Gagal mengambil dari database");
                textEmail.setText("Gagal mengambil dari database");
                textName.setText("Gagal mengambil dari database");
            }
        };

        //Queuenya
        RequestQueue queue = Volley.newRequestQueue(this);

        //Requestnya
        StringRequest request = new StringRequest(Request.Method.GET, INFOAKUN_REQUEST_URL+email,
                responseListener, responseErrorListener);

        //Masukin ke queuenya
        queue.add(request);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, MainDrawerActivity.class);
                startActivity(intent);

            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentKeluar = new Intent(InfoAkunActivity.this, MasukActivity.class);
                intentKeluar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentKeluar);
                InfoAkunActivity.this.finish();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
