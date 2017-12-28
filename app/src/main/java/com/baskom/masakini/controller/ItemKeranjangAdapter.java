package com.baskom.masakini.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.model.DeleteItemKeranjangRequest;
import com.baskom.masakini.model.ItemKeranjang;
import com.baskom.masakini.model.LoginRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 25/12/17.
 */

public class ItemKeranjangAdapter extends RecyclerView.Adapter{

    //The Dataset
    private List<ItemKeranjang> itemKeranjangList = new ArrayList<>();

    //For Volley Stuff
    Response.Listener<String> listener;
    RequestQueue queue;
    DeleteItemKeranjangRequest request;

    public ItemKeranjangAdapter(List<ItemKeranjang> itemKeranjangList, final Context context){
        //Initialize the Dataset
        this.itemKeranjangList.addAll(itemKeranjangList);

        //Initialize the listener and queue
        listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Resep telah dihapus dari keranjang..atau troli..atau apalah itu", Toast.LENGTH_SHORT).show();
            }
        };
        queue = Volley.newRequestQueue(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_keranjang, parent, false);
        return new ItemKeranjangCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //Initialize the request
        request = new DeleteItemKeranjangRequest(LoginRequest.getEmail(), itemKeranjangList.get(position).getJudulResep(), listener);

        ((ItemKeranjangCardViewHolder) holder).bindData(itemKeranjangList.get(position));
        ((ItemKeranjangCardViewHolder) holder).tongSampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add(request);
                itemKeranjangList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemKeranjangList.size();
    }
}
