package com.baskom.masakini.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.model.Video;
import com.bumptech.glide.Glide;

/**
 * Created by akmalmuhamad on 27/12/17.
 */

public class VideoCardViewHolder extends RecyclerView.ViewHolder{
    private ImageView videoThumbnail;
    private TextView judulVideo;
    private String URL_VIDEO;

    private CardView cardViewVideo;

    public VideoCardViewHolder(View itemView) {
        super(itemView);
        videoThumbnail= itemView.findViewById(R.id.cardView_main_image_video);
        judulVideo = itemView.findViewById(R.id.cardView_judul_video);

        cardViewVideo = itemView.findViewById(R.id.card_view_video);

    }

    public void bindData(final Video video){

        final Uri uri = Uri.parse(video.getVideoURL());

        Glide.with(cardViewVideo.getContext())
                .load(video.getVideoThumbnail())
                .into(videoThumbnail);
        judulVideo.setText(video.getJudulVideo());

        cardViewVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra("force_fullscreen", true);
                v.getContext().startActivity(intent);
            }
        });
    }
}
