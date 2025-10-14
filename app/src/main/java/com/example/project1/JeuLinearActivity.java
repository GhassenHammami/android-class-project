package com.example.project1;

import android.graphics.Color;
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
    private TextView textMessage;
    private int attemptCount = 1;
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jeu_linear);

        btnValidate = findViewById(R.id.btnVerifyUser);
        editNumberInput = findViewById(R.id.editNombreUser);
        textAttemptNumber = findViewById(R.id.txtAttempt);
        textMessage = findViewById(R.id.txtMessage);

        initializeGame();

        btnValidate.setOnClickListener(v -> {
            if (attemptCount >= 10)
                initializeGame();
            else {
                String nbr = editNumberInput.getText().toString().trim();
                if (nbr.isEmpty()) {
                    displayMessage("Vous devez saisir un nombre", Color.RED);
                } else {
                    try {
                        int nbr_saisi = Integer.parseInt(nbr);
                        if (nbr_saisi < 100 || nbr_saisi > 999)
                            displayMessage("Veuillez saisir un nombre entre 100 et 999", Color.RED);
                        else if (attemptCount >= 10)
                            displayMessage("10 tentatives déja effectués", Color.RED);
                        else {
                            Log.d("Jeu", "Nombre saisi est = " + nbr_saisi);

                            if (nbr_saisi == randomNumber) {
                                displayMessage("Nombre correcte", 0xff99cc00);
                            } else if (nbr_saisi < randomNumber) {
                                displayMessage("Nombre incorrecte. Essayez un nombre supérieur.", Color.YELLOW);
                            } else {
                                displayMessage("Nombre incorrecte. Essayez un nombre inférieur.", Color.YELLOW);
                            }

                            final int newAttemptCount = attemptCount + 1;
                            String attemptText = getString(R.string.attempt_text, newAttemptCount);
                            textAttemptNumber.setText(attemptText);
                            attemptCount = newAttemptCount;
                        }

                        if (attemptCount >= 10) {
                            displayMessage("Vous avez perdu ! Le bon nombre était : " + randomNumber, Color.RED);
                            btnValidate.setText("Reset");
                        }

                    } catch (NumberFormatException e) {
                        displayMessage("Entrée invalide : " + nbr, Color.RED);
                    }
                }
            }
        });
    }

    private void initializeGame() {
        attemptCount = 1;
        String attemptText = getString(R.string.attempt_text, attemptCount);
        textAttemptNumber.setText(attemptText);

        editNumberInput.setText("");
        textMessage.setVisibility(View.INVISIBLE);
        btnValidate.setText("Vérifier");

        final int min = 100;
        final int max = 999;
        randomNumber = new Random().nextInt((max - min) + 1) + min;
        Log.d("Jeu", "Random number generated: " + randomNumber);
    }

    public void displayMessage(String message, int color) {
        textMessage.setVisibility(View.VISIBLE);
        textMessage.setText(message);
        textMessage.setTextColor(color);
        Log.e("Jeu", message);
    }
}