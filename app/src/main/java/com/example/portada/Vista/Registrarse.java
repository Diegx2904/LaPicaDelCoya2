package com.example.portada.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.portada.Controlador.ConexionHelper;
import com.example.portada.Controlador.Utility;
import com.example.portada.R;

public class Registrarse extends AppCompatActivity {
    EditText correo,contraseña;
    Button registro;
    ImageView volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        correo=(EditText)findViewById(R.id.txtEmail2);
        contraseña=(EditText)findViewById(R.id.txtContraseña2);
        registro=(Button)findViewById(R.id.btnRegistro);
        volver=(ImageView) findViewById(R.id.imgVolver);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuarios();
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registrarse.this, MainInicioSesion.class);
                startActivity(intent);
            }
        });
    }
    private void registrarUsuarios(){
        ConexionHelper conn = new ConexionHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utility.CAMPO_CORREO,correo.getText().toString());
        contentValues.put(Utility.CAMPO_CONTRASEÑA,contraseña.getText().toString());

        Long idResultante = db.insert(Utility.TABLA_USUARIO,Utility.CAMPO_ID, contentValues);
        Toast.makeText(getApplicationContext(),"Registrado",Toast.LENGTH_SHORT).show();
        db.close();
    }
    private void registrarUsuariosSql(){
        ConexionHelper conn = new ConexionHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String insert = "INSERT INTO"+Utility.TABLA_USUARIO+"("+Utility.CAMPO_ID+","+Utility.CAMPO_CORREO+","+Utility.CAMPO_CONTRASEÑA+")"+
                " VALUES ("+correo.getText().toString()+"','"+contraseña.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Registrado", Toast.LENGTH_SHORT).show();
        db.close();
    }
}