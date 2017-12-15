package com.baskom.masakini.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Castor on 12/6/2017.
 */

public class Resep implements Serializable {

    private String resepImage;
    private String judulResep;
    private String subJudulResep;
    private String penjelasanResep;
    private String tingkatKesulitan;
    private String untukBerapaOrang;
    private String waktuMemasak;
    private int jumlahBahan;
    private List<Bahan> bahan = new ArrayList<>();
    private int jumlahStep;
    private List<Step> step = new ArrayList<>();

    public Resep(String resepImage, String judulResep, String subJudulResep, String penjelasanResep, String tingkatKesulitan, String untukBerapaOrang, String waktuMemasak, int jumlahBahan, List<Bahan> bahan, int jumlahStep, List<Step> step) {
        this.resepImage = resepImage;
        this.judulResep = judulResep;
        this.subJudulResep = subJudulResep;
        this.penjelasanResep = penjelasanResep;
        this.tingkatKesulitan = tingkatKesulitan;
        this.untukBerapaOrang = untukBerapaOrang;
        this.waktuMemasak = waktuMemasak;
        this.jumlahBahan = jumlahBahan;
        this.bahan.addAll(bahan);
        this.jumlahStep = jumlahStep;
        this.step.addAll(step);
    }

    public String getResepImage() {
        return resepImage;
    }

    public void setResepImage(String resepImage) {
        this.resepImage = resepImage;
    }

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

    public int getJumlahBahan() {
        return jumlahBahan;
    }

    public void setJumlahBahan(int jumlahBahan) {
        this.jumlahBahan = jumlahBahan;
    }

    public List<Bahan> getBahan() {
        return bahan;
    }

    public void setBahan(List<Bahan> bahan) {
        this.bahan = bahan;
    }

    public int getJumlahStep() {
        return jumlahStep;
    }

    public void setJumlahStep(int jumlahStep) {
        this.jumlahStep = jumlahStep;
    }

    public List<Step> getStep() {
        return step;
    }

    public void setStep(List<Step> step) {
        this.step = step;
    }
}
