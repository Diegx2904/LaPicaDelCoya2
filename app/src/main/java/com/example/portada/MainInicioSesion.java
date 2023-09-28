package com.example.portada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainInicioSesion extends AppCompatActivity {

    EditText email,contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio_sesion);
        email=(EditText)findViewById(R.id.emailSesion);
        contraseña=(EditText)findViewById(R.id.contraseñaSesion);
    }
    public boolean validar(){
        boolean retorno=true;
        String c1 = email.getText().toString();
        String c2 = contraseña.getText().toString();

        if(c1.isEmpty()){
            email.setError("Este campo no puede estar vacio ");
            retorno=false;
        }
        if(c2.isEmpty()){
            contraseña.setError("Este campo no puede estar vacio ");
            retorno=false;
        }
        return retorno;
    }
    public void Iniciar(View view){
        if(validar()){
            Toast.makeText(this,"Iniciado Correctamente",Toast.LENGTH_SHORT).show();
            Intent iniciar = new Intent(this, MainInicioSinSesion.class);
            startActivity(iniciar);
        }
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