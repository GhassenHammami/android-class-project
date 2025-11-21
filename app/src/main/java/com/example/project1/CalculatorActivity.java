package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    EditText editTextA, editTextB;
    Button receiveResultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        editTextA = findViewById(R.id.calculatorInputA);
        editTextB = findViewById(R.id.calculatorInputB);
        receiveResultBtn = findViewById(R.id.calculatorBtnGetResult);

        receiveResultBtn.setOnClickListener(v -> {
            String valueA = editTextA.getText().toString().trim();
            String valueB = editTextB.getText().toString().trim();

            if (valueA.isEmpty() || valueB.isEmpty()) {
                if (valueA.isEmpty()) editTextA.setError("Enter a number");
                if (valueB.isEmpty()) editTextB.setError("Enter a number");
                return;
            }

            Intent intent = new Intent(CalculatorActivity.this, CalculateActivity.class);
            intent.putExtra("EXTRA_VALUE_A", valueA);
            intent.putExtra("EXTRA_VALUE_B", valueB);
            startActivity(intent);
        });


    }
}