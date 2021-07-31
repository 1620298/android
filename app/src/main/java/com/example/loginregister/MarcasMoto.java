package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MarcasMoto extends AppCompatActivity {

    Button btnMotoMarcaA,btnMotoMarcaB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas_moto);


        btnMotoMarcaA=findViewById(R.id.btnMotoMarcaA);
        btnMotoMarcaB=findViewById(R.id.btnMotoMarcaB);


        btnMotoMarcaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        String[] field = new String[2];
                        field[0] = "tipo";
                        field[1] = "marca";

                        String[] data = new String[2];
                        data[0] = "Moto";
                        data[1] = "A";

                        PutData putData = new PutData("http://192.168.1.33/LoginRegister/register.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {

                                String result = putData.getResult();
                                if (result.equals("Registro Success"))
                                {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }

                    }
                });
            }
        });

        btnMotoMarcaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        String[] field = new String[2];
                        field[0] = "tipo";
                        field[1] = "marca";

                        String[] data = new String[2];
                        data[0] = "Moto";
                        data[1] = "B";

                        PutData putData = new PutData("http://localhost/LoginRegister/register.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {

                                String result = putData.getResult();
                                if (result.equals("Registro Success"))
                                {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }

                    }
                });
            }
        });
    }
}