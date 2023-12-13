package com.example.portada.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.portada.Modelo.Pedido;
import com.example.portada.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class menuChorrillana extends AppCompatActivity {
    RadioButton domicilio, tienda;
    ImageView volver;
    CheckBox bbq, ketchup, mostaza, mayonesa;
    Button agregar, cancelar, calcular;
    TextView totalFinal;
    ListView lvDatos;
    private DatabaseReference databaseReference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_chorrillana);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("pedidos");
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        domicilio = findViewById(R.id.rbDomicilio);
        tienda = findViewById(R.id.rbRTienda);
        bbq = findViewById(R.id.cbBbq);
        ketchup = findViewById(R.id.cbKetchup);
        mostaza = findViewById(R.id.cbMostaza);
        mayonesa = findViewById(R.id.cbMayonesa);
        agregar = findViewById(R.id.btnAgregarChorrillana);
        cancelar = findViewById(R.id.btnCancelar);
        calcular = findViewById(R.id.btnCalcular);
        totalFinal = findViewById(R.id.txtTotal);
        volver = findViewById(R.id.imgVolver);
        lvDatos = findViewById(R.id.lvDatos);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bbq.setChecked(false);
                ketchup.setChecked(false);
                mostaza.setChecked(false);
                mayonesa.setChecked(false);
                domicilio.setChecked(false);
                tienda.setChecked(false);
                totalFinal.setText("Total:");

                eliminarPedido();

                Toast.makeText(menuChorrillana.this, "Pedido cancelado", Toast.LENGTH_SHORT).show();
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = 4000;
                if (bbq.isChecked())
                    total += 100;
                if (ketchup.isChecked())
                    total += 100;
                if (mostaza.isChecked())
                    total += 100;
                if (mayonesa.isChecked())
                    total += 100;

                if (domicilio.isChecked())
                    total += 2500;
                else if (tienda.isChecked())
                    total += 0;

                totalFinal.setText("Total:" + total);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = 4000;
                if (bbq.isChecked())
                    total += 100;
                if (ketchup.isChecked())
                    total += 100;
                if (mostaza.isChecked())
                    total += 100;
                if (mayonesa.isChecked())
                    total += 100;

                if (domicilio.isChecked())
                    total += 2500;
                else if (tienda.isChecked())
                    total += 0;

                DatabaseReference userOrderReference = databaseReference.child(userID).push();
                userOrderReference.child("total").setValue(total);
                userOrderReference.child("bbq").setValue(bbq.isChecked());
                userOrderReference.child("ketchup").setValue(ketchup.isChecked());
                userOrderReference.child("mostaza").setValue(mostaza.isChecked());
                userOrderReference.child("mayonesa").setValue(mayonesa.isChecked());
                userOrderReference.child("domicilio").setValue(domicilio.isChecked());

                Toast.makeText(menuChorrillana.this, "Pedido agregado", Toast.LENGTH_SHORT).show();
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuChorrillana.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }
    private void eliminarPedido() {
        DatabaseReference userOrderReference = databaseReference.child(userID);
        userOrderReference.removeValue();
    }

}

