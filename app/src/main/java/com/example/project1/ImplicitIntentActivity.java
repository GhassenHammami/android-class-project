package com.example.project1;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ImplicitIntentActivity extends AppCompatActivity {

    MaterialButton webBtn, dialBtn, showContactsBtn, selectContactBtn;
    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        webBtn = findViewById(R.id.implicitIntentWebBtn);
        dialBtn = findViewById(R.id.implicitIntentDialBtn);
        showContactsBtn = findViewById(R.id.implicitIntentShowContactsBtn);
        selectContactBtn = findViewById(R.id.implicitIntentSelectContactsBtn);
        closeBtn = findViewById(R.id.implicitIntentBtnClose);

        webBtn.setOnClickListener(v -> {
            String url = "https://www.polytechsousse.tn";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        dialBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        });

        showContactsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        });

        closeBtn.setOnClickListener(v -> {
            finish();
        });
    }
}
