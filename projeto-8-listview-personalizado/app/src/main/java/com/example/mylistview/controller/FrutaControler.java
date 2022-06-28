package com.example.mylistview.controller;

import com.example.mylistview.model.Fruta;
import com.example.mylistview.model.Frutas;

import java.util.ArrayList;

public class FrutaControler {
    Frutas frutasPersitence ;
    public FrutaControler() {
        frutasPersitence=new Frutas();
    }
    public Fruta[] getFrutas() {
        return frutasPersitence.FRUTAS;
    }
    public ArrayList<String>  getNomesFrutas(){
        ArrayList<String> nomesFrutras = new ArrayList<String>();
        for (Fruta fruta : this.getFrutas()) {
            nomesFrutras.add(fruta.getNome());
        }
        return nomesFrutras;
    }
}
