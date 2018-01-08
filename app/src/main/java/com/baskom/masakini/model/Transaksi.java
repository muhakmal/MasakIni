package com.baskom.masakini.model;

import java.io.Serializable;

/**
 * Created by akmalmuhamad on 24/12/17.
 */

public class Transaksi implements Serializable {
    private int nomorOrder;
    private int totalEstimasi;

    public Transaksi(int nomorOrder, int totalEstimasi) {
        this.nomorOrder = nomorOrder;
        this.totalEstimasi = totalEstimasi;
    }

    public int getNomorOrder() {

        return nomorOrder;
    }

    public void setNomorOrder(int nomorOrder) {
        this.nomorOrder = nomorOrder;
    }

    public int getTotalEstimasi() {
        return totalEstimasi;
    }

    public void setTotalEstimasi(int totalEstimasi) {
        this.totalEstimasi = totalEstimasi;
    }
}