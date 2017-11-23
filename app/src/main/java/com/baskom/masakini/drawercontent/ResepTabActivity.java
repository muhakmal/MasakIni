package com.baskom.masakini.drawercontent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class ResepTabActivity extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ResepCardAdapter adapter;
    private List<ResepCard> resepCardList;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_resep, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);

        resepCardList = new ArrayList<>();
        adapter = new ResepCardAdapter(ResepTabActivity.this, resepCardList);
        ResepCard resepCard = new ResepCard(
                R.id.cardView_main_image,
                "Pizza Mozarella Bagi-Bagi",
                "Ekstra Kismis dan kopi luak, dan macam-nya",
                "Gampil",
                "5",
                "3 Milenium"
        );
        resepCardList.add(0,resepCard);

        resepCard = new ResepCard(
                R.id.cardView_main_image,
                "Pizza Mozarella Bagi-Bagi",
                "Ekstra Kismis dan kopi luak, dan macam-nya",
                "Gampil",
                "5",
                "3 Milenium"
        );
        resepCardList.add(0,resepCard);

        resepCard = new ResepCard(
                R.id.cardView_main_image,
                "Pizza Mozarella Bagi-Bagi",
                "Ekstra Kismis dan kopi luak, dan macam-nya",
                "Gampil",
                "5",
                "3 Milenium"
        );
        resepCardList.add(0,resepCard);

        resepCard = new ResepCard(
                R.id.cardView_main_image,
                "Pizza Mozarella Bagi-Bagi",
                "Ekstra Kismis dan kopi luak, dan macam-nya",
                "Gampil",
                "5",
                "3 Milenium"
        );
        resepCardList.add(0,resepCard);
        adapter.notifyDataSetChanged();

        LinearLayoutManager linearLayoutManager =   new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
        return rootView;




    }




}
