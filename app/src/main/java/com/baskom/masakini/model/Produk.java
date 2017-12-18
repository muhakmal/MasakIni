package com.baskom.masakini.model;

import java.io.Serializable;

/**
 * Created by Castor on 12/18/2017.
 */

public class Produk implements Serializable {
    String nama;
    String takaran;
    int harga;

    public Produk(String nama, String takaran, int harga) {
        this.nama = nama;
        this.takaran = takaran;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTakaran() {
        return takaran;
    }

    public void setTakaran(String takaran) {
        this.takaran = takaran;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
