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

import com.example.mylistview.controller.FrutaAdapter;
import com.example.mylistview.controller.FrutaControler;
import com.example.mylistview.model.Fruta;
import com.example.mylistview.model.Frutas;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimpleListView extends AppCompatActivity {
    FrutaControler frutaControler;
    ListView listView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        frutaControler = new FrutaControler();
        Frutas frutas = new Frutas();

        //Carregar o ListView
        listView= findViewById(R.id.listView);

        FrutaAdapter adapter = new FrutaAdapter(
                getApplicationContext(),
                R.layout.list_item_frut,
                Arrays.stream(frutas.FRUTAS.clone()).collect(Collectors.toList())
        );
        //Setar o adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.getAdapter().getItem(position);
                Fruta fruta = Arrays.stream(frutas.FRUTAS.clone()).collect(Collectors.toList()).get(position);
                Intent i = new Intent(SimpleListView.this, ExibeFruta.class);
                i.putExtra("codigoFruta", fruta.getCodigo());
                startActivity(i);
            }
        });
    }

}