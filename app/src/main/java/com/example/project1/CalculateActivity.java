package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity {

    TextView textA, textB;
    Button sendResultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);

        textA = findViewById(R.id.calculateTextA);
        textB = findViewById(R.id.calculateTextB);
        sendResultBtn = findViewById(R.id.calculateBtnSendResult);

        Intent intent = getIntent();
        String valueA = intent.getStringExtra("EXTRA_VALUE_A");
        String valueB = intent.getStringExtra("EXTRA_VALUE_B");

        textA.setText(valueA);
        textB.setText(valueB);

        sendResultBtn.setOnClickListener(v -> {
            if (valueA != null && valueB != null && !valueA.isEmpty() && !valueB.isEmpty()) {
                try {
                    double a = Double.parseDouble(valueA);
                    double b = Double.parseDouble(valueB);
                    double result = a + b;

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("RESULT", result);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Values cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
