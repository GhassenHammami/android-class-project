package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SimpleExplicitIntentReturnActivity extends AppCompatActivity {

    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple_explicit_intent_return);

        closeBtn = findViewById(R.id.simpleExplicitIntentReturnBtn);

        closeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SimpleExplicitIntentReturnActivity.this, ListIntentActivity.class);
            startActivity(intent);
        });

    }
}