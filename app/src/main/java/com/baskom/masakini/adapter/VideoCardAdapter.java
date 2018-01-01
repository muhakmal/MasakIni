package com.baskom.masakini.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;
import com.baskom.masakini.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 29/11/17.
 */

public class VideoCardAdapter extends RecyclerView.Adapter {

    private List<Video> videoList = new ArrayList<>();

    public VideoCardAdapter(List<Video> videoList) {
        this.videoList.addAll(videoList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video, parent, false);
        return new VideoCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder.getItemViewType() == R.layout.card_video) {
            ((VideoCardViewHolder) holder).bindData(videoList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.card_video;
    }
}
