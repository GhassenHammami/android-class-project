package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListIntentActivity extends AppCompatActivity {

    Button explicitIntentBtn, implicitIntentBtn, calculatorBtn, closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_intent);

        explicitIntentBtn = findViewById(R.id.listIntentBtnSimpleExplicit);
        implicitIntentBtn = findViewById(R.id.listIntentBtnIntentImplicit);
        calculatorBtn = findViewById(R.id.listIntentBtnCalculator);
        closeBtn = findViewById(R.id.listIntentBtnClose);

        explicitIntentBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ListIntentActivity.this, SimpleExplicitIntentActivity.class);
            startActivity(intent);
        });

        implicitIntentBtn.setOnClickListener(v -> {

        });

        calculatorBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ListIntentActivity.this, CalculatorActivity.class);
            startActivity(intent);
        });

        closeBtn.setOnClickListener(v -> {
            finish();
        });
    }
}
