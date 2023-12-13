package com.example.portada.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.portada.R;

public class MenuPrincipal extends AppCompatActivity {
    Button Mapabtn;
    ImageView imgChurrasco, imgCompleto, imgChorrillana, imgVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        imgChurrasco = findViewById(R.id.imgChurrasco);
        imgCompleto = findViewById(R.id.imgCompleto);
        imgChorrillana = findViewById(R.id.imgChorrillana);
        imgVolver = findViewById(R.id.imgVolver);
        Mapabtn = findViewById(R.id.MapaBoton);
        Mapabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, MapaDeUbicacion.class);
                startActivity(intent);
            }
        });
        imgChurrasco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, menuChurrasco.class);
                startActivity(intent);
            }
        });
        imgCompleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, menuCompleto.class);
                startActivity(intent);
            }
        });
        imgChorrillana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, menuChorrillana.class);
                startActivity(intent);
            }
        });
        imgVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, MainInicioSesion.class);
                startActivity(intent);
            }
        });
    }
}