package com.example.project1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ImplicitIntentActivity extends AppCompatActivity {

    MaterialButton webBtn, dialBtn, showContactsBtn;
    EditText phoneInput;
    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        webBtn = findViewById(R.id.implicitIntentWebBtn);
        dialBtn = findViewById(R.id.implicitIntentDialBtn);
        showContactsBtn = findViewById(R.id.implicitIntentShowContactsBtn);
        phoneInput = findViewById(R.id.implicitIntentPhoneInput);
        closeBtn = findViewById(R.id.implicitIntentBtnClose);

        webBtn.setOnClickListener(v -> {
            String url = "https://www.polytechsousse.tn";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        dialBtn.setOnClickListener(v -> {
            String number = phoneInput.getText().toString().trim();

            if (number.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer un numéro avant d'appeler.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);
        });

        showContactsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        });

        closeBtn.setOnClickListener(v -> finish());
    }
}
