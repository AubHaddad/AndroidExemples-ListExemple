package com.example.hd_a.listeexemple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    TextView tv;
    Spinner  sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lv);
        tv = (TextView)findViewById(R.id.tv);
        sp = (Spinner)findViewById(R.id.sp);

        final ArrayList<String> items = new ArrayList<String>();
        items.add("Pain");
        items.add("Lait");
        items.add("Sucre");
        items.add("Thé");

        ArrayAdapter<String> adapterLv = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_1,
                        items);

        ArrayAdapter<String> adapterSp = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_spinner_dropdown_item,
                        items);

        lv.setAdapter(adapterLv);
        sp.setAdapter(adapterSp);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View view, int position, long id)
            {
                Toast.makeText(
                        getApplicationContext(),
                        items.get(position),
                        Toast.LENGTH_LONG)
                        .show();
                tv.setText( items.get(position));
            }
        }
        );

      sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent,
                                     View view,
                                     int position, long id) {

              tv.setText( items.get(position));
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });


    }
}
