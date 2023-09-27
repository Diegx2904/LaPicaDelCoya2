package com.example.portada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void InicioSesion(View view){
        Intent iniciosesion = new Intent(this, MainInicioSesion.class);
        startActivity(iniciosesion);
    }
    public void continuarSinSesion(View view){
        Intent sinsesion = new Intent(this, MainInicioSinSesion.class);
        startActivity(sinsesion);
    }
}