package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleExplicitIntentActivity extends AppCompatActivity {

    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_explicit_intent);

        closeBtn = findViewById(R.id.simpleExplicitIntentReturnBtn);

        closeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SimpleExplicitIntentActivity.this, ListIntentActivity.class);
            startActivity(intent);
        });

    }
}