package com.baskom.masakini.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.model.ItemTransaksi;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Castor on 2/12/2018.
 */

public class DalamProsesAdapter extends RecyclerView.Adapter<DalamProsesAdapter.ItemTransaksiViewHolder> {
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    List<ItemTransaksi> itemTransaksiList = new ArrayList<>();

    public DalamProsesAdapter(List<ItemTransaksi> itemTransaksiList) {
        this.itemTransaksiList = itemTransaksiList;
    }

    public List<ItemTransaksi> getItemTransaksiList() {
        return itemTransaksiList;
    }

    public void setItemTransaksiList(List<ItemTransaksi> itemTransaksiList) {
        this.itemTransaksiList = itemTransaksiList;
    }

    public class ItemTransaksiViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNomorPesanan;
        private TextView tvPesanan;
        private TextView tvTotalEstimasi;
        private TextView tvStatusPesanan;

        public ItemTransaksiViewHolder(View itemView) {
            super(itemView);
            tvNomorPesanan = itemView.findViewById(R.id.tv_nomor_pesanan);
            tvPesanan = itemView.findViewById(R.id.tv_pesanan);
            tvTotalEstimasi = itemView.findViewById(R.id.tv_total_estimasi);
            tvStatusPesanan = itemView.findViewById(R.id.tv_status_pesanan);
        }

        public TextView getTvNomorPesanan() {
            return tvNomorPesanan;
        }

        public TextView getTvPesanan() {
            return tvPesanan;
        }

        public TextView getTvTotalEstimasi() {
            return tvTotalEstimasi;
        }

        public TextView getTvStatusPesanan() {
            return tvStatusPesanan;
        }
    }

    @Override
    public ItemTransaksiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dalam_proses, parent, false);
        return new ItemTransaksiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemTransaksiViewHolder holder, int position) {
        ItemTransaksi itemTransaksi = itemTransaksiList.get(position);
        String pesanan = "";
        for (int i = 0; i < itemTransaksi.getItemKeranjang().size(); i++) {
            pesanan += itemTransaksi.getItemKeranjang().get(i).getJudulResep() + "\n";
        }
        holder.getTvNomorPesanan().setText(Integer.toString(itemTransaksi.getNomorPesanan()));
        holder.getTvPesanan().setText(pesanan);
        holder.getTvTotalEstimasi().setText(formatRupiah.format(itemTransaksi.getTotalEstimasi()));
        //holder.getTvStatusPesanan().setText(itemTransaksi.getStatusPesanan());

        if (itemTransaksi.getStatusPesanan().contains("Menunggu")) {
            holder.getTvStatusPesanan().setText(itemTransaksi.getStatusPesanan());
        } else if (itemTransaksi.getStatusPesanan().contains("Ditolak")) {
            holder.getTvStatusPesanan().setText(itemTransaksi.getStatusPesanan());
            holder.getTvStatusPesanan().setTextColor(Color.RED);
        } else if (itemTransaksi.getStatusPesanan().contains("Dikirim")) {
            holder.getTvStatusPesanan().setText(itemTransaksi.getStatusPesanan());
            holder.getTvStatusPesanan().setTextColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return itemTransaksiList.size();
    }
}
