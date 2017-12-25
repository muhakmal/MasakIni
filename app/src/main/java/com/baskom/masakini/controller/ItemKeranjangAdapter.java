package com.baskom.masakini.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;
import com.baskom.masakini.model.ItemKeranjang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 25/12/17.
 */

public class ItemKeranjangAdapter extends RecyclerView.Adapter{

    private List<ItemKeranjang> itemKeranjangList = new ArrayList<>();

    public ItemKeranjangAdapter(List<ItemKeranjang> itemKeranjangList){
        this.itemKeranjangList.addAll(itemKeranjangList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_keranjang, parent, false);
        return new ItemKeranjangCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemKeranjangCardViewHolder) holder).bindData(itemKeranjangList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemKeranjangList.size();
    }
}
