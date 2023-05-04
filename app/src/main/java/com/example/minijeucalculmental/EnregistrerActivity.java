package com.example.minijeucalculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.minijeucalculmental.database.ScoreBaseHelper;
import com.example.minijeucalculmental.database.ScoreDao;
import com.example.minijeucalculmental.entities.Score;


public class EnregistrerActivity extends AppCompatActivity {

    private Button BoutonEnregistrer;
    private EditText SaisiePseudo;
    private String ScoreUtilisateur;
    private String NbCalculDemandé;
    private ScoreDao scoreDao ;
    private Context context_actuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrer);

        // Récupérer le score dans l'activité jouer
        Intent intent_jouer = getIntent();
        ScoreUtilisateur = intent_jouer.getStringExtra("SCORE");
        NbCalculDemandé = intent_jouer.getStringExtra("NB_CALCUL");

        // Initialisation bouton enregistrer
        BoutonEnregistrer = (Button) findViewById(R.id.BoutonEnregistrer);
        BoutonEnregistrer.setOnClickListener( view -> {
            EnregistrerBDD();
        });

        // Initialisation EditText saisie pseudo
        SaisiePseudo = (EditText) findViewById(R.id.SaisieNomUtilisateur);

        scoreDao = new ScoreDao(new ScoreBaseHelper(this,"BDD",1));

        context_actuel = this;
    }

    private void EnregistrerBDD() {
        // Vérifier que le pseudo est renseigné
        String indication_edittext = String.valueOf(R.string.sai_pseudo);
        //if (SaisiePseudo.equals(indication_edittext)) {
        //    System.out.println("vide");
        //}else {
        //    System.out.println("remplie");
        //}

        // Enregistrer dans la BDD
        Score monScore = new Score();
        String pseudoUtilisateur = String.valueOf(SaisiePseudo.getText());
        monScore.setPseudo(pseudoUtilisateur);

        monScore.setScore(ScoreUtilisateur);
        Score entité = scoreDao.create(monScore);
        if (entité.id > 0) {
            // on affiche un message pour dire que c'est bon
            AlertDialog.Builder builder = new AlertDialog.Builder(context_actuel);

            builder.setTitle("Votre score a bien été enregistré. :)")
                    .setMessage("Votre score est " + ScoreUtilisateur + ". Merci d'avoir joué !")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            Intent intentMainMenu = new Intent(context_actuel, MainActivity.class);
                            startActivity(intentMainMenu);
                        }
                    })
                    .create()
                    .show();
        }else {
            // on affiche un message d'erreur
            AlertDialog.Builder builder = new AlertDialog.Builder(context_actuel);

            builder.setTitle("Une erreur est survenue lors de l'enregistrement de votre score. :(")
                    .setMessage("Nous nous excusons pour la gêne occasionnée.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            Intent intentMainMenu = new Intent(context_actuel, MainActivity.class);
                            startActivity(intentMainMenu);
                        }
                    })
                    .create()
                    .show();
        }


    }
}