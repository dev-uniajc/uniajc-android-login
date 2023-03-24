package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private String passSuccess = "12";
    private String userSuccess = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.idUsername);
        password = findViewById(R.id.idPassword);
    }

    public void Auth(View v){
        Boolean validUser = username.getText().toString().equalsIgnoreCase(userSuccess);
        Boolean validPass = password.getText().toString().equals(passSuccess);

        if (validUser && validPass) {
            // Mensaje ok
            Toast.makeText(this, "Bienvenido a la calculadora", Toast.LENGTH_SHORT).show();
            // Pasar a otro activity
            Intent intViewCalculadora = new Intent(this, ViewCalculadora.class);
            // Enviar datos a activity nuevo
            intViewCalculadora.putExtra("username", username.getText().toString());
            // Se invoca activity
            startActivity(intViewCalculadora);
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
        }
    }
}