package com.example.morten.nkk;

import java.util.ArrayList;

/**
 * Created by morten on 18.02.2018.
 */

public class Kjoretoy {
    private String merke;
    private String modell;
    private ArrayList<Mangler>mangler;

    public Kjoretoy() {
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public ArrayList<Mangler> getFeil() {
        return mangler;
    }

    public void setFeil(ArrayList<Mangler> mangler) {
        this.mangler = mangler;
    }

    public Kjoretoy(String merke) {
        this.merke = merke;
    }

}

