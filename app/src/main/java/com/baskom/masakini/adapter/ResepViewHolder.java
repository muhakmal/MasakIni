package com.baskom.masakini.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.feed.ResepFeed;

/**
 * Created by Castor on 12/5/2017.
 */

public class ResepViewHolder extends RecyclerView.ViewHolder{
    private TextView judulResep;
    private TextView subJudulResep;
    private TextView tingkatKesulitan;
    private TextView untukBerapaOrang;
    private TextView waktuMemasak;
    public ImageView resepImage;

    public ResepViewHolder(View itemView){
        super(itemView);
        judulResep = itemView.findViewById(R.id.cardView_JudulResep);
        subJudulResep = itemView.findViewById(R.id.cardView_deksripsiResep);
        tingkatKesulitan = itemView.findViewById(R.id.cardView_tingkat_kesulitan);
        untukBerapaOrang = itemView.findViewById(R.id.cardView_untukBerapaOrang);
        waktuMemasak = itemView.findViewById(R.id.cardView_waktuMemasak);
        resepImage = itemView.findViewById(R.id.cardView_main_image);
    }

    public void bindData(final ResepFeed resepFeed){
       judulResep.setText(resepFeed.getJudulResep());
       subJudulResep.setText(resepFeed.getSubJudulResep());
       tingkatKesulitan.setText(resepFeed.getTingkatKesulitan());
       untukBerapaOrang.setText(resepFeed.getUntukBerapaOrang());
       waktuMemasak.setText(resepFeed.getWaktuMemasak());
    }
}
