package com.example.samsung.appcidadao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.samsung.appcidadao.R;

import java.util.List;

/**
 * Created by Samsung on 02/07/2018.
 */

public class ListaCandidato extends AppCompatActivity implements ClickRecyclerViewListener{

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_candidato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCandidato.this,CandidatoDetalhe.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }

        });
    }


    protected void onResume() {

        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCidadao);

        recyclerView.setAdapter(new CandidatoAdapter(getCandidato(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Candidato> getCandidato(){

        return (List) realm.where(Evento.class).findAll(); // na verdade aqui deveria ter uma lista pra candidato e outra pra candidato

    }

    @Override
    public void onClick(Object object) {
        Candidato candidato = (Candidato) object;
        Intent intent = new Intent(ListaCandidato.this,CandidatoDetalhe.class);
        intent.putExtra("id",candidato.getId());
        startActivity(intent);
    }


    public void finish(){
        super.finish();
        realm.close();


    }
}
