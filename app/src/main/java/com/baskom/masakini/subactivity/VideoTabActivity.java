package com.baskom.masakini.subactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;
import com.baskom.masakini.adapter.VideoCardAdapter;
import com.baskom.masakini.feed.VideoFeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class VideoTabActivity extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private VideoCardAdapter adapter;
    private List<VideoFeed> videoFeedList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_video, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view_video);
        rv.setHasFixedSize(true);

        videoFeedList = new ArrayList<>();

        VideoFeed videoFeed = new VideoFeed(
                R.drawable.dummy_img_resep,
                "Pizza Apik Dibuat Dengan Cinta"
        );
        videoFeedList.add(videoFeed);

        VideoFeed videoFeed1 = new VideoFeed(
                R.drawable.dummy_img_resep,
                "Pizza Apik Dibuat Dengan Kasih Sayang"
        );
        videoFeedList.add(videoFeed1);

        VideoFeed videoFeed2 = new VideoFeed(
                R.drawable.dummy_img_resep,
                "Pizza Apik Dibuat Dengan Mantan"
        );
        videoFeedList.add(videoFeed2);

        VideoFeed videoFeed3 = new VideoFeed(
                R.drawable.dummy_img_resep,
                "Pizza Apik Dibuat Dengan Kasih"
        );
        videoFeedList.add(videoFeed3);

        adapter = new VideoCardAdapter(VideoTabActivity.this, videoFeedList);
        adapter.notifyDataSetChanged();
        rv.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
        return rootView;
    }

}
