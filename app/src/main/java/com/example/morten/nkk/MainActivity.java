package com.example.morten.nkk;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
EditText regNr;
Button submitRegNr;
ListView bilmerkeListview;
public static Kjoretoy kjoretoy;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        kjoretoy = new Kjoretoy();

        setAllItems();

















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

private void setAllItems(){



    regNr=(EditText)findViewById(R.id.regnr);
    submitRegNr=(Button)findViewById(R.id.submitRegNr);
    submitRegNr.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
                    "Du har en Toyota, så du får ingen problemer!! " , Toast.LENGTH_LONG).show();

        }
    });

    //Henter bilmerker fra resurser i values/string
    Resources res = getResources();
    String[] merker = res.getStringArray(R.array.merker);
    bilmerkeListview=(ListView)findViewById(R.id.bilmerkeListview);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, merker);
    bilmerkeListview.setAdapter(adapter);
    //bilmerke Item Click Listener
    bilmerkeListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {

            // ListView Clicked item index
            int itemPosition     = position;

            // ListView Clicked item value
            String  itemValue = (String) bilmerkeListview.getItemAtPosition(position);



            kjoretoy.setMerke(itemValue);
            // Show Alert
            Toast.makeText(getApplicationContext(),
                    "Position :"+itemPosition+"  Merke : " +kjoretoy.getMerke() , Toast.LENGTH_LONG)
                    .show();
            Bundle bundle= new Bundle();
            bundle.putInt("ListPos",position);

            BilmodelFrag fragment = new BilmodelFrag();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            fragment.setArguments(bundle);
            transaction.replace(R.id.fragment_container,fragment);
            transaction.addToBackStack(null);
            transaction.commit();




        }

    });




}//slutt på setAllItems


}
