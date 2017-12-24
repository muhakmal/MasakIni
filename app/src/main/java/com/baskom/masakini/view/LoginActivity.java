package com.baskom.masakini.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.andreabaccega.formedittextvalidator.AlphaNumericValidator;
import com.andreabaccega.formedittextvalidator.EmailValidator;
import com.andreabaccega.widget.FormEditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.model.LoginRequest;
import com.baskom.masakini.R;
import com.vstechlab.easyfonts.EasyFonts;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akmalmuhamad on 18/11/17.
 */

public class LoginActivity extends AppCompatActivity {
    private static final String DRAWER_REQUEST = "http://masakini.xyz/masakiniapi/Infoakun.php?email=";
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final FormEditText etEmail = findViewById(R.id.etEmail);
        final FormEditText etPassword = findViewById(R.id.etPassword);
        final Button btLogin = (Button) findViewById(R.id.btLogin);
        final TextView textBuatAkunLink = (TextView) findViewById(R.id.textBuatAkun);

        etPassword.setTypeface(EasyFonts.robotoRegular(this));
        etEmail.addValidator(new EmailValidator("Harus email"));
        etPassword.addValidator(new AlphaNumericValidator(null));

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
                final ProgressBar progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            FormEditText[] allFields = {etEmail, etPassword};
                            boolean allValid = true;
                            for (FormEditText field : allFields) {
                                allValid = field.testValidity() && allValid;
                            }

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success && allValid) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                LoginActivity.this.startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage(response)
                                        .setTitle("Masuk Gagal")
                                        .setMessage("Format email/password yang anda masukkan salah atau data anda tidak ada dalam database.")
                                        .setNegativeButton("Ulangi", null)
                                        .create()
                                        .show();
                            }
                            progressBar.setVisibility(View.GONE);
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
