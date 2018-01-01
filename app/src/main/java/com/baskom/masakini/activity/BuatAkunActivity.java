package com.baskom.masakini.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.andreabaccega.formedittextvalidator.AlphaNumericValidator;
import com.andreabaccega.formedittextvalidator.EmailValidator;
import com.andreabaccega.formedittextvalidator.NumericValidator;
import com.andreabaccega.formedittextvalidator.PersonFullNameValidator;
import com.andreabaccega.widget.FormEditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.request.BuatAkunRequest;
import com.vstechlab.easyfonts.EasyFonts;

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

        final FormEditText etNama = findViewById(R.id.etNama);
        final FormEditText etEmail = findViewById(R.id.etEmail);
        final FormEditText etPassword = findViewById(R.id.etPassword);
        final FormEditText etNohp = findViewById(R.id.et_no_hp_buatakun);
        final FormEditText etAlamat = findViewById(R.id.et_alamat_lengkap_buatakun);
        final ProgressBar progressBar = findViewById(R.id.progressBar_buatakun);
        etPassword.setTypeface(EasyFonts.robotoRegular(this));

        etEmail.addValidator(new EmailValidator(null));
        etNama.addValidator(new PersonFullNameValidator(null));
        etPassword.addValidator(new AlphaNumericValidator(null));
        etNohp.addValidator(new NumericValidator(null));
        etAlamat.addValidator(new AlphaNumericValidator(null));

        final Button btBuatAkun = (Button) findViewById(R.id.btBuatAkun);
        final TextView loginLink = (TextView) findViewById(R.id.textLogin);
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(BuatAkunActivity.this, MasukActivity.class);
                BuatAkunActivity.this.startActivity(loginIntent);
            }
        });

        btBuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nama = etNama.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final String no_hp = etNohp.getText().toString();
                final String alamat_lengkap = etAlamat.getText().toString();
                progressBar.setVisibility(View.VISIBLE);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            FormEditText[] allFields = {etNama, etEmail, etPassword};
                            boolean allValid = true;
                            for (FormEditText field : allFields) {
                                allValid = field.testValidity() && allValid;
                            }
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success && allValid) {
                                Intent intent = new Intent(BuatAkunActivity.this, MasukActivity.class);
                                BuatAkunActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BuatAkunActivity.this);
                                builder.setMessage("User sudah terdaftar dan atau format yang anda masukkan salah")
                                        .setTitle("Buat Akun Gagal")
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

                BuatAkunRequest buatAkunRequest = new BuatAkunRequest(nama, email, password, no_hp, alamat_lengkap, responseListener);
                RequestQueue antrian = Volley.newRequestQueue(BuatAkunActivity.this);
                antrian.add(buatAkunRequest);
            }
        });
    }

}
