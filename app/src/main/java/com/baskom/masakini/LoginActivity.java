package com.baskom.masakini;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}
