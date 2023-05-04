package com.example.minijeucalculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ChoixNiveau extends AppCompatActivity {
    private Button jvBoutonFacile;
    private Button jvBoutonMoyen;
    private Button jvBoutonDifficile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_niveau);

        // Initialiser les boutons
        // Bouton facile
        jvBoutonFacile = (Button) findViewById(R.id.BoutonFacile);
        jvBoutonFacile.setOnClickListener( view -> {
            Intent intent_jouer_facile = new Intent(this,JouerActivity.class);
            intent_jouer_facile.putExtra("NIVEAU_CHOISI","Facile");
            startActivity(intent_jouer_facile);
        });

        // Bouton moyen
        jvBoutonMoyen = (Button) findViewById(R.id.BoutonMoyen);
        jvBoutonMoyen.setOnClickListener( view -> {
            Intent intent_jouer_moyen = new Intent(this,JouerActivity.class);
            intent_jouer_moyen.putExtra("NIVEAU_CHOISI","Moyen");
            startActivity(intent_jouer_moyen);
        });

        // Bouton difficile
        jvBoutonDifficile = (Button) findViewById(R.id.BoutonDifficile);
        jvBoutonDifficile.setOnClickListener( view -> {
            Intent intent_jouer_difficile = new Intent(this,JouerActivity.class);
            intent_jouer_difficile.putExtra("NIVEAU_CHOISI","Difficile");
            startActivity(intent_jouer_difficile);
        });
    }
}