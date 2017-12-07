package com.baskom.masakini.adapter;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.feed.Resep;
import com.baskom.masakini.feed.ResepFeed;

import org.w3c.dom.Text;

/**
 * Created by akmalmuhamad on 04/12/17.
 */

public class ResepDetil extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        TextView textView = findViewById(R.id.test_text);
        Resep resep = (Resep) getIntent().getSerializableExtra("objekResep");
        textView.setText(resep.getPenjelasanResep());

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(getIntent().getStringExtra("judul"))
//                .setNegativeButton("Ulangi", null)
//                .create()
//                .show();

      /*  judulResep = findViewById(R.id.judul_resep_detil);
        subJudulResep = findViewById(R.id.deskripsi_detil);
        tingkatKesulitan = findViewById(R.id.kesulitan_detil);
        untukBerapaOrang = findViewById(R.id.untuk_berapa_orang_detil);
        waktuMemasak = findViewById(R.id.durasi_teks_detil);
        resepImage = findViewById(R.id.main_banner);

        judulResep.setText(getIntent().getStringExtra("judul_resep"));
        subJudulResep.setText(getIntent().getStringExtra("deskripsi_resep"));


*/
    }
}
