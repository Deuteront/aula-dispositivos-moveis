package com.example.mylistview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mylistview.controller.FrutaControler;
import com.example.mylistview.model.Fruta;
import com.example.mylistview.model.Frutas;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimpleListView extends AppCompatActivity {
    FrutaControler frutaControler;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        frutaControler = new FrutaControler();

        //Carregar o ListView
        listView= findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                frutaControler.getNomesFrutas()
                );

        //Setar o adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Frutas frutas = new Frutas();
                parent.getAdapter().getItem(position);
                Fruta fruta = Arrays.stream(frutas.FRUTAS.clone()).collect(Collectors.toList()).get(position);
                Intent i = new Intent(SimpleListView.this, ExibeFruta.class);
                i.putExtra("codigoFruta", fruta.getCodigo());
                startActivity(i);
            }
        });
    }

}