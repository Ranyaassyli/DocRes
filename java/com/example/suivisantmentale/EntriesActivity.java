package com.example.suivisantmentale;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EntriesActivity extends AppCompatActivity {
    private ListView entriesList;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        entriesList = findViewById(R.id.entries_list);
        backButton = findViewById(R.id.back_button);

        // Charger les données sauvegardées
        loadEntries();

        // Bouton retour à l'activité principale
        backButton.setOnClickListener(v -> finish());
    }

    private void loadEntries() {
        SharedPreferences sharedPreferences = getSharedPreferences("SuiviSanteMentale", MODE_PRIVATE);
        String allEntries = sharedPreferences.getString("entries", "Aucune entrée enregistrée.");

        // Convertir les entrées en tableau pour l'affichage
        String[] entriesArray = allEntries.split("\n\n");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, entriesArray);
        entriesList.setAdapter(adapter);
    }
}
