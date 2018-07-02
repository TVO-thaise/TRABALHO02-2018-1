package com.example.samsung.appcidadao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.samsung.appcidadao.R;

/**
 * Created by Samsung on 02/07/2018.
 */

public class CandidatoDetalhe extends AppCompatActivity {

    EditText etNome, etPartido, etNumeroUrna, etCargo, etNumeroVotos,etEstado, etMunicipio;

    Button btsalvar,btalterar, btdeletar;

    int id;
    Candidato candidato;
    private Realm realm;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidato);

        etNome = (EditText)findViewById(R.id.etNome);
        etNomeMae = (EditText)findViewById(R.id.etNomeMae);
        etDataNasc = (EditText)findViewById(R.id.etDataNasc);
        etNumeroTit =  (EditText)findViewById(R.id.etNumeroTit);
        etZona = (EditText)findViewById(R.id.etZona);
        etSecao = (EditText)findViewById(R.id.etSeçao);
        etMunicipio = (EditText)findViewById(R.id.etMunicipio);


        btsalvar = (Button) findViewById(R.id.bt_salvar_candidato);
        btalterar = (Button) findViewById(R.id.bt_alterar_candidato);
        btdeletar = (Button) findViewById(R.id.bt_deletar_candidato);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            candidato = realm.where(CandidatoDetalhe.class).equalTo("id",id).findFirst();


            etNome.setText(candidato.getNome());
            etNomeMae.setText(candidato.getNomeMae());
            etDataNasc.setText(formato.format((Date)candidato.getDataNasc()));
            etNumeroTit.setText(candidato.getNumeroTit());
            etZona.setText(candidato.getZona());
            etSecao.setText(candidato.getSecao());
            etMunicipio.setText(formato.format((Date) candidato.getMunicipio()));


        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        candidato.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Candidato.class).max("id") !=null)
            proximoID = realm.where(CandidatoDetalhe.class).max("id").intValue()+1;

        realm.beginTransaction();
        Candidato candidato = new Candidato();
        candidato.setId(proximoID);
        setEGrava(candidato);

        realm.copyToRealm(evento);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Candidato Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    private void setEGrava(Candidato candidato){

        candidato.setNome(etNome.getText().toString());
        candidato.setNomeMae(etNomeMae.getText().toString());
        candidato.setDataNasc(etDataNasc.getText().toString());
        candidato.setNumeroTit(etNumeroTit.getText().toString());
        candidato.setZona((etZona.getText().toString()));
        candidato.setSecao((etSecao.getText().toString()));
        candidato.setMunicipio((etMunicipio.getText().toString()));


        try {
            candidato.setDataNasc((Date) formato.parse(etData.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    public void alterar() {

        realm.beginTransaction();

        setEGrava(candidato);

        realm.copyToRealm(candidato);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Candidato Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }

}
