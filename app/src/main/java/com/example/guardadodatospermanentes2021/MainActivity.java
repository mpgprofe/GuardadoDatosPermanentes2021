package com.example.guardadodatospermanentes2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText editTextNombre,editTextEdad;
Button buttonBorrar, buttonGuardar, buttonRecuperar;

static  final String NOMBRE_FICHERO = "DATOS";
static final String NOMBRE = "NOMBRE";
static final String EDAD = "EDAD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.editTextNombre);
        buttonBorrar = findViewById(R.id.buttonBorrar);
        buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonRecuperar = findViewById(R.id.buttonRecuperar);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misDatos = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                SharedPreferences.Editor editor = misDatos.edit();
                editor.putString(NOMBRE,editTextNombre.getText().toString());
                editor.apply();
            }
        });

        buttonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misDatos = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                editTextNombre.setText(misDatos.getString(NOMBRE,"-- sin guardar --"));
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                SharedPreferences misDatos = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                SharedPreferences.Editor editor = misDatos.edit();
                editor.clear();
                editor.apply();
                */
                getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE).edit().clear().apply();


            }
        });

    }
}