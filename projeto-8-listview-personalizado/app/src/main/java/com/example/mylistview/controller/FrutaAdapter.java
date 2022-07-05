package com.example.mylistview.controller;

import android.content.Context;
import android.icu.math.BigDecimal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylistview.R;
import com.example.mylistview.model.Fruta;
import com.example.mylistview.model.Frutas;

import java.text.DecimalFormat;
import java.util.ArrayList;
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

        TextView tvCodigo = convertView.findViewById(R.id.tvCodigo);
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        TextView tvPreco = convertView.findViewById(R.id.tvPreco);
        TextView tvPrecoVenda = convertView.findViewById(R.id.tvPrecoVenda);
        ImageView imageView2 = convertView.findViewById(R.id.imageView2);

        Fruta fruta =(Fruta) getItem(position);

        DecimalFormat format = new DecimalFormat("#,###,00");
        tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        tvPreco.setText(format.format(fruta.getPreco()));
        tvPrecoVenda.setText(format.format(fruta.getPreco_venda()));
        imageView2.setImageResource(fruta.getImagem());


        return convertView;
    }
}
