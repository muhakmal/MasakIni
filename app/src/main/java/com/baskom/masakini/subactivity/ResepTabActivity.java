package com.baskom.masakini.subactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.baskom.masakini.MainActivity;
import com.baskom.masakini.R;
import com.baskom.masakini.adapter.ResepCardAdapter;
import com.baskom.masakini.feed.Resep;
import com.baskom.masakini.feed.ResepFeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class ResepTabActivity extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_resep, container, false);


        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);

        ResepCardAdapter adapter = new ResepCardAdapter(generateDummyList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    //Method buat bikin list resep dummy
    private List<Resep> generateDummyList(){
        List<Resep> resepList = new ArrayList<>();

        List<String> judulStep = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            judulStep.add("Ini step "+i);
        }
        List<String> penjelasanStep = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            penjelasanStep.add("Ini penjelasan step "+i);
        }
        Resep resep = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Cinta",
                "Dibuat dengan kasih cinta yang sebenernya.",
                getString(R.string.lorem_ipsum),
                "Mudah",
                "5 orang",
                "30 Menit",
                5,
                judulStep,
                penjelasanStep
        );
        resepList.add(resep);

        List<String> judulStep1 = new ArrayList<>();
        for(int i = 1; i <= 4; i++){
            judulStep1.add("Ini step "+i);
        }
        List<String> penjelasanStep1 = new ArrayList<>();
        for(int i = 1; i <= 4; i++){
            penjelasanStep1.add("Ini penjelasan step "+i);
        }
        Resep resep1 = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Kasih",
                "Ekstrak kasih sayang mantan.",
                getString(R.string.lorem_ipsum),
                "Sedang",
                "5 orang",
                "400 Menit",
                4,
                judulStep1,
                penjelasanStep1
        );
        resepList.add(resep1);

        List<String> judulStep2 = new ArrayList<>();
        for(int i = 1; i <= 7; i++){
            judulStep2.add("Ini step "+i);
        }
        List<String> penjelasanStep2 = new ArrayList<>();
        for(int i = 1; i <= 7; i++){
            penjelasanStep2.add("Ini penjelasan step "+i);
        }
        Resep resep2 = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Kayu Manis",
                "Dibuat dengan kayu dari senyum manis kamu.",
                getString(R.string.lorem_ipsum),
                "Sedang",
                "5 orang",
                "60 Menit",
                7,
                judulStep2,
                penjelasanStep2
        );
        resepList.add(resep2);

        List<String> judulStep3 = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            judulStep3.add("Ini step "+i);
        }
        List<String> penjelasanStep3 = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            penjelasanStep3.add("Ini penjelasan step "+i);
        }
        Resep resep3 = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Kismis",
                "Dibuat pakai kismis.",
                getString(R.string.lorem_ipsum),
                "Sulit",
                "5 orang",
                "45 Menit",
                3,
                judulStep3,
                penjelasanStep3
        );
        resepList.add(resep3);

        return resepList;
    }

}
