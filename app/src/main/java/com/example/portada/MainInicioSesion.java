package com.example.portada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainInicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio_sesion);
    }
    public void Iniciar(View view){
        Intent iniciar = new Intent(this, MainInicioSinSesion.class);
        startActivity(iniciar);
    }
    public void Registrarse(View view){
        Intent registrarse = new Intent(this,Registrarse.class);
        startActivity(registrarse);
    }
    public void Facebook(View view){
        String url ="https://web.facebook.com/?locale=es_LA&_rdc=1&_rdr";
        Intent facebook = new Intent(Intent.ACTION_VIEW);
        facebook.setData(Uri.parse(url));
        startActivity(facebook);
    }
    public void Volver(View view){
        Intent volver = new Intent(this,MainActivity.class);
        startActivity(volver);
    }
}