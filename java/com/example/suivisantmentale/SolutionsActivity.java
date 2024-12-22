package com.example.suivisantmentale;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

public class SolutionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);

        // Initialisation de la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Activer la flèche de retour (le bouton 'Up')
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Affiche la flèche de retour
            Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back);
            if (upArrow != null) {
                upArrow.setTint(getResources().getColor(R.color.buttonColorLightBlue)); // Applique la couleur bleue claire
                getSupportActionBar().setHomeAsUpIndicator(upArrow); // Applique l'icône personnalisée de la flèche
            }
        }

        // Récupérer l'humeur sélectionnée depuis MainActivity
        String selectedMood = getIntent().getStringExtra("selectedMood");

        // Afficher les solutions correspondant à l'humeur
        TextView solutionTextView = findViewById(R.id.solution_text);
        solutionTextView.setText(getSolutionsForMood(selectedMood));
    }

    private String getSolutionsForMood(String mood) {
        switch (mood) {
            case "Heureux":
                return "Continuez à cultiver votre bonheur ! Passez du temps avec vos proches et célébrez vos réussites.";
            case "Triste":
                return "Prenez le temps de vous reposer. Parlez à un ami proche ou écoutez de la musique relaxante.";
            case "Stressé":
                return "Essayez des techniques de relaxation comme le yoga ou la méditation. Respirez profondément.";
            case "Anxieux":
                return "Prenez une pause et concentrez-vous sur des exercices de respiration. Évitez la caféine.";
            case "Neutre":
                return "Essayez une nouvelle activité pour briser la monotonie, comme un loisir ou une promenade.";
            default:
                return "Aucune solution disponible pour cette humeur.";
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Gère le retour à l'activité précédente
        finish();
        return true;
    }
}
