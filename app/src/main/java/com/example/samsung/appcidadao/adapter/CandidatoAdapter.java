package com.example.samsung.appcidadao.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.samsung.appcidadao.R;

/**
 * Created by Samsung on 02/07/2018.
 */

public class CandidatoAdapter extends RecyclerView.Adapter {

    private List<Candidato> candidato;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public
    CandidatoAdapter(List < Candidato > candidato, Context context, ClickRecyclerViewListener clickRecyclerViewListener)
    {
        this.candidato = candidato;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent,int viewType){

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_candidato_cv, parent, false);
        CandidatoAdapter.CandidatoViewHolder candidatoViewHolder = new CandidatoAdapter.CandidatoViewHolder(view);
        return candidatoViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder viewHolder,int position){

        CandidatoAdapter.CandidatoViewHolder candidatoHolder = (CandidatoAdapter.CandidatoViewHolder) viewHolder;

        Candidato candidato = this.candidato.get(position);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        candidatoHolder.nomeCandidato.setText(candidato.getNome());
        candidatoHolder.partidoCandidato.setText(candidato.getPartidoCandidato());
        candidatoHolder.numeroUrnaCandidato.setText(candidato.getNumeroUrnaCandidato());
        candidatoHolder.cargoCandidato.setText(candidato.getCargooCandidato());
        candidatoHolder.numeroVotosCandidato.setText(candidato.getNumeroVotosCandidato());
        candidatoHolder.estadoCandidato.setText(candidato.getEstadooCandidato());
        candidatoHolder.municipioCandidato.setText(candidato.getMunicipioCandidato());


    }

    @Override
    public int getItemCount () {
        return candidato.size();
    }

    public class CandidatoViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeCandidato;
        private final TextView partidoCandidato;
        private final TextView numeroUrnaCandidato;
        private final TextView cargoCandidato;
        private final TextView numeroVotosCandidato;
        private final TextView estadoCandidato;
        private final TextView municipioCandidato;

        private final TextView capacidadeCandidato;


        public CandidatoViewHolder(View itemView) {
            super(itemView);
            nomeCandidato = (TextView) itemView.findViewById(R.id.tvNomeCandidato);
            partidoCandidato = (TextView) itemView.findViewById(R.id.tvPartidoCandidato);
            numeroUrnaCandidato = (TextView) itemView.findViewById(R.id.tvNumeroUrnaCandidato);
            cargoCandidato = (TextView) itemView.findViewById(R.id.tvCargoCandidato);
            numeroVotosCandidato = (TextView) itemView.findViewById(R.id.tvNumeroVotosCandidato);
            estadoCandidato = (TextView) itemView.findViewById(R.id.tvEstadoCandidato);
            municipioCandidato = (TextView) itemView.findViewById(R.id.tvMunicipioCandidato);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(candidato.get(getLayoutPosition()));

                }
            });


        }
    }
}