package com.baskom.masakini.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.andreabaccega.formedittextvalidator.AlphaNumericValidator;
import com.andreabaccega.formedittextvalidator.EmailValidator;
import com.andreabaccega.widget.FormEditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.request.MasukRequest;
import com.baskom.masakini.R;
import com.vstechlab.easyfonts.EasyFonts;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akmalmuhamad on 18/11/17.
 */

public class MasukActivity extends AppCompatActivity {
    private static final String DRAWER_REQUEST = "http://masakini.xyz/masakiniapi/Infoakun.php?email=";
    String email;

    FormEditText etEmail;
    FormEditText etPassword;
    Button btLogin;
    TextView textBuatAkunLink;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
        textBuatAkunLink = findViewById(R.id.textBuatAkun);
        progressBar = findViewById(R.id.progressBar);
        etPassword.setTypeface(EasyFonts.robotoRegular(this));
        etEmail.addValidator(new EmailValidator("Harus email"));
        etPassword.addValidator(new AlphaNumericValidator(null));
        etPassword.setImeActionLabel("MASUK", KeyEvent.KEYCODE_ENTER);

        textBuatAkunLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent buatAkunIntent = new Intent(MasukActivity.this, BuatAkunActivity.class);
                MasukActivity.this.startActivity(buatAkunIntent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
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
                                Toast.makeText(MasukActivity.this, "Selamat, anda berhasil masuk", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MasukActivity.this, MainDrawerActivity.class);
                                MasukActivity.this.startActivity(intent);
                                MasukActivity.this.finish();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MasukActivity.this);
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
                MasukRequest masukRequest = new MasukRequest(email, password, responseListener);
                RequestQueue antrian = Volley.newRequestQueue(MasukActivity.this);
                antrian.add(masukRequest);
            }
        });
    }
}


