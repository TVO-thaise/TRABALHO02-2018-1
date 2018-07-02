package com.example.samsung.appcidadao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.samsung.appcidadao.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{


    private String[] activities = {"ListaEleitor"};
    private String[] itemMenu = {"Eleitor"};
    private String[] activities = {"ListaCandidato"};
    private String[] itemMenu = {"Candidato"};



    private RadioGroup rgCidadao;
    private RadioButton rbEleitor;
    private ImageView imgCidadao;
    private Integer []imagens = { R.drawable.cidadao};
    private Button btAdd;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemMenu);

            ListView listView = (ListView) findViewById(R.id.ListaEleitor);
            ListView listView = (ListView) findViewById(R.id.ListaCandidato);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            Intent intent = null;

            try {

                Class obj = Class.forName ("com.example.samsung.appcidadao.activity."+activities[position]);
                intent = new Intent(this, obj);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            startActivity(intent);

        }

}