package com.example.project1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);

        ListView customListView = findViewById(R.id.customListView);

        ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> software;

        software = new HashMap<>();
        software.put("icon", String.valueOf(R.drawable.software_word));
        software.put("title", "Word");
        software.put("description", "Traitement de Texte, suite Microsoft");
        dataList.add(software);

        software = new HashMap<>();
        software.put("icon", String.valueOf(R.drawable.software_excel));
        software.put("title", "Excel");
        software.put("description", "Tableur de la suite Microsoft");
        dataList.add(software);

        software = new HashMap<>();
        software.put("icon", String.valueOf(R.drawable.software_winrar));
        software.put("title", "WinRAR");
        software.put("description", "Logiciel de compression");
        dataList.add(software);

        software = new HashMap<>();
        software.put("icon", String.valueOf(R.drawable.software_kis));
        software.put("title", "Kaspersky");
        software.put("description", "Antivirus");
        dataList.add(software);

        software = new HashMap<>();
        software.put("icon", String.valueOf(R.drawable.software_sublime));
        software.put("title", "Sublime Text");
        software.put("description", "Éditeur de texte");
        dataList.add(software);

        software = new HashMap<>();
        software.put("icon", String.valueOf(R.drawable.software_utorrent));
        software.put("title", "uTorrent");
        software.put("description", "Client de téléchargement torrent");
        dataList.add(software);

        SimpleAdapter softwareAdapter = new SimpleAdapter(
                this.getBaseContext(),
                dataList,
                R.layout.custom_item_list,
                new String[]{"icon", "title", "description"},
                new int[]{R.id.customListIcon, R.id.customListTitle, R.id.customListDescription}
        );

        softwareAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if (view.getId() == R.id.customListIcon) {
                    int resId = Integer.parseInt((String) data);
                    ((android.widget.ImageView) view).setImageResource(resId);
                    return true;
                }
                return false;
            }
        });

        customListView.setAdapter(softwareAdapter);

    }
}