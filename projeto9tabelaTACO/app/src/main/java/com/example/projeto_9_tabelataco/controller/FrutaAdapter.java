package com.example.projeto_9_tabelataco.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projeto_9_tabelataco.R;
import com.example.projeto_9_tabelataco.model.Alimento;

import java.text.DecimalFormat;
import java.util.List;

public class FrutaAdapter extends ArrayAdapter {
    Context mContext;
    int mRecurso;


    public FrutaAdapter(Context applicationContext, int list_item_frut, List collect) {
        super(applicationContext, list_item_frut, collect);
        this.mContext = applicationContext;
        this.mRecurso = list_item_frut;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mRecurso,parent,false);

        TextView tvCategoria = convertView.findViewById(R.id.tvCaterogia);
        TextView tvAlimento = convertView.findViewById(R.id.tvAlimento);

        Alimento fruta = (Alimento) getItem(position);

        DecimalFormat format = new DecimalFormat("#,###,00");
        tvCategoria.setText(fruta.getCaterogia());
        tvAlimento.setText(fruta.getAlimento());

        return convertView;
    }
}
