package com.example.portada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity {
    EditText Usuario,contraseñaNueva,confirmacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        Usuario=(EditText)findViewById(R.id.nombreUsuario);
        contraseñaNueva=(EditText)findViewById(R.id.contraseñaRegistro);
        confirmacion=(EditText)findViewById(R.id.confirmarContraseña);
    }
    public boolean validar(){
        boolean retorno=true;
        String c1 = Usuario.getText().toString();
        String c2 = contraseñaNueva.getText().toString();
        String c3 = confirmacion.getText().toString();

        if(c1.isEmpty()){
            Usuario.setError("Este campo no puede estar vacio ");
            retorno=false;
        }
        if(c2.isEmpty()){
            contraseñaNueva.setError("Este campo no puede estar vacio ");
            retorno=false;
        }
        if(c3.isEmpty()){
            confirmacion.setError("Este campo no puede estar vacio ");
            retorno=false;
        }
        return retorno;
    }
    public void Registrarse(View view){
        if(validar()){
            Toast.makeText(this,"Registrado",Toast.LENGTH_SHORT).show();
            Intent registrarse = new Intent(this,MainInicioSesion.class);
            startActivity(registrarse);
        }
    }
    public void Volver(View view){
        Intent volver = new Intent(this, MainInicioSesion.class);
        startActivity(volver);
    }
}