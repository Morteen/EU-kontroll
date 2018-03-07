package com.example.morten.nkk;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Vanligemangler extends android.support.v4.app.Fragment {
    ListView mangelListview;
    MangelAdapter adapter;
    ArrayList<Mangler> list;
   TextView bilnavn;

    public Vanligemangler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vanligemangler, container, false);

        bilnavn=(TextView)view.findViewById(R.id.bilnavn);
        bilnavn.setText("Vanlige feil for \n"+MainActivity.kjoretoy.getMerke()+" "+MainActivity.kjoretoy.getModell());

        testMangler();

        mangelListview = (ListView) view.findViewById(R.id.mangelListview);
        adapter = new MangelAdapter(getContext(), list);
        mangelListview.setAdapter(adapter);


        return view;
    }


    public void testMangler() {
        list= new ArrayList<Mangler>();
        Mangler enFeil = new Mangler();
        enFeil.setKategori("Styring");
        enFeil.setKontrollpunkt("2.3 Ledd");
        enFeil.setKontrollMetode("Visuell kontroll av komponenter i bevegelse og kontrollere slakk");
        enFeil.setHovedgrunn("Forstor vandring og slakk i ledd");
        enFeil.setBedømming(2);
        list.add(enFeil);

        Mangler toFeil = new Mangler();
        toFeil.setKategori("LYS/REFLEKS/ELEKTRISK ");
        toFeil.setKontrollpunkt("4.1 Fjernlys");
        toFeil.setKontrollMetode("Visuell kontroll av lykter/glass/reflektorer.");
        toFeil.setHovedgrunn("Fjernlys defekte pærer");
        toFeil.setBedømming(2);
        list.add(toFeil);

    }
}
