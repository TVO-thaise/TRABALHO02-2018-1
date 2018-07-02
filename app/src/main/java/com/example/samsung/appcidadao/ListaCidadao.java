package com.example.samsung.appcidadao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

/**
 * Created by Samsung on 02/07/2018.
 */

public class ListaCidadao extends AppCompatActivity implements ClickRecyclerViewListener{

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cidadao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCidadao.this,CidadaoDetalhe.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }

        });
    }


    protected void onResume() {

        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCidadao);

        recyclerView.setAdapter(new CidadaoAdapter(getEventos(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Cidadao> getCidadao(){

        return (List) realm.where(Evento.class).findAll(); // na verdade aqui deveria ter uma lista pra eleitor e outra pra candidato

    }

    @Override
    public void onClick(Object object) {
        Cidadao cidadao = (Cidadao) object;
        Intent intent = new Intent(ListaCidadao.this,CidadaoDetalhe.class);
        intent.putExtra("id",cidadao.getId());
        startActivity(intent);
    }


    public void finish(){
        super.finish();
        realm.close();


    }
}
