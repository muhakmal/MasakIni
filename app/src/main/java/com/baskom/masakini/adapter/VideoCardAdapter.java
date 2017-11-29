package com.baskom.masakini.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.feed.VideoFeed;
import com.baskom.masakini.subactivity.VideoTabActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by akmalmuhamad on 29/11/17.
 */

public class VideoCardAdapter extends RecyclerView.Adapter<VideoCardAdapter.MyViewHolder> {

    private VideoTabActivity mContext;
    private List<VideoFeed> videoFeeds;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView judulVideo;
        public ImageView videoImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            videoImage = (ImageView) itemView.findViewById(R.id.cardView_main_image_video);
            judulVideo = (TextView) itemView.findViewById(R.id.cardView_judul_video);
        }
    }

    public VideoCardAdapter(VideoTabActivity mContext, List<VideoFeed> videoFeeds) {
        this.mContext = mContext;
        this.videoFeeds = videoFeeds;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_video, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final VideoFeed videoFeedList = videoFeeds.get(position);
        holder.judulVideo.setText(videoFeedList.getJudulVideo());

        Glide.with(mContext)
                .load(videoFeedList.getVideoImage())
                .into(holder.videoImage);
    }

    @Override
    public int getItemCount() {
        return videoFeeds.size();
    }


}
