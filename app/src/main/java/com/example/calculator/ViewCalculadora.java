package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCalculadora extends AppCompatActivity {
    private EditText fieldNum1;
    private EditText fieldNum2;
    private TextView fieldResult;
    private TextView fieldShowUsername;
    private Spinner operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_calculadora);

        fieldNum1 = findViewById(R.id.idNum1);
        fieldNum2 = findViewById(R.id.idNum2);
        fieldResult = findViewById(R.id.idResult);
        fieldShowUsername = findViewById(R.id.idShowUsername);

        // Define el spinner con valores del strings.xml
        String[] types = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        operacion = findViewById(R.id.selectOperation);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, types);
        operacion.setAdapter(adapter);

        // Recuperar dato enviado por el activity 1
        String extUser = getIntent().getStringExtra("username");
        fieldShowUsername.setText("Bienvenido " + extUser);
    }

    public void CalcularSuma(View v) {
        int result = 0;
        int num1 = Integer.parseInt(fieldNum1.getText().toString());
        int num2 = Integer.parseInt(fieldNum2.getText().toString());

        // Se captura la operación deseada por el usuario
        String typeSelected = operacion.getSelectedItem().toString();
        System.out.println("xx Operacion: " + typeSelected);

        switch (typeSelected) {
            case "Sumar":
                result = num1 + num2;
                break;
            case "Restar":
                result = num1 - num2;
                break;
            case "Multiplicar":
                result = num1 * num2;
                break;
            case "Dividir":
                result = num1 / num2;
                break;
            default:
                result = 0;
        }

        //Se muestra el resultado
        fieldResult.setText(String.valueOf(result));
    }

    @Override
    public boolean onKeyDown(int key_code, KeyEvent event) {
        System.out.println("key " + key_code);
        System.out.println("event " + event.KEYCODE_BACK);

        if (key_code == event.KEYCODE_BACK) {
            Toast.makeText(this, "PROHIBIDO UTILIZAR EL BOTÓN BACK DEL CELULAR!", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}