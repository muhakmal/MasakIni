package com.baskom.masakini.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.feed.ResepFeed;
import com.baskom.masakini.subactivity.ResepTabActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by akmalmuhamad on 23/11/17.
 */

public class ResepCardAdapter extends RecyclerView.Adapter<ResepCardAdapter.MyViewHolder> {

    private ResepTabActivity mContext;
    private List<ResepFeed> resepFeeds;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView judulResep, subJudulResep, tingkatKesulitan, untukBerapaOrang, waktuMemasak;
        public ImageView resepImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            judulResep = (TextView) itemView.findViewById(R.id.cardView_JudulResep);
            subJudulResep = (TextView) itemView.findViewById(R.id.cardView_deksripsiResep);
            tingkatKesulitan = (TextView) itemView.findViewById(R.id.cardView_tingkat_kesulitan);
            untukBerapaOrang = (TextView) itemView.findViewById(R.id.cardView_untukBerapaOrang);
            waktuMemasak = (TextView) itemView.findViewById(R.id.cardView_waktuMemasak);
            resepImage = (ImageView) itemView.findViewById(R.id.cardView_main_image);
        }
    }

    public ResepCardAdapter(ResepTabActivity mContext, List<ResepFeed> resepFeeds) {
        this.mContext = mContext;
        this.resepFeeds = resepFeeds;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate new view when creating new items in recyclerview
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_resep, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ResepFeed resepFeedList = resepFeeds.get(position);
        holder.judulResep.setText(resepFeedList.getJudulResep());
        holder.subJudulResep.setText(resepFeedList.getSubJudulResep());
        holder.tingkatKesulitan.setText(resepFeedList.getTingkatKesulitan());
        holder.untukBerapaOrang.setText(resepFeedList.getUntukBerapaOrang());
        holder.waktuMemasak.setText(resepFeedList.getWaktuMemasak());

        Glide.with(mContext)
                .load(resepFeedList.getResepImage())
                .into(holder.resepImage);

    }

    @Override
    public int getItemCount() {
        return resepFeeds.size();
    }


}
