package com.example.portada.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.portada.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registrarse extends AppCompatActivity {
    EditText correo,contraseña;
    Button registro;
    ImageView volver;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        correo=(EditText)findViewById(R.id.txtEmail2);
        contraseña=(EditText)findViewById(R.id.txtContraseña2);
        registro=(Button)findViewById(R.id.btnRegistro);
        volver=(ImageView) findViewById(R.id.imgVolver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registrarse.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(correo.getText());
                password = String.valueOf(contraseña.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Registrarse.this,"Ingrese un correo",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Registrarse.this,"Ingrese una contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Registrarse.this,"Registrado",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Registrarse.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(Registrarse.this,"Registro fallido",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}