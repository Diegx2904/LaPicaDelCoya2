package com.example.portada.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.graphics.vector.PathNode;

import android.content.Intent;
import android.database.Cursor;
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

public class MainInicioSesion extends AppCompatActivity {

    EditText correo,contraseña;
    Button iniciar, registrarse;
    ImageView volver;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio_sesion);
        correo=(EditText)findViewById(R.id.txtEmail);
        contraseña=(EditText)findViewById(R.id.txtContraseña);
        iniciar=(Button)findViewById(R.id.btn_iniciar);
        registrarse=(Button)findViewById(R.id.btnRegistrarse);
        volver = findViewById(R.id.imgVolver);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainInicioSesion.this, Registrarse.class);
                startActivity(intent);
                finish();
            }
        });
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(correo.getText());
                password = String.valueOf(contraseña.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(MainInicioSesion.this,"Ingrese un correo",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MainInicioSesion.this,"Ingrese una contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(MainInicioSesion.this,"Iniciado Correctamente",Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(MainInicioSesion.this, MenuPrincipal.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(MainInicioSesion.this,"Autenticacion Fallo",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainInicioSesion.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}