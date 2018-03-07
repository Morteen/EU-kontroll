package com.example.morten.nkk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by morten on 28.02.2018.
 */

public class MangelAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Mangler> mineMangler;
    LayoutInflater mInflater;


    public MangelAdapter(Context mContext, ArrayList<Mangler> mineMangler) {
        this.mContext = mContext;
        this.mineMangler = mineMangler;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mineMangler.size();
    }

    @Override
    //Finner Turmaal basert på posisjon i listen
    public Object getItem(int position) {
        return mineMangler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;
        if (convertView == null) {

            //XML fil-navnet
            convertView = mInflater.inflate(R.layout.mangel_liste, null);
            viewHolder = new ViewHolder();


            viewHolder.tvKategori = (TextView) convertView.findViewById(R.id.tvKategori);
            viewHolder.tvKontrollpunkt = (TextView) convertView.findViewById(R.id.tvKontrollpunkt);
            viewHolder.tvMetode = (TextView) convertView.findViewById(R.id.tvMetode);
            viewHolder.tvHovedgrunn = (TextView) convertView.findViewById(R.id.tvHovedgrunn);
            viewHolder.tvBedomming = (TextView) convertView.findViewById(R.id.tvBedomming);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


       Mangler currentMangel = mineMangler.get(position);
        //Setter verdien til  turmaal objektet  i denne posisjonen i riktig textview
        viewHolder.tvKategori.setText(currentMangel.getKategori());
        viewHolder.tvKontrollpunkt.setText(currentMangel.getKontrollpunkt());
        viewHolder.tvMetode.setText(currentMangel.getKontrollMetode());
        viewHolder.tvHovedgrunn.setText(currentMangel.getHovedgrunn());
        viewHolder.tvBedomming.setText(Integer.toString(currentMangel.getBedømming()));



        return convertView;
    }



    private static class ViewHolder {
        public TextView tvKategori;
        public TextView tvKontrollpunkt;
        public TextView tvMetode;
        public TextView tvHovedgrunn;
        public TextView tvBedomming;


    }

}
