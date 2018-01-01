package com.baskom.masakini.model;

import java.io.Serializable;

/**
 * Created by akmalmuhamad on 28/12/17.
 */

public class Pengguna implements Serializable {
    private String nama;
    private String password;
    private String alamatLengkap;
    private String noHP;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public Pengguna(String nama, String password, String alamat, String noHP, String alamat1) {

        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
        this.noHP = noHP;
        this.alamat = alamat1;
    }

    private String alamat;

}
