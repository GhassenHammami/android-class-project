package com.example.project1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class JeuLinearActivity extends AppCompatActivity {

    private Button btnValidate;
    private EditText editNumberInput;
    private TextView textAttemptNumber;

    private int attemptCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jeu_linear);

        btnValidate = findViewById(R.id.btnVerifyUser);
        editNumberInput = findViewById(R.id.editNombreUser);
        textAttemptNumber = findViewById(R.id.txtAttempt);

        String attemptText = getString(R.string.attempt_text, attemptCount);
        textAttemptNumber.setText(attemptText);

        final int min = 100;
        final int max = 999;
        final int randomNumber = new Random().nextInt((max - min) + 1) + min;
        Log.d("Jeu", "Random number generated: " + randomNumber);

        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nbr = editNumberInput.getText().toString().trim();

                if (nbr.isEmpty()) {
                    Log.e("Jeu", "Vous devez saisir un nombre");
                } else {
                    try {
                        int nbr_saisi = Integer.parseInt(nbr);
                        if (nbr_saisi < 100 || nbr_saisi > 999) {
                            Log.e("Jeu", "Veuillez saisir un nombre entre 100 et 999");
                        } else {
                            if (attemptCount >= 10) {
                                Log.d("Jeu", "10 tentatives effectués ");
                            } else {
                                Log.d("Jeu", "Nombre saisi est = " + nbr_saisi);

                                if (nbr_saisi == randomNumber)
                                    Log.e("Jeu", "Nombre correcte" );
                                else
                                    Log.e("Jeu", "Nombre incorrecte" );

                                final int newAttemptCount = attemptCount + 1;
                                String attemptText = getString(R.string.attempt_text, newAttemptCount);
                                textAttemptNumber.setText(attemptText);
                                attemptCount = newAttemptCount;
                            }

                        }
                    } catch (NumberFormatException e) {
                        Log.e("Jeu", "Entrée invalide : " + nbr);
                    }
                }
            }
        });
    }
}