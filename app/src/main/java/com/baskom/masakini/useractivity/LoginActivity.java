package com.baskom.masakini.useractivity;

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
import com.baskom.masakini.DrawerActivity;
import com.baskom.masakini.MainActivity;
import com.baskom.masakini.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akmalmuhamad on 18/11/17.
 */

public class LoginActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button btLogin = (Button) findViewById(R.id.btLogin);
        final TextView textBuatAkunLink = (TextView) findViewById(R.id.textBuatAkun);

        textBuatAkunLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buatAkunIntent = new Intent(LoginActivity.this, BuatAkunActivity.class);
                LoginActivity.this.startActivity(buatAkunIntent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
                                LoginActivity.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Gagal")
                                        .setNegativeButton("Ulangi", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                LoginRequest loginRequest = new LoginRequest(email, password, responseListener);
                RequestQueue antrian = Volley.newRequestQueue(LoginActivity.this);
                antrian.add(loginRequest);

            }
        });
    }
}
