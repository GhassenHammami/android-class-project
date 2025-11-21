package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity {

    TextView textA, textB, textSum;
    Button sendResultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);

        textA = findViewById(R.id.calculateTextA);
        textB = findViewById(R.id.calculateTextB);
        textSum = findViewById(R.id.calculateTextSum);
        sendResultBtn = findViewById(R.id.calculateBtnSendResult);

        Intent intent = getIntent();
        String valueA = intent.getStringExtra("EXTRA_VALUE_A");
        String valueB = intent.getStringExtra("EXTRA_VALUE_B");

        if (valueA != null && valueB != null && !valueA.isEmpty() && !valueB.isEmpty()) {
            double a = Double.parseDouble(valueA);
            double b = Double.parseDouble(valueB);
            double result = a + b;

            textA.setText(valueA);
            textB.setText(valueB);
            if (result == (int) result) {
                textSum.setText(String.valueOf((int) result));
            } else {
                textSum.setText(String.valueOf(result));
            }

            sendResultBtn.setOnClickListener(v -> {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("RESULT", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            });

        } else {
            Toast.makeText(this, "Invalid input received", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
