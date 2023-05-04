package com.example.minijeucalculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.util.DisplayMetrics;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Les éléments de la fenêtre
    private Button jvBoutonJouer;
    private Button jvBoutonScore;
    private Button jvBoutonAPropos;
    private Button jvBoutonLangue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialiser les boutons de la partie IHM et leur affecter l'ouverture de l'activité correspondante
        // Bouton Jouer
        jvBoutonJouer = (Button) findViewById(R.id.BoutonJouer);
        jvBoutonJouer.setOnClickListener(view -> {
            Intent intent_niveau = new Intent(MainActivity.this,ChoixNiveau.class);
            startActivity(intent_niveau);
        });
        // Bouton Score
        jvBoutonScore = findViewById(R.id.BoutonScore);
        jvBoutonScore.setOnClickListener(view -> {
            Intent intent_score = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(intent_score);
        });

        // Bouton A Propos
        jvBoutonAPropos = findViewById(R.id.BoutonAPropos);
        jvBoutonAPropos.setOnClickListener(view -> {
            Intent intent_a_propos = new Intent(MainActivity.this,AProposActivity.class);
            startActivity(intent_a_propos);
        });

        // Bouton langue
        jvBoutonLangue = findViewById(R.id.BoutonLangue);
        jvBoutonLangue.setOnClickListener(view -> {
            startActivity(new Intent(this, ChoixLangue.class));
        });
    }
}