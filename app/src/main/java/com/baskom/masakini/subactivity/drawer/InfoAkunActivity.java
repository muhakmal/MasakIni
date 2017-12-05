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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.MainActivity;
import com.baskom.masakini.R;
import com.baskom.masakini.userarea.LoginActivity;
import com.baskom.masakini.userarea.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class InfoAkunActivity extends AppCompatActivity{
    private static final String INFOAKUN_REQUEST_URL = "http://masakini.xyz/masakiniapi/Infoakun.php?email=";
    String email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
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

        final TextView textId = findViewById(R.id.text_view_id);
        final TextView textEmail = findViewById(R.id.text_view_email);
        final TextView textName = findViewById(R.id.text_view_nama);

        ////Tarik info akun dari database berdasarkan email (START)
        email = LoginRequest.getEmail();

        //Response Listener buat requestnya
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    textId.setText(jsonResponse.getString("userid"));
                    textEmail.setText(jsonResponse.getString("email"));
                    textName.setText(jsonResponse.getString("name"));
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
        ////Tarik info akun dari database berdasarkan email (END)
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



}
