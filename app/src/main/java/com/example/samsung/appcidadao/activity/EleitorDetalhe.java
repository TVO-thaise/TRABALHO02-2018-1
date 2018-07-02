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

public class EleitorDetalhe extends AppCompatActivity {

    EditText etNome, etNomeMae, etDataNasc, etNumeroTit, etZona, etSecao, etMunicipio;

    Button btsalvar,btalterar, btdeletar;

    int id;
    Eleitor eleitor;
    private Realm realm;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleitor);

        etNome = (EditText)findViewById(R.id.etNome);
        etNomeMae = (EditText)findViewById(R.id.etNomeMae);
        etDataNasc = (EditText)findViewById(R.id.etDataNasc);
        etNumeroTit =  (EditText)findViewById(R.id.etNumeroTit);
        etZona = (EditText)findViewById(R.id.etZona);
        etSecao = (EditText)findViewById(R.id.etSeçao);
        etMunicipio = (EditText)findViewById(R.id.etMunicipio);


        btsalvar = (Button) findViewById(R.id.bt_salvar_eleitor);
        btalterar = (Button) findViewById(R.id.bt_alterar_eleitor);
        btdeletar = (Button) findViewById(R.id.bt_deletar_eleitor);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            eleitor = realm.where(EleitorDetalhe.class).equalTo("id",id).findFirst();


            etNome.setText(eleitor.getNome());
            etNomeMae.setText(eleitor.getNomeMae());
            etDataNasc.setText(formato.format((Date)eleitor.getDataNasc()));
            etNumeroTit.setText(eleitor.getNumeroTit());
            etZona.setText(eleitor.getZona());
            etSecao.setText(eleitor.getSecao());
            etMunicipio.setText(formato.format((Date) eleitor.getMunicipio()));


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
        eleitor.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Eleitor.class).max("id") !=null)
            proximoID = realm.where(EleitorDetalhe.class).max("id").intValue()+1;

        realm.beginTransaction();
        Eleitor eleitor = new Eleitor();
        eleitor.setId(proximoID);
        setEGrava(eleitor);

        realm.copyToRealm(evento);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Eleitor Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    private void setEGrava(Eleitor eleitor){

        eleitor.setNome(etNome.getText().toString());
        eleitor.setNomeMae(etNomeMae.getText().toString());
        eleitor.setDataNasc(etDataNasc.getText().toString());
        eleitor.setNumeroTit(etNumeroTit.getText().toString());
        eleitor.setZona((etZona.getText().toString()));
        eleitor.setSecao((etSecao.getText().toString()));
        eleitor.setMunicipio((etMunicipio.getText().toString()));


        try {
            eleitor.setDataNasc((Date) formato.parse(etData.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    public void alterar() {

        realm.beginTransaction();

        setEGrava(eleitor);

        realm.copyToRealm(eleitor);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Eleitor Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }

}
