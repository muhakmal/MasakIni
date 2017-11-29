package com.baskom.masakini.drawercontent;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by akmalmuhamad on 23/11/17.
 */

public class ResepCardAdapter extends RecyclerView.Adapter<ResepCardAdapter.MyViewHolder>{
    private ResepTabActivity mContext;
    private List<ResepCard> resepCards;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView judulResep, subJudulResep, tingkatKesulitan, untukBerapaOrang, waktuMemasak;
        public ImageView resepImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            judulResep = (TextView)itemView.findViewById(R.id.cardView_JudulResep);
            subJudulResep = (TextView)itemView.findViewById(R.id.cardView_deksripsiResep);
            tingkatKesulitan = (TextView)itemView.findViewById(R.id.cardView_tingkat_kesulitan);
            untukBerapaOrang = (TextView)itemView.findViewById(R.id.cardView_untukBerapaOrang);
            waktuMemasak = (TextView)itemView.findViewById(R.id.cardView_waktuMemasak);
            resepImage = (ImageView)itemView.findViewById(R.id.cardView_main_image);
        }
    }

    public ResepCardAdapter(ResepTabActivity mContext, List<ResepCard> resepCards){
        this.mContext = mContext;
        this.resepCards = resepCards;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate new view when creating new items in recyclerview
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resep_card_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ResepCard resepCardList = resepCards.get(position);
        holder.judulResep.setText(resepCardList.getJudulResep());
        holder.subJudulResep.setText(resepCardList.getSubJudulResep());
        holder.tingkatKesulitan.setText(resepCardList.getTingkatKesulitan());
        holder.untukBerapaOrang.setText(resepCardList.getUntukBerapaOrang());
        holder.waktuMemasak.setText(resepCardList.getWaktuMemasak());

        Glide.with(mContext)
                .load(resepCardList.getResepImage())
                .into(holder.resepImage);

    }

    @Override
    public int getItemCount() {
        return resepCards.size();
    }


}
