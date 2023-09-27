package com.example.portada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Registrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }
    public void Registrarse(View view){
        Intent registrarse = new Intent(this,MainInicioSesion.class);
        startActivity(registrarse);
    }
    public void Volver(View view){
        Intent volver = new Intent(this, MainInicioSesion.class);
        startActivity(volver);
    }
}