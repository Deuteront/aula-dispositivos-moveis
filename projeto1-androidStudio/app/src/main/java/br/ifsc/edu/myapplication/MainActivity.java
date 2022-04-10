package br.ifsc.edu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    TextView numeroSorteadoTV;
    EditText numero1TV;
    EditText numero2TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroSorteadoTV = (TextView)findViewById(R.id.numeroSorteado);
        numero1TV = (EditText)findViewById(R.id.numero);
        numero2TV = (EditText)findViewById(R.id.numero2);
    }

    public void sortear(View v){
        try {
            ThreadLocalRandom tlr = ThreadLocalRandom.current();

            int min_val;
            int max_val;

            int numero1 =Integer.parseInt(numero2TV.getText().toString());
            int numero2 =Integer.parseInt(numero1TV.getText().toString());
            if(numero2>numero1){
                min_val = numero1;
                max_val =numero2;

            }else{
                min_val =numero2;
                max_val = numero1;
            }

            int randomNum = tlr.nextInt(min_val, max_val + 1);
            numeroSorteadoTV.setText(String.format("%d", randomNum));

        }catch (Exception e){
            numeroSorteadoTV.setText("FOI NÃO");

        }


    }
}
