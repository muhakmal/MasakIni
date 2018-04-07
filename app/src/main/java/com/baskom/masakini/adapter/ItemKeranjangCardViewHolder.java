package com.baskom.masakini.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baskom.masakini.R;
import com.baskom.masakini.activity.ItemKeranjangActivity;
import com.baskom.masakini.model.ItemKeranjang;
import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by akmalmuhamad on 25/12/17.
 */

public class ItemKeranjangCardViewHolder extends RecyclerView.ViewHolder {
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    protected CardView cvItemKeranjang;
    protected ImageView ivItemKeranjang;
    protected TextView tvJudulBahanMasakanItemKeranjang;
    protected TextView tvHargaItemKeranjang;
    protected LinearLayout linearLayoutProduk;
    protected Button btnTongSampah;
    protected LayoutInflater inflater;

    private int hargaItemKeranjang = 0;



    public ItemKeranjangCardViewHolder(View itemView) {
        super(itemView);
        cvItemKeranjang = itemView.findViewById(R.id.card_troli);
        ivItemKeranjang = itemView.findViewById(R.id.image_troli);
        tvJudulBahanMasakanItemKeranjang = itemView.findViewById(R.id.tv_judul_resep_troli);
        tvHargaItemKeranjang = itemView.findViewById(R.id.tv_harga_produk_troli);
        tvJudulBahanMasakanItemKeranjang.setSelected(true);
        linearLayoutProduk = itemView.findViewById(R.id.linear_text_troli);
        btnTongSampah = itemView.findViewById(R.id.tongsampah_item_keranjang);
        inflater = LayoutInflater.from(itemView.getContext());
    }

    public void bindData(final ItemKeranjang itemKeranjang) {
        Glide.with(cvItemKeranjang.getContext())
                .load(itemKeranjang.getResepImage())
                .into(ivItemKeranjang);

        tvJudulBahanMasakanItemKeranjang.setText("Bahan masakan untuk " + itemKeranjang.getJudulResep());

        for (int i = 0; i < itemKeranjang.getProduk().size(); i++) {
            View view = inflater.inflate(R.layout.text_bahan, linearLayoutProduk, false);
            TextView textViewNamaProduk = view.findViewById(R.id.text_nama_bahan);
            TextView textViewTakaranProduk = view.findViewById(R.id.text_takaran_bahan);

            textViewNamaProduk.setText(itemKeranjang.getProduk().get(i).getNama());
            textViewTakaranProduk.setText(itemKeranjang.getProduk().get(i).getTakaran());

            hargaItemKeranjang += itemKeranjang.getProduk().get(i).getHarga();

            linearLayoutProduk.addView(view);
        }
        tvHargaItemKeranjang.setText(formatRupiah.format(hargaItemKeranjang));

    }
}
