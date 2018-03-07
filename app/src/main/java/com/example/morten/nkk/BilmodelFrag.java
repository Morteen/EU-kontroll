package com.example.morten.nkk;


import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BilmodelFrag extends android.support.v4.app.Fragment {

    ListView bilModelListview;
    TextView merkenavn;
    public BilmodelFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_bilmodel, container, false);

       setAllItem(view);


        return view;
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
                modell=res.getStringArray(R.array.kia);
                break;
            case 8:  pos = 8;
                modell=res.getStringArray(R.array.skoda);
                break;

            default: pos = 0;
                modell=res.getStringArray(R.array.hint);
                break;
        }
        return modell;
    }


    private void setAllItem(View view){
        //Setter textview og bilnavnet
        merkenavn=(TextView)view.findViewById(R.id.merkenavn);
        merkenavn.setText(MainActivity.kjoretoy.getMerke());


        bilModelListview=(ListView)view.findViewById(R.id.biModellListview);

        Bundle bundle= getArguments();
        int pos =bundle.getInt("ListPos");
        String[] modell = velgModell(pos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, modell);
        bilModelListview.setAdapter(adapter);

        bilModelListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String  listItem = (String) bilModelListview.getItemAtPosition(position);



                MainActivity.kjoretoy.setModell(listItem);

                Toast.makeText(getActivity(),
                        "Position :"+position+" "+MainActivity.kjoretoy.getMerke()+" "+MainActivity.kjoretoy.getModell(), Toast.LENGTH_LONG)
                        .show();


                Vanligemangler fragment = new Vanligemangler();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,fragment);
                transaction.addToBackStack(null);
                transaction.commit();



            }
        });

    }

}
