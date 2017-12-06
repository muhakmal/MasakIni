package com.baskom.masakini.feed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Castor on 12/6/2017.
 */

public class Resep implements Serializable {

    private int resepImage;
    private String judulResep;
    private String subJudulResep;
    private String penjelasanResep;
    private String tingkatKesulitan;
    private String untukBerapaOrang;
    private String waktuMemasak;
    private int jumlahStep;
    private List<String> judulStep = new ArrayList<>();
    private List<String> penjelasanStep = new ArrayList<>();

    public Resep(int resepImage, String judulResep, String subJudulResep, String penjelasanResep, String tingkatKesulitan,
                 String untukBerapaOrang, String waktuMemasak, int jumlahStep, List<String> judulStep, List<String> penjelasanStep){
            this.resepImage = resepImage;
            this.judulResep = judulResep;
            this.subJudulResep = subJudulResep;
            this.penjelasanResep = penjelasanResep;
            this.tingkatKesulitan = tingkatKesulitan;
            this.untukBerapaOrang = untukBerapaOrang;
            this.waktuMemasak = waktuMemasak;
            this.jumlahStep = jumlahStep;
            this.judulStep.addAll(judulStep);
            this.penjelasanStep.addAll(penjelasanStep);
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

    public int getResepImage() {
        return resepImage;
    }

    public void setResepImage(int resepImage) {
        this.resepImage = resepImage;
    }

    public List<String> getJudulStep() {
        return judulStep;
    }

    public void setJudulStep(List<String> judulStep) {
        this.judulStep = judulStep;
    }

    public List<String> getPenjelasanStep() {
        return penjelasanStep;
    }

    public void setPenjelasanStep(List<String> penjelasanStep) {
        this.penjelasanStep = penjelasanStep;
    }
}
