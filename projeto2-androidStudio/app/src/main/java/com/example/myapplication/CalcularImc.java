package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcularImc  extends AppCompatActivity {
    TextView pesoTV;
    TextView alturaTV;
    TextView nomeTV;
    TextView imcTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        Bundle bundle = getIntent().getExtras();
        double peso = Double.parseDouble(bundle.getString("pesoTV"));
        double altura =Double.parseDouble(bundle.getString("alturaTV"));
         pesoTV = (TextView)findViewById(R.id.pesoTV);
         alturaTV = (TextView)findViewById(R.id.alturaTV);
         nomeTV = (TextView)findViewById(R.id.nomeTV);
         imcTV = (TextView)findViewById(R.id.imc);
         pesoTV.setText(Double.toString(peso));
        alturaTV.setText(Double.toString(altura));
        nomeTV.setText("Paulo Henrique dos Santos");
        double imc = (peso/(altura*altura));
        imcTV.setText(Double.toString(imc));

    }
}
