package com.example.samsung.appcidadao.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samsung.appcidadao.R;
import com.example.samsung.appcidadao.model.Eleitor;

import java.util.List;

/**
 * Created by Samsung on 02/07/2018.
 */

public class EleitorAdapter extends RecyclerView.Adapter {

        private List<Eleitor> eleitor;
        private Context context;
        private static ClickRecyclerViewListener clickRecyclerViewListener;

    public
        EleitorAdapter(List<Eleitor> eleitor, Context context, ClickRecyclerViewListener clickRecyclerViewListener)
        {
            this.eleitor = eleitor;
            this.context = context;
            this.clickRecyclerViewListener = clickRecyclerViewListener;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_eleitor_cv, parent, false);
        EleitorViewHolder eleitorViewHolder = new EleitorViewHolder(view);
        return eleitorViewHolder;
    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onBindViewHolder (RecyclerView.ViewHolder viewHolder,int position){

        EleitorViewHolder eleitorHolder = (EleitorViewHolder) viewHolder;

        Eleitor eleitor = this.eleitor.get(position);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        eleitorHolder.nomeEleitor.setText(eleitor.getNome());
        eleitorHolder.nomeMaeEleitor.setText(eleitor.getNomeMae());
        eleitorHolder.dataNascEleitor.setText(eleitor.getDataNasc());
        eleitorHolder.numeroTitEleitor.setText(eleitor.getNumeroTit());
        eleitorHolder.zonaEleitor.setText(eleitor.getZona());
        eleitorHolder.secaoEleitor.setText(eleitor.getSecao());
        eleitorHolder.municipioEleitor.setText(eleitor.getMunicipio());


    }

        @Override
        public int getItemCount () {
        return eleitor.size();
    }

        public class EleitorViewHolder extends RecyclerView.ViewHolder {

            private final TextView nomeEleitor;
            private final TextView nomeMaeEleitor;
            private final TextView dataNascEleitor;
            private final TextView numeroTitEleitor;
            private final TextView zonaEleitor;
            private final TextView secaoEleitor;
            private final TextView municipioEleitor;


            public EleitorViewHolder(View itemView) {
                super(itemView);
                nomeEleitor = (TextView) itemView.findViewById(R.id.tvNomeEleitor);
                nomeMaeEleitor = (TextView) itemView.findViewById(R.id.tvNomeMaeEleitor);
                dataNascEleitor = (TextView) itemView.findViewById(R.id.tvDataNascEleitor);
                numeroTitEleitor = (TextView) itemView.findViewById(R.id.tvNumeroTitEleitor);
                zonaEleitor = (TextView) itemView.findViewById(R.id.tvZonaEleitor);
                municipioEleitor = (TextView) itemView.findViewById(R.id.tvMunicipioEleitor);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickRecyclerViewListener.onClick(eleitor.get(getLayoutPosition()));

                    }
                });


            }
        }
    }