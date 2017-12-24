package com.baskom.masakini.model;

import java.io.Serializable;

/**
 * Created by akmalmuhamad on 24/12/17.
 */

public class Transaksi implements Serializable {
    int nomorOrder=00001;
    int hargaProduk=0;
    int totalEstimasi;
    int jumlahPaket =1;

    public int getNomorOrder() {
        return nomorOrder;
    }

    public void setNomorOrder(int nomorOrder) {
        this.nomorOrder = nomorOrder;
    }

    public int getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public int getTotalEstimasi() {
        return totalEstimasi;
    }

    public void setTotalEstimasi(int totalEstimasi) {
        this.totalEstimasi = totalEstimasi;
    }

    public int getJumlahPaket() {
        return jumlahPaket;
    }

    public void setJumlahPaket(int jumlahPaket) {
        this.jumlahPaket = jumlahPaket;
    }

    public Transaksi(int nomorOrder, int hargaProduk, int totalEstimasi, int jumlahPaket) {
        this.nomorOrder = nomorOrder;
        this.hargaProduk = hargaProduk;
        this.totalEstimasi = totalEstimasi;
        this.jumlahPaket = jumlahPaket;
    }
}
