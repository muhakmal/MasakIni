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
import com.baskom.masakini.model.ItemKeranjang;
import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

/**
 * Created by akmalmuhamad on 25/12/17.
 */

public class ItemKeranjangCardViewHolder extends RecyclerView.ViewHolder {
    protected CardView cardView;
    protected ImageView imageTroli;
    protected TextView judulResepTroli;
    protected TextView hargaTroli;
    protected   LinearLayout linearProduk;
    protected ElegantNumberButton tambahJumlahPaket;
    protected Button tongSampah;
    protected LayoutInflater inflater;

    private int hargaItemKeranjang;

    private int total;


    public ItemKeranjangCardViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_item_keranjang);
        judulResepTroli = itemView.findViewById(R.id.judul_resep_item_keranjang);
        hargaTroli = itemView.findViewById(R.id.harga_item_keranjang);
        linearProduk = itemView.findViewById(R.id.linear_text_item_keranjang);
        tambahJumlahPaket = itemView.findViewById(R.id.btn_tambahJumlahPaket_item_keranjang);
        tongSampah = itemView.findViewById(R.id.tongsampah_item_keranjang);
        imageTroli = itemView.findViewById(R.id.image_item_keranjang);
        judulResepTroli.setSelected(true);
        inflater = LayoutInflater.from(itemView.getContext());
        hargaItemKeranjang = 0;
    }

    public void bindData(final ItemKeranjang itemKeranjang) {
        Glide.with(cardView.getContext())
                .load(itemKeranjang.getResepImage())
                .into(imageTroli);
        judulResepTroli.setText("Bahan masakan untuk " + itemKeranjang.getJudulResep());
        for (int i = 0; i < itemKeranjang.getProduk().size(); i++) {
            View view = inflater.inflate(R.layout.text_bahan, linearProduk, false);
            TextView textViewNamaProduk = view.findViewById(R.id.text_nama_bahan);
            TextView textViewTakaranProduk = view.findViewById(R.id.text_takaran_bahan);

            textViewNamaProduk.setText(itemKeranjang.getProduk().get(i).getNama());
            textViewTakaranProduk.setText(itemKeranjang.getProduk().get(i).getTakaran());

            hargaItemKeranjang += itemKeranjang.getProduk().get(i).getHarga();

            linearProduk.addView(view);
        }
        tambahJumlahPaket.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(tambahJumlahPaket.getNumber()) == 2) {
                    total = hargaItemKeranjang * 2;
                } else if (Integer.parseInt(tambahJumlahPaket.getNumber()) == 1) {
                    total = hargaItemKeranjang * 1;
                } else if (Integer.parseInt(tambahJumlahPaket.getNumber()) == 3) {
                    total = hargaItemKeranjang * 3;
                }
                hargaTroli.setText("Estimasi harga bahan masakan : Rp"+ Integer.toString(total));
            }
        });

        hargaTroli.setText("Estimasi harga bahan masakan : Rp" + Integer.toString(hargaItemKeranjang * itemKeranjang.getJumlahPaket()));
        tambahJumlahPaket.setNumber(Integer.toString(itemKeranjang.getJumlahPaket()));
    }
}
