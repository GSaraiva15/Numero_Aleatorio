package com.example.numero_aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int numeroAdivinhar =NumerosAleatorios.proximoNumero();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int soma;

    public void verificaNumero(View view) {


        EditText editTextNumero = (EditText) findViewById(R.id.editTextNumero);

        String strNumero = editTextNumero.getText().toString();


        int numero;
        try {
            numero = Integer.parseInt(strNumero);
        } catch (NumberFormatException e) {
            editTextNumero.setError(getString(R.string.numero_obrigatorio));
            editTextNumero.requestFocus();
            return;
        }
        if ((numero < 1) || (numero > 10)) {
            editTextNumero.setError(getString(R.string.numero_limites));
            editTextNumero.requestFocus();
            return;
        }

        TextView textViewMostrarResultado = findViewById(R.id.textViewMostrarResultado);
        TextView textViewMostrarTentativas = findViewById(R.id.textViewMostrarTentativas);



            if(numeroAdivinhar < numero){
            soma++;
            textViewMostrarTentativas.setText(String.valueOf(soma));
            textViewMostrarResultado.setText(R.string.resultado_errado_menor);
            textViewMostrarResultado.setTextColor(Color.RED);
        }
            else if (numeroAdivinhar > numero){
                soma++;
                textViewMostrarTentativas.setText(String.valueOf(soma));
                textViewMostrarResultado.setText(R.string.resultado_errado_maior);
                textViewMostrarResultado.setTextColor(Color.RED);
            }
            else{
                soma++;
                textViewMostrarResultado.setText(R.string.resultado_correto);
                textViewMostrarResultado.setTextColor(Color.GREEN);
                textViewMostrarResultado.requestFocus();
            }

            }
    }


