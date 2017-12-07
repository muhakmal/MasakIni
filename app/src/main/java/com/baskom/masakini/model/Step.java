package com.baskom.masakini.model;

import java.io.Serializable;

/**
 * Created by Castor on 12/7/2017.
 */

public class Step implements Serializable{
    private String judul;
    private String penjelasan;

    public Step(String judul, String penjelasan) {
        this.judul = judul;
        this.penjelasan = penjelasan;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }
}
