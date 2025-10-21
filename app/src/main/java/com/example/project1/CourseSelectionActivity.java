package com.example.project1;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseSelectionActivity extends AppCompatActivity {

    private EditText nameEdit;
    private EditText emailEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_selection);
        nameEdit = findViewById(R.id.courseSelectionNameEdit);
        emailEdit = findViewById(R.id.courseSelectPhoneEdit);

        String name = nameEdit.getText().toString().trim();
        String email = emailEdit.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Veuiller remplir le nom et l'email.", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}