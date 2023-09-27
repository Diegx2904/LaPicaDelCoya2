package com.example.portada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainInicioSinSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio_sin_sesion);
    }
    public void Volver(View view){
        Intent volver = new Intent(this,MainActivity.class);
        startActivity(volver);
    }
}