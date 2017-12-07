package com.baskom.masakini.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;
import com.baskom.masakini.controller.ResepCardAdapter;
import com.baskom.masakini.model.Bahan;
import com.baskom.masakini.model.Resep;
import com.baskom.masakini.model.Step;

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
        recyclerView.setFocusable(false);

        ResepCardAdapter adapter = new ResepCardAdapter(generateDummyList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    //Method buat bikin list resep dummy
    private List<Resep> generateDummyList(){
        List<Resep> resepList = new ArrayList<>();

        List<Bahan> bahan = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            bahan.add(new Bahan("Ini nama bahan "+i, "Ini takaran bahan "+i));
        }
        List<Step> step = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            step.add(new Step("Ini step "+i, "Ini penjelasan step "+i));
        }
        Resep resep = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Cinta",
                "Dibuat dengan kasih cinta yang sebenernya.",
                getString(R.string.lorem_ipsum),
                "Mudah",
                "4 orang",
                "30 Menit",
                3,
                bahan,
                5,
                step
        );
        resepList.add(resep);

        List<Bahan> bahan1 = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            bahan1.add(new Bahan("Ini nama bahan "+i, "Ini takaran bahan "+i));
        }
        List<Step> step1 = new ArrayList<>();
        for(int i = 1; i <= 4; i++){
            step1.add(new Step("Ini step "+i, "Ini penjelasan step "+i));
        }
        Resep resep1 = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Kasih",
                "Ekstrak kasih sayang mantan.",
                getString(R.string.lorem_ipsum),
                "Sedang",
                "9 orang",
                "400 Menit",
                6,
                bahan1,
                4,
                step1
        );
        resepList.add(resep1);

        List<Bahan> bahan2 = new ArrayList<>();
        for(int i = 1; i <= 8; i++){
            bahan2.add(new Bahan("Ini nama bahan "+i, "Ini takaran bahan "+i));
        }
        List<Step> step2 = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            step2.add(new Step("Ini step "+i, "Ini penjelasan step "+i));
        }
        Resep resep2 = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Kayu Manis",
                "Dibuat dengan kayu dari senyum manis kamu.",
                getString(R.string.lorem_ipsum),
                "Sedang",
                "7 orang",
                "60 Menit",
                8,
                bahan2,
                6,
                step2
        );
        resepList.add(resep2);

        List<Bahan> bahan3 = new ArrayList<>();
        for(int i = 1; i <= 7; i++){
            bahan3.add(new Bahan("Ini nama bahan "+i, "Ini takaran bahan "+i));
        }
        List<Step> step3 = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            step3.add(new Step("Ini step "+i, "Ini penjelasan step "+i));
        }
        Resep resep3 = new Resep(
                R.drawable.dummy_img_resep,
                "Pizza Kismis",
                "Dibuat pakai kismis.",
                getString(R.string.lorem_ipsum),
                "Sulit",
                "11 orang",
                "45 Menit",
                7,
                bahan3,
                10,
                step3
        );
        resepList.add(resep3);

        return resepList;
    }

}
