package com.baskom.masakini.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;
import com.baskom.masakini.controller.VideoCardAdapter;
import com.baskom.masakini.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class VideoTabActivity extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private VideoCardAdapter adapter;
    private List<Video> videoList;

    private static final String[]  YOUTUBE_PLAYLISTS ={
            "ec3As5G7Tm0",

    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_video, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view_video);
        rv.setHasFixedSize(true);

/*
        videoList = new ArrayList<>();

        Video video = new Video(
                R.drawable.dummy_img_resep,
                "Pizza Apik Dibuat Dengan Cinta"
        );
        videoList.add(video);

        Video video1 = new Video(
                R.drawable.dummy_img_resep,
                "Pizza Kasih Sayang - Feat Masterchef"
        );
        videoList.add(video1);

        Video video2 = new Video(
                R.drawable.dummy_img_resep,
                "Pizza Mantan - Special Ingredients"
        );
        videoList.add(video2);

        Video video3 = new Video(
                R.drawable.dummy_img_resep,
                "Pizza Pizza Pizza oh Pizza"
        );
        videoList.add(video3);

        adapter = new VideoCardAdapter(VideoTabActivity.this, videoList);
        adapter.notifyDataSetChanged();*/
        rv.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
        return rootView;
    }

}
