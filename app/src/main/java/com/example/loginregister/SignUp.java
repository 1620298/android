package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword, textInputEditTextFirstname, textInputEditTextLastname, textInputEditTextDni, textInputEditTextFecnac, textInputEditTextDireccion, textInputEditTextTelefono;
    Button buttonSignUp;
    TextView textViewLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextFirstname = findViewById(R.id.firstname);
        textInputEditTextLastname = findViewById(R.id.lastname);
        textInputEditTextDni = findViewById(R.id.dni);
        textInputEditTextFecnac = findViewById(R.id.fecnac);
        textInputEditTextDireccion = findViewById(R.id.direccion);
        textInputEditTextTelefono = findViewById(R.id.telefono);




        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewLogin = findViewById(R.id.loginText);

        progressBar=findViewById(R.id.progress);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username, password, firstname, lastname, dni, fecnac, direccion, telefono;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                firstname = String.valueOf(textInputEditTextFirstname.getText());
                lastname = String.valueOf(textInputEditTextLastname.getText());
                dni = String.valueOf(textInputEditTextDni.getText());
                fecnac = String.valueOf(textInputEditTextFecnac.getText());
                direccion = String.valueOf(textInputEditTextDireccion.getText());
                telefono = String.valueOf(textInputEditTextTelefono.getText());

                if (!username.equals("") && !password.equals("") && !firstname.equals("") && !lastname.equals("") && !dni.equals("")) {

                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[5];
                            field[0] = "username";
                            field[1] = "password";
                            field[2] = "firstname";
                            field[3] = "lastname";
                            field[4] = "dni";
                            field[5] = "fecnac";
                            field[6] = "direccion";
                            field[7] = "telefono";



                            String[] data = new String[5];
                            data[0] = username;
                            data[1] = password;
                            data[2] = firstname;
                            data[3] = lastname;
                            data[4] = dni;
                            data[5] = fecnac;
                            data[6] = direccion;
                            data[7] = telefono;


                            PutData putData = new PutData("http://192.168.1.33/LoginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(), Login.class);
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
                else
                {
                    Toast.makeText(getApplicationContext(), "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
