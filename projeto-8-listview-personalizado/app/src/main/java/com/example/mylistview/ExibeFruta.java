package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylistview.model.Fruta;
import com.example.mylistview.model.Frutas;

import java.text.DecimalFormat;

public class ExibeFruta extends AppCompatActivity {
    Fruta fruta;
    TextView textViewNomeFruta;
    ImageView imageViewFruta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_fruta);
        Frutas frutas = new Frutas();
        Bundle extras = getIntent().getExtras();


        textViewNomeFruta=findViewById(R.id.textViewNome);
        imageViewFruta=findViewById(R.id.imageView);
        fruta = frutas.FRUTA_MAP.get(extras.get("codigoFruta").toString());
        System.out.println(fruta);
        imageViewFruta.setImageResource(fruta.getImagem());
        textViewNomeFruta.setText(fruta.getNome());


    }




}