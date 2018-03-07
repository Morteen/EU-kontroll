package com.example.morten.nkk;

/**
 * Created by morten on 28.02.2018.
 */

public class Mangler {

    private String kategori;
    private String kontrollpunkt;
    private String kontrollMetode;
    private String hovedgrunn;
    private int bedømming;

    public Mangler() {
    }

    public String getKontrollpunkt() {
        return kontrollpunkt;
    }

    public void setKontrollpunkt(String kontrollpunkt) {
        this.kontrollpunkt = kontrollpunkt;
    }

    public String getKontrollMetode() {
        return kontrollMetode;
    }

    public void setKontrollMetode(String kontrollMetode) {
        this.kontrollMetode = kontrollMetode;
    }

    public String getHovedgrunn() {
        return hovedgrunn;
    }

    public void setHovedgrunn(String hovedgrunn) {
        this.hovedgrunn = hovedgrunn;
    }

    public int getBedømming() {
        return bedømming;
    }

    public void setBedømming(int bedømming) {
        this.bedømming = bedømming;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
