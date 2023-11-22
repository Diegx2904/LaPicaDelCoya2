package com.example.portada.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.portada.R;
import com.example.portada.Vista.MenuPrincipal;

public class menuChurrasco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_churrasco);
    }
    public void Volver(View view){
        Intent volver = new Intent(this, MenuPrincipal.class);
        startActivity(volver);
    }
}