package com.example.projeto_9_tabelataco.controller;


import android.database.Cursor;

import com.example.projeto_9_tabelataco.model.Alimento;

import java.util.ArrayList;

public class AlimentoControler {
    private final ArrayList<Alimento> alimentos;

    public AlimentoControler(){
        alimentos = new ArrayList<>();
    }

    public void setAlimentos(Cursor alimentosCursor){
        alimentosCursor.moveToFirst();
        while (!alimentosCursor.isAfterLast()){
            Alimento alimento = new Alimento();
            alimento.setCaterogia(alimentosCursor.getString(0));
            alimento.setAlimento(alimentosCursor.getString(1));
            alimentos.add(alimento);
            alimentosCursor.moveToNext();
        }

    }

    public ArrayList<Alimento> getAlimentos(){
        return alimentos;
    }


}
