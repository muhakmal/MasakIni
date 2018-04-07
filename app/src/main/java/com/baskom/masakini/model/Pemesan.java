package com.baskom.miadmin.model;

/**
 * Created by Castor on 2/16/2018.
 */

public class Pemesan {
    private String nama;
    private String email;
    private String noHP;
    private String alamatLengkap;

    public Pemesan(String nama, String email, String noHP, String alamatLengkap) {
        this.nama = nama;
        this.email = email;
        this.noHP = noHP;
        this.alamatLengkap = alamatLengkap;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }
}
