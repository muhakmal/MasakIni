package com.baskom.masakini.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.masakini.R;
import com.baskom.masakini.request.DeleteItemKeranjangRequest;
import com.baskom.masakini.model.ItemKeranjang;
import com.baskom.masakini.request.MasukRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 25/12/17.
 */

public class ItemKeranjangAdapter extends RecyclerView.Adapter {


    //The Dataset
    private List<ItemKeranjang> itemKeranjangList = new ArrayList<>();

    //For Volley Stuff
    RequestQueue queue;
    Context context;

    public ItemKeranjangAdapter(List<ItemKeranjang> itemKeranjangList, final Context context) {
        //Initialize the Dataset
        this.itemKeranjangList.addAll(itemKeranjangList);
        this.context = context;
        //Initialize the listener and queue

        queue = Volley.newRequestQueue(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_keranjang, parent, false);
        return new ItemKeranjangCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, itemKeranjangList.get(holder.getAdapterPosition()).getJudulResep() + " telah dihapus dari keranjang", Toast.LENGTH_SHORT).show();
                itemKeranjangList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        };
        final DeleteItemKeranjangRequest request = new DeleteItemKeranjangRequest(MasukRequest.getEmail(), itemKeranjangList.get(holder.getAdapterPosition()).getJudulResep(), listener);

        ((ItemKeranjangCardViewHolder) holder).bindData(itemKeranjangList.get(holder.getAdapterPosition()));

        ((ItemKeranjangCardViewHolder) holder).btnTongSampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Hapus Bahan Masakan")
                        .setMessage("Hapus " + itemKeranjangList.get(holder.getAdapterPosition()).getJudulResep() + " dari keranjang?")
                        .setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing
                            }
                        })
                        .setNegativeButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                queue.add(request);
                            }
                        }).show();
                //Toast.makeText(context, Integer.toString(holder.getAdapterPosition())+" "+itemKeranjangList.get(holder.getAdapterPosition()).getJudulResep(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemKeranjangList.size();
    }
}
