package com.baskom.masakini.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 24/12/17.
 */

public class ItemTransaksi implements Serializable {
    private int nomorPesanan;
    private String statusPesanan;
    private List<ItemKeranjang> itemKeranjang = new ArrayList<>();

    public ItemTransaksi(int nomorPesanan, List<ItemKeranjang> itemKeranjang, String statusPesanan) {
        this.nomorPesanan = nomorPesanan;
        this.itemKeranjang = itemKeranjang;
        this.statusPesanan = statusPesanan;
    }

    public int getNomorPesanan() {
        return nomorPesanan;
    }

    public void setNomorPesanan(int nomorPesanan) {
        this.nomorPesanan = nomorPesanan;
    }

    public List<ItemKeranjang> getItemKeranjang() {
        return itemKeranjang;
    }

    public void setItemKeranjang(List<ItemKeranjang> itemKeranjang) {
        this.itemKeranjang = itemKeranjang;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }

    public int getTotalEstimasi(){
        int totalEstimasi = 0;
        for (int i = 0; i < itemKeranjang.size(); i++){
            totalEstimasi += itemKeranjang.get(i).getTotalHarga();
        }
        return totalEstimasi;
    }
}