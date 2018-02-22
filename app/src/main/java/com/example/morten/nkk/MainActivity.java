package com.example.morten.nkk;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
Spinner bilmerkeSpinner,bilmodellSpinner;
Kjoretoy kjoretoy;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Henter bilmerker fra resurser i values/string
        Resources res = getResources();
        String[] merker = res.getStringArray(R.array.merker);



        bilmerkeSpinner=(Spinner)findViewById(R.id.bilmerkeSpinner);

       // ArrayAdapter<String> spinneradapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,spinnerItems );
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, merker );
        // Apply the adapter to the spinner
        spinneradapter.setDropDownViewResource(R.layout.spinner_textview_align);
        bilmerkeSpinner.setAdapter(spinneradapter);
        bilmerkeSpinner.setOnItemSelectedListener(this);








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Spinner spinner=(Spinner)parent;
        if(spinner.getId()==R.id.bilmerkeSpinner){
            setSpinnerMerke(pos);
        }else if(spinner.getId()==R.id.bilmodellSpinner){
            Toast.makeText(this, "Velg modell funker", android.widget.Toast.LENGTH_SHORT).show();
        }


    }





    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String[] velgModell(int pos){
        Resources res = getResources();
       String [] modell;
        switch (pos) {
            case 1:  pos =1;
                modell= res.getStringArray(R.array.opel);

            break;
            case 2:  pos= 2;
               modell= res.getStringArray(R.array.vw);
            break;
            case 3:  pos = 3;
                modell= res.getStringArray(R.array.ford);
            break;
            case 4:  pos = 4;
               modell= res.getStringArray(R.array.toyota);
            break;
            case 5:  pos = 5;
                modell= res.getStringArray(R.array.subaru);
            break;
            case 6:  pos = 6;
                modell= res.getStringArray(R.array.audi);
            break;
            case 7:  pos = 7;
                modell=res.getStringArray(R.array.skoda);
            break;

            default: pos = 0;
            modell=null;
                break;
        }
        return modell;
    }
    private String velgMerkeNavn(int pos){
        Resources res = getResources();
        String  modell;
        switch (pos) {
            case 1:  pos =1;
                modell= "Opel";

                break;
            case 2:  pos= 2;
                modell= "Vw";
                break;
            case 3:  pos = 3;
                modell= "Ford";
                break;
            case 4:  pos = 4;
                modell= "Toyota";
                break;
            case 5:  pos = 5;
                modell= "Subaru";
                break;
            case 6:  pos = 6;
                modell= "Audi";
                break;
            case 7:  pos = 7;
                modell="Skoda";
                break;

            default: pos = 0;
                modell=null;
                break;
        }
        return modell;
    }
private void setSpinnerMerke(int pos){
    bilmodellSpinner=(Spinner)findViewById(R.id.bilmodellSpinner);
    //kjoretoy.setMerke(velgMerkeNavn(pos));
    String []modell=velgModell(pos);
    if(modell!=null){
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, modell);
        // Apply the adapter to the spinner
        spinneradapter.setDropDownViewResource(R.layout.spinner_textview_align);
        bilmodellSpinner.setAdapter(spinneradapter);
    }else{
        Toast.makeText(this, "Velg modell", android.widget.Toast.LENGTH_SHORT).show();
    }
}


}
