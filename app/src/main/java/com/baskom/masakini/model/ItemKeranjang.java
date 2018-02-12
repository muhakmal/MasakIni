package com.baskom.masakini.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 25/12/17.
 */

public class ItemKeranjang implements Serializable {
    private String judulResep;
    private String subJudulResep;
    private String penjelasanResep;
    private String tingkatKesulitan;
    private String untukBerapaOrang;
    private String waktuMemasak;
    private String resepImage;
    private List<Bahan> bahan = new ArrayList<>();
    private List<Step> step = new ArrayList<>();
    private List<Produk> produk = new ArrayList<>();
    private int jumlahPaket;

    public String getJudulResep() {
        return judulResep;
    }

    public void setJudulResep(String judulResep) {
        this.judulResep = judulResep;
    }

    public String getSubJudulResep() {
        return subJudulResep;
    }

    public void setSubJudulResep(String subJudulResep) {
        this.subJudulResep = subJudulResep;
    }

    public String getPenjelasanResep() {
        return penjelasanResep;
    }

    public void setPenjelasanResep(String penjelasanResep) {
        this.penjelasanResep = penjelasanResep;
    }

    public String getTingkatKesulitan() {
        return tingkatKesulitan;
    }

    public void setTingkatKesulitan(String tingkatKesulitan) {
        this.tingkatKesulitan = tingkatKesulitan;
    }

    public String getUntukBerapaOrang() {
        return untukBerapaOrang;
    }

    public void setUntukBerapaOrang(String untukBerapaOrang) {
        this.untukBerapaOrang = untukBerapaOrang;
    }

    public String getWaktuMemasak() {
        return waktuMemasak;
    }

    public void setWaktuMemasak(String waktuMemasak) {
        this.waktuMemasak = waktuMemasak;
    }

    public String getResepImage() {
        return resepImage;
    }

    public void setResepImage(String resepImage) {
        this.resepImage = resepImage;
    }

    public List<Bahan> getBahan() {
        return bahan;
    }

    public void setBahan(List<Bahan> bahan) {
        this.bahan = bahan;
    }

    public List<Step> getStep() {
        return step;
    }

    public void setStep(List<Step> step) {
        this.step = step;
    }

    public List<Produk> getProduk() {
        return produk;
    }

    public void setProduk(List<Produk> produk) {
        this.produk = produk;
    }

    public int getJumlahPaket() {
        return jumlahPaket;
    }

    public void setJumlahPaket(int jumlahPaket) {
        this.jumlahPaket = jumlahPaket;
    }

    public ItemKeranjang(String judulResep, String subJudulResep, String penjelasanResep, String tingkatKesulitan, String untukBerapaOrang, String waktuMemasak, String resepImage, List<Bahan> bahan, List<Step> step, List<Produk> produk, int jumlahPaket) {

        this.judulResep = judulResep;
        this.subJudulResep = subJudulResep;
        this.penjelasanResep = penjelasanResep;
        this.tingkatKesulitan = tingkatKesulitan;
        this.untukBerapaOrang = untukBerapaOrang;
        this.waktuMemasak = waktuMemasak;
        this.resepImage = resepImage;
        this.bahan = bahan;
        this.step = step;
        this.produk = produk;
        this.jumlahPaket = jumlahPaket;
    }

    public int getTotalHarga(){
        int total = 0;
        for (int i = 0 ; i < produk.size(); i++){
            total += produk.get(i).getHarga();
        }
        return total;
    }
}
