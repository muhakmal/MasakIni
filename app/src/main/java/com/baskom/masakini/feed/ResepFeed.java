package com.baskom.masakini.feed;

/**
 * Created by akmalmuhamad on 24/11/17.
 */

public class ResepFeed {
    private String judulResep;
    private String subJudulResep;
    private String tingkatKesulitan;
    private String untukBerapaOrang;
    private String waktuMemasak;
    private int resepImage;

    public ResepFeed(int resepImage, String judulResep, String subJudulResep, String tingkatKesulitan, String untukBerapaOrang, String waktuMemasak) {
        this.resepImage = resepImage;
        this.judulResep = judulResep;
        this.subJudulResep = subJudulResep;
        this.tingkatKesulitan = tingkatKesulitan;
        this.untukBerapaOrang = untukBerapaOrang;
        this.waktuMemasak = waktuMemasak;
    }


    public int getResepImage() {
        return resepImage;
    }

    public void setResepImage(int resepImage) {
        this.resepImage = resepImage;
    }

    //setter getter judul resep
    public String getJudulResep() {
        return judulResep;
    }

    public void setJudulResep(String judulResep) {
        this.judulResep = judulResep;
    }

    //steter getter subjudulresep
    public String getSubJudulResep() {
        return subJudulResep;
    }

    public void setSubJudulResep(String subJudulResep) {
        this.subJudulResep = subJudulResep;
    }

    //setter getter tinggkat kesulitan
    public String getTingkatKesulitan() {
        return tingkatKesulitan;
    }

    public void setTingkatKesulitan(String tingkatKesulitan) {
        this.tingkatKesulitan = tingkatKesulitan;
    }

    //setter getter untuk berapa orang
    public String getUntukBerapaOrang() {
        return untukBerapaOrang;
    }

    public void setUntukBerapaOrang(String untukBerapaOrang) {
        this.untukBerapaOrang = untukBerapaOrang;
    }

    //setter getter waktu memasak
    public String getWaktuMemasak() {
        return waktuMemasak;
    }

    public void setWaktuMemasak(String waktuMemasak) {
        this.waktuMemasak = waktuMemasak;
    }
}

