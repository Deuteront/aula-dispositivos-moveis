package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText pesoTV;
    EditText alturaTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Ciclo de Vida Activity ", "onCreate ");
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo de Vida Activity ", "onStart ");
    }

    public void calcularImc(View view){
        pesoTV = (EditText)findViewById(R.id.altura);
        alturaTV = (EditText)findViewById(R.id.peso);
        
        Intent i = new Intent(this,CalcularImc.class);
        String peso=pesoTV.getText().toString();
        String altura=alturaTV.getText().toString();
        i.putExtra("pesoTV",peso);
        i.putExtra("alturaTV",altura);
        startActivity(i);


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo de Vida Activity ", "onResume ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo de Vida Activity ", "onPause ");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo de Vida Activity ", "onRestart ");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo de Vida Activity ", "onStop ");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo de Vida Activity ", "onDestroy ");
    }


}