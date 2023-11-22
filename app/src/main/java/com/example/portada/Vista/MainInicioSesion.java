package com.example.portada.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.graphics.vector.PathNode;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.portada.Controlador.ConexionHelper;
import com.example.portada.Controlador.Utility;
import com.example.portada.R;

public class MainInicioSesion extends AppCompatActivity {

    EditText correo,contraseña;
    Button iniciar, registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio_sesion);
        correo=(EditText)findViewById(R.id.txtEmail);
        contraseña=(EditText)findViewById(R.id.txtContraseña);
        iniciar=(Button)findViewById(R.id.btn_iniciar);
        registrarse=(Button)findViewById(R.id.btnRegistrarse);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar();
            }
        });
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainInicioSesion.this,Registrarse.class);
                startActivity(intent);
            }
        });
    }
    public void ingresar(){
        try {
            ConexionHelper conn = new ConexionHelper(this,"bd_usuarios",null,1);
            SQLiteDatabase bd = conn.getWritableDatabase();
            String[] parametros = {correo.getText().toString(),contraseña.getText().toString()};
            Cursor cursor = bd.rawQuery("SELECT " + Utility.CAMPO_CORREO + "," + Utility.CAMPO_CONTRASEÑA +
                    " FROM " + Utility.TABLA_USUARIO + " WHERE " + Utility.CAMPO_CORREO + " AND " + Utility.CAMPO_CONTRASEÑA + " =? "  , parametros);

            if (cursor == correo || cursor == contraseña){
                Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Correo o contraseña incorrecta",
                        Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Correo o contraseña incorrecta",
                    Toast.LENGTH_LONG).show();
            }
    }
}