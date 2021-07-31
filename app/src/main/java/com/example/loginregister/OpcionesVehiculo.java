package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OpcionesVehiculo extends AppCompatActivity {
    Button btnAuto,btnCamioneta,btnMoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_vehiculo);


        btnAuto=findViewById(R.id.btnAuto);
        btnCamioneta=findViewById(R.id.btnCamioneta);
        btnMoto=findViewById(R.id.btnMoto);

        btnAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), MarcasAuto.class);
                startActivity(intent);
                finish();
            }
        });

        btnCamioneta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), MarcasCamioneta.class);
                startActivity(intent);
                finish();
            }
        });

        btnMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), MarcasMoto.class);
                startActivity(intent);
                finish();
            }
        });



    }
}