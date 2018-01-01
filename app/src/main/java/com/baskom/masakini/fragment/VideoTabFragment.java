package com.baskom.masakini.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;
import com.baskom.masakini.adapter.VideoCardAdapter;
import com.baskom.masakini.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class VideoTabFragment extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    VideoCardAdapter adapter;
    private List<Video> videoList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view_video);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        getVideoList();
        return rootView;
    }

    public void getVideoList() {
        videoList = new ArrayList<>();

        Video video = new Video(
                "90's Cake - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/90'scake_video_thumbnail.jpg",
                "https://youtu.be/ec3As5G7Tm0?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        videoList.add(video);

        Video video1 = new Video(
                "Ayam Goreng Saos Padang - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/ayamgorengpadang_video_thumbnail.jpg",
                "https://youtu.be/R5xg9jB3njo?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"

        );
        videoList.add(video1);

        Video video2 = new Video(
                "Gulai Balungan - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/gulaibalungan__video_thumbnail.jpg",
                "https://youtu.be/q4e1ZHMaLQg?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        videoList.add(video2);

        Video video3 = new Video(
                "Gurame Saos Lemon - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/guramelemon_video_thumbnail.jpg",
                "https://youtu.be/KtcazjQdtbA?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        videoList.add(video3);

        Video video4 = new Video(
                "Nasi Bakar Bumbu Jontor",
                "http://masakini.xyz/masakiniapi/video_thumbnail/nasbakar_video_thumbnail.jpg",
                "https://youtu.be/dAa6bHXAMcw?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        videoList.add(video4);

        adapter = new VideoCardAdapter(videoList);
        recyclerView.setAdapter(adapter);
    }
}