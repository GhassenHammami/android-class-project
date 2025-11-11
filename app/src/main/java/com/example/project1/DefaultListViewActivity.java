package com.example.project1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DefaultListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_default_list_view);

        ListView listView = findViewById(R.id.listView1);

        String[] villes = {"Sousse", "Mahdia", "Tunis", "Gabes", "Jerba", "Kef", "Monastir", "Gafsa", "Nabeul", "Ariana"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, villes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                int itemPosition = position;

                String itemValue = (String) listView.getItemAtPosition(position);

                Toast.makeText(
                        getApplicationContext(),
                        "Position: " + itemPosition + "  |  Element: " + itemValue,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}