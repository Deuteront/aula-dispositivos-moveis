package com.example.projeto_5_paint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    SimplePaint simplePaint;
    ImageView ivColorPicker;
    Button BtUndo;
    Button BtUndoAll;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplePaint = findViewById(R.id.simplePaint);
        initUndoAll();
        initUndo();
        initColorPicker();
        initDropDown();

    }

    private void initUndoAll() {
        BtUndoAll = findViewById(R.id.undoAll);
        BtUndoAll.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                undoAll();
            }
        });
    }

    private void initUndo() {
        BtUndo = findViewById(R.id.undo);
        BtUndo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                undo();
            }
        });
    }

    private void initDropDown() {
        dropdown = findViewById(R.id.typePaint);
        String[] items = new String[]{DrawEnum.LINHA.name(), DrawEnum.CIRCULO.name(), DrawEnum.QUADRADO.name()};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                if(parent.getItemAtPosition(pos)!=null){
                    changeGeometric(String.valueOf(parent.getItemAtPosition(pos)));

                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    private void initColorPicker() {
        ivColorPicker = findViewById(R.id.colorPicker);
        ivColorPicker.setColorFilter(Color.RED);
        ivColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorPickerSelectColor();
            }
        });
    }

    public void colorPickerSelectColor(){
        new ColorPickerDialog.Builder(this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton("Confirmar",
                        new ColorEnvelopeListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                setLayoutColor(envelope);
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true)  // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                .show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setLayoutColor(ColorEnvelope layoutColor){
        simplePaint.setColor(Color.valueOf(layoutColor.getColor()));
        ivColorPicker.setColorFilter(Color.valueOf(layoutColor.getColor()).toArgb());

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void changeGeometric(String geometricForm){
        simplePaint.setGeometricForm(geometricForm);

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void undo(){
        simplePaint.undo();

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void undoAll(){
        simplePaint.undoAll();
    }
}