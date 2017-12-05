package com.baskom.masakini.subactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baskom.masakini.R;
import com.baskom.masakini.adapter.ResepCardAdapter;
import com.baskom.masakini.feedlist.ResepFeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class ResepTabActivity extends android.support.v4.app.Fragment implements View.OnClickListener{

    private ResepCardAdapter adapter;
    private List<ResepFeed> resepFeedList;

    private CardView cariResep;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_resep, container, false);

        cariResep = (CardView) rootView.findViewById(R.id.search_box_resep);
        cariResep.setOnClickListener(this);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);

        resepFeedList = new ArrayList<>();

        ResepFeed resepFeed = new ResepFeed(
                R.drawable.dummy_img_resep,
                "Pizza Cinta",
                "Dibuat dengan kasih cinta yang sbenearnya.",
                "Mudah",
                "7 orang",
                "30 menit"
        );
        resepFeedList.add(resepFeed);

        ResepFeed resepFeed1 = new ResepFeed(
                R.drawable.dummy_img_resep,
                "Pizza Kayu Manis",
                "Dibuat dengan kayu dari senyum manis kamu.",
                "Sedang",
                "5 orang",
                "60 menit"
        );
        resepFeedList.add(resepFeed1);

        ResepFeed resepFeed2 = new ResepFeed(
                R.drawable.dummy_img_resep,
                "Pizza Kismis",
                "Dibuat pakai kismis.",
                "Sulit",
                "5 orang",
                "45 menit"
        );
        resepFeedList.add(resepFeed2);

        ResepFeed resepFeed3 = new ResepFeed(
                R.drawable.dummy_img_resep,
                "Pizza Kasih",
                "Ekstra Kasih sayang mantan.",
                "Mudah",
                "5 orang",
                "60 menit"
        );
        resepFeedList.add(resepFeed3);

        adapter = new ResepCardAdapter(ResepTabActivity.this, resepFeedList);
        adapter.notifyDataSetChanged();
        rv.setAdapter(adapter);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
        return rootView;


    }


    @Override
    public void onClick(View view) {
        //toast text
        Toast.makeText(getActivity(),"ini button cari resep" , Toast.LENGTH_SHORT).show();
    }
}
