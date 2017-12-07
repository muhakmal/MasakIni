package com.baskom.masakini.model;

import java.io.Serializable;

/**
 * Created by Castor on 12/7/2017.
 */

public class Bahan implements Serializable {
    private String nama;
    private String takaran;

    public Bahan(String nama, String takaran) {
        this.nama = nama;
        this.takaran = takaran;
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
}
