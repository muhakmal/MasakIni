package com.baskom.masakini.userarea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akmalmuhamad on 18/11/17.
 */

public class BuatAkunActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_akun);

        final EditText etNama = (EditText) findViewById(R.id.etNama);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button btBuatAkun = (Button) findViewById(R.id.btBuatAkun);

        final TextView loginLink = (TextView) findViewById(R.id.textLogin);

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(BuatAkunActivity.this, LoginActivity.class);
                BuatAkunActivity.this.startActivity(loginIntent);
            }
        });

        btBuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nama = etNama.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(BuatAkunActivity.this, LoginActivity.class);
                                BuatAkunActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BuatAkunActivity.this);
                                builder.setMessage("User Sudah Terdaftar")
                                        .setNegativeButton("Ulangi", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                BuatAkunRequest buatAkunRequest = new BuatAkunRequest(nama, email, password, responseListener);
                RequestQueue antrian = Volley.newRequestQueue(BuatAkunActivity.this);
                antrian.add(buatAkunRequest);
            }
        });
    }

}
