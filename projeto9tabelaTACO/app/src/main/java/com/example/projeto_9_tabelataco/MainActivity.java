package com.example.projeto_9_tabelataco;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projeto_9_tabelataco.controller.FrutaAdapter;
import com.example.projeto_9_tabelataco.controller.AlimentoControler;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase sqLiteDatabase;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabelaTacoInserts tabelaTacoInserts = new TabelaTacoInserts();
        sqLiteDatabase = this.openOrCreateDatabase("taco", getBaseContext().MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `taco_4___edicao` (\n" +
                "  `id` int DEFAULT NULL,\n" +
                "  `Caterogia` varchar(37) DEFAULT NULL,\n" +
                "  `Alimento` varchar(64) DEFAULT NULL,\n" +
                "  `Umidade` varchar(4) DEFAULT NULL,\n" +
                "  `Energiakcal` varchar(3) DEFAULT NULL,\n" +
                "  `kJ` varchar(4) DEFAULT NULL,\n" +
                "  `Proteonag` varchar(4) DEFAULT NULL,\n" +
                "  `Lipodeosg` varchar(5) DEFAULT NULL,\n" +
                "  `Colesterolmg` varchar(4) DEFAULT NULL,\n" +
                "  `Carboidratosg` varchar(4) DEFAULT NULL,\n" +
                "  `FibraAlimentarg` varchar(4) DEFAULT NULL,\n" +
                "  `Cinzasg` varchar(4) DEFAULT NULL,\n" +
                "  `Calciomg` varchar(4) DEFAULT NULL,\n" +
                "  `Magnesiomg` varchar(3) DEFAULT NULL,\n" +
                "  `Manganesmg` varchar(5) DEFAULT NULL,\n" +
                "  `Fósforomg` varchar(4) DEFAULT NULL,\n" +
                "  `Ferromg` varchar(4) DEFAULT NULL,\n" +
                "  `Sódiomg` varchar(5) DEFAULT NULL,\n" +
                "  `Potassiomg` varchar(5) DEFAULT NULL,\n" +
                "  `Cobremg` varchar(5) DEFAULT NULL,\n" +
                "  `Zincomg` varchar(4) DEFAULT NULL,\n" +
                "  `Retinolmcg` varchar(5) DEFAULT NULL,\n" +
                "  `REmcg` varchar(5) DEFAULT NULL,\n" +
                "  `RAEmcg` varchar(5) DEFAULT NULL,\n" +
                "  `Tiaminamg` varchar(4) DEFAULT NULL,\n" +
                "  `Riboflavinamg` varchar(4) DEFAULT NULL,\n" +
                "  `Piridoxinamg` varchar(5) DEFAULT NULL,\n" +
                "  `Niacinamg` varchar(5) DEFAULT NULL,\n" +
                "  `VitaminaCmg` varchar(5) DEFAULT NULL)");

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT id FROM `taco_4___edicao` WHERE id = 1",null);
        cursor.moveToFirst();
        if (!(cursor.getInt(0) == 1)){
            sqLiteDatabase.execSQL(tabelaTacoInserts.getInsert1());
            sqLiteDatabase.execSQL(tabelaTacoInserts.getIntert2());
            sqLiteDatabase.execSQL(tabelaTacoInserts.getInsert3());

        }

        carregarListaBySql("SELECT Caterogia,Alimento FROM `taco_4___edicao`");

    }

    private void carregarListaBySql(String sqlPesquisa) {
        AlimentoControler alimentoControler = new AlimentoControler();
        alimentoControler.setAlimentos(sqLiteDatabase.rawQuery(sqlPesquisa,null));
        //Carregar o ListView
        listView= findViewById(R.id.listView);

        FrutaAdapter adapter = new FrutaAdapter(
                getApplicationContext(),
                R.layout.list_item_frut,
                alimentoControler.getAlimentos()
        );
        //Setar o adaptador
        listView.setAdapter(adapter);
    }


    public void filtrar(View view){
        EditText editText = findViewById(R.id.evFiltrar);
        carregarListaBySql("SELECT Caterogia,Alimento FROM `taco_4___edicao` WHERE  Alimento LIKE '%"+editText.getText()+"%'");
    }
}