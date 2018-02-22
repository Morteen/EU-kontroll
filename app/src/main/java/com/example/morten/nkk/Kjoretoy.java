package com.example.morten.nkk;

import java.util.ArrayList;

/**
 * Created by morten on 18.02.2018.
 */

public class Kjoretoy {
    private String merke;
    private String modell;
    private ArrayList<String>feil;

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

    public ArrayList<String> getFeil() {
        return feil;
    }

    public void setFeil(ArrayList<String> feil) {
        this.feil = feil;
    }

    public Kjoretoy(String merke) {
        this.merke = merke;
    }

}

