package com.example.samsung.appcidadao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.samsung.appcidadao.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{




    private RadioGroup rgCidadao;
    private RadioButton rbEleitor;
    private RadioButton rbCandidato;
    private ImageView imgCidadao;
    private Integer []imagens = { R.drawable.cidadao};
    private Button btAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imgCidadao = (ImageView) findViewById(R.id.imgCidadao);
        this.rgCidadao = (RadioGroup) findViewById(R.id.rgCidadao);
        this.rgCidadao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                imgCidadao.setImageResource(imagens[index]);
            }
        });

        final RadioButton rbEleitor = (RadioButton) findViewById(R.id.rbEleitor);
        final RadioButton rbCandidato = (RadioButton) findViewById(R.id.rbCandidato);
        this.btAdd = (Button) findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
                if (rbEleitor.isChecked() == true) {
                    Toast.makeText(getBaseContext(), "O Cidadao é um Eleitor!", Toast.LENGTH_SHORT).show();
                } else if (rbCandidato.isChecked() == true) {
                    Toast.makeText(getBaseContext(), "O Cidadao é um Candidato!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
