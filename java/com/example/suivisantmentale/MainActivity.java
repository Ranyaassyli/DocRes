package com.example.suivisantmentale;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    private Spinner moodSpinner;
    private EditText journalEntry;
    private Button saveButton, viewEntriesButton, viewSolutionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des vues
        moodSpinner = findViewById(R.id.mood_spinner);
        journalEntry = findViewById(R.id.journal_entry);
        saveButton = findViewById(R.id.save_button);
        viewEntriesButton = findViewById(R.id.view_entries_button);
        viewSolutionsButton = findViewById(R.id.view_solutions_button);

        // Lier le Spinner avec les options d'humeur
        String[] moods = {"Heureux", "Triste", "Stressé", "Anxieux", "Neutre"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, moods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodSpinner.setAdapter(adapter);

        // Gestion de l'événement du bouton "Enregistrer"
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        // Naviguer vers la deuxième activité pour voir les entrées
        viewEntriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EntriesActivity.class);
                startActivity(intent);
            }
        });

        // Naviguer vers la SolutionsActivity en fonction de l'humeur sélectionnée
        viewSolutionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedMood = moodSpinner.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, SolutionsActivity.class);
                intent.putExtra("selectedMood", selectedMood);  // Passer l'humeur sélectionnée
                startActivity(intent);
            }
        });
    }

    private void saveData() {
        String selectedMood = moodSpinner.getSelectedItem().toString();
        String journalText = journalEntry.getText().toString();

        if (journalText.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer vos pensées.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Sauvegarder les données dans SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("SuiviSanteMentale", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String existingEntries = sharedPreferences.getString("entries", "");
        editor.putString("entries", existingEntries + "Humeur : " + selectedMood + "\nPensées : " + journalText + "\n\n");
        editor.apply();

        Toast.makeText(this, "Entrée enregistrée avec succès.", Toast.LENGTH_SHORT).show();
        journalEntry.setText(""); // Réinitialiser le champ
    }
}
