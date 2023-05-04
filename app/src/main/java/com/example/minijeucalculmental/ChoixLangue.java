package com.example.minijeucalculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;

import java.util.Locale;

public class ChoixLangue extends AppCompatActivity {
    Button jvBoutonFrançais, jvBoutonPortugais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_langue);

        // Bouton langue
        jvBoutonFrançais = findViewById(R.id.BoutonFrançais);
        jvBoutonFrançais.setOnClickListener(view -> {
            setLanguage("fr");
            startActivity(new Intent(this, MainActivity.class));
        });

        jvBoutonPortugais = findViewById(R.id.BoutonPortugais);
        jvBoutonPortugais.setOnClickListener(view -> {
            setLanguage("pt");
            startActivity(new Intent(this, MainActivity.class));
        });



    }

    @SuppressWarnings("deprecation")
    private void setLanguage(String codelangue) {
        Resources res = this.getResources();
        Configuration conf = res.getConfiguration();
        Locale locale = new Locale(codelangue);
        Locale.setDefault(locale);
        conf.setLocale(locale);
        res.updateConfiguration(conf, res.getDisplayMetrics());
    }
}