package com.example.minijeucalculmental;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.minijeucalculmental.ClasseBackEnd.Calcul;

public class JouerActivity extends AppCompatActivity {
    private Boolean EnJeu = true; // True tant que la partie n'est pas terminée

    // La classe pour gérer la générations du calcul
    private Calcul CalculAleatoire = new Calcul();
    private Integer Score = 0;
    private Integer Vies  = 3;

    private String ResultatUser = "";
    private TextView TextCalcul;
    private TextView TextResultatUser;

    // Les boutons du clavier numérique
    private Button Bouton0, Bouton1, Bouton2, Bouton3, Bouton4, Bouton5, Bouton6, Bouton7, Bouton8, Bouton9;
    private Button BoutonSuppChiffre, BoutonAjouteMoins, BoutonValideResultat;

    // Les items de la toolbar
    MenuItem MenuItemScore, MenuItemVie;

    Animation blink_anim,fadein_anim;

    Context context_actuel;

    private void InitBoutonClavierNumérique() {
        Bouton0 = findViewById(R.id.bouton0);
        Bouton0.setOnClickListener(view -> { AjouteChiffre(0); });

        Bouton1 = findViewById(R.id.bouton1);
        Bouton1.setOnClickListener(view -> { AjouteChiffre(1); });

        Bouton2 = findViewById(R.id.bouton2);
        Bouton2.setOnClickListener(view -> { AjouteChiffre(2); });

        Bouton3 = findViewById(R.id.bouton3);
        Bouton3.setOnClickListener(view -> { AjouteChiffre(3); });

        Bouton4 = findViewById(R.id.bouton4);
        Bouton4.setOnClickListener(view -> { AjouteChiffre(4); });

        Bouton5 = findViewById(R.id.bouton5);
        Bouton5.setOnClickListener(view -> { AjouteChiffre(5); });

        Bouton6 = findViewById(R.id.bouton6);
        Bouton6.setOnClickListener(view -> { AjouteChiffre(6); });

        Bouton7 = findViewById(R.id.bouton7);
        Bouton7.setOnClickListener(view -> { AjouteChiffre(7); });

        Bouton8 = findViewById(R.id.bouton8);
        Bouton8.setOnClickListener(view -> { AjouteChiffre(8); });

        Bouton9 = findViewById(R.id.bouton9);
        Bouton9.setOnClickListener(view -> { AjouteChiffre(9); });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jouer);

        // Initialise les elmts
        TextCalcul = findViewById(R.id.TextCalculAleatoire);
        TextResultatUser = findViewById(R.id.TextReponseUser);
        TextResultatUser.setText(ResultatUser); //On init la text view avec la chaine vide

        BoutonSuppChiffre = findViewById(R.id.BoutonSupp);
        BoutonSuppChiffre.setOnClickListener(view -> {
            SupprimeChiffre();
        });

        BoutonAjouteMoins = findViewById(R.id.BoutonMoins);
        BoutonAjouteMoins.setOnClickListener(view -> {
            AjouteMoins();
        });
        BoutonValideResultat = findViewById(R.id.BoutonValider);
        BoutonValideResultat.setOnClickListener(view -> {
            ValiderResultat();
        });
        InitBoutonClavierNumérique();

        // Récupérer le niveau choisi dans l'activité précédente
        Intent intent_choix_niveau = getIntent();
        String ChoixNiveau = intent_choix_niveau.getStringExtra("NIVEAU_CHOISI");

        // Initialise les bornes des nombres générer aléatoirement
        if (CalculAleatoire.InitialiseBorne(ChoixNiveau)) {
            // Lance une partie
            AfficheCalculAléatoire();
        } else {
            TextCalcul.setText("Une erreur est survenue lors de l'inialisation des bornes.");
        }

        // Récupérer les resources animation
        blink_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        fadein_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

        context_actuel = this;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_jouer, menu);

        MenuItemScore = menu.findItem(R.id.score);

        MenuItemVie = menu.findItem(R.id.vie);

        // Afficher le score & la vie
        String TexteScoreAAffiché = getString(R.string.text_score) + " " + Score + "   ";
        MenuItemScore.setTitle(TexteScoreAAffiché);

        String TexteViesAAffiché = getString(R.string.text_vie) + " " + Vies + "   ";
        MenuItemVie.setTitle(TexteViesAAffiché);

        return super.onCreateOptionsMenu(menu);
    }

    private void AfficheCalculAléatoire() {
        /* Génère un calcul aléatoire et l'affiche dans l'application */

        // Génère un calcul aléatoire
        CalculAleatoire.GénèreUnCalculAléatoire();

        // Affiche le calcul sur l'écran
        TextCalcul.setText(CalculAleatoire.getOperande1() + " " + CalculAleatoire.getOperateur() + " "  + CalculAleatoire.getOperande2());

    }


    /* -- Gestion saisie utilisateur -- */
    private void AjouteChiffre(Integer Chiffre) {
        ResultatUser += Chiffre;
        TextResultatUser.setText(ResultatUser);
    }

    private void SupprimeChiffre() {
        if (!ResultatUser.equalsIgnoreCase("")) {
            ResultatUser = ResultatUser.substring(0,ResultatUser.length()-1);
            TextResultatUser.setText(ResultatUser);
        }
    }

    private void AjouteMoins() {
        if (ResultatUser.equalsIgnoreCase("")) {
            ResultatUser += "-";
            TextResultatUser.setText(ResultatUser);
        }
    }

    private void ValiderResultat() {
        if (ResultatUser.equalsIgnoreCase("")) {
            TextResultatUser.setText(R.string.texte_saisir_result);
        } else {
            Integer resultat_saisie = Integer.parseInt(ResultatUser);
            System.out.println(resultat_saisie);
            Integer resultat_calcul = CalculAleatoire.getResultat();
            System.out.println(resultat_calcul);
            if (resultat_saisie == resultat_calcul ) {
                // Le résultat est bon
                System.out.println("true");
                Score ++;
                String TexteScoreAAffiché = getString(R.string.text_score) + " " + Score + "   ";
                MenuItemScore.setTitle(TexteScoreAAffiché);


                // On met le calcul en vert
                TextCalcul.setTextColor(ContextCompat.getColor(this, R.color.bonne_reponse));
            } else {
                System.out.println("false");
                // on met le calcul en rouge
                TextCalcul.setTextColor(ContextCompat.getColor(this, R.color.mauvaise_reponse));
                if (Vies > 1) {
                    Vies --;
                    String TexteViesAAffiché = getString(R.string.text_vie) + " " + Vies + "   ";
                    MenuItemVie.setTitle(TexteViesAAffiché);
                }else {
                    // Fin de partie
                    Vies --;
                    // Ouvre l'activité d'enregistrement
                    Intent intent_enregistrer = new Intent(this, EnregistrerActivity.class);
                    intent_enregistrer.putExtra("SCORE",String.valueOf(Score));
                    startActivity(intent_enregistrer);
                }
            }
            // On fait clignoter le calcul demander
            TextCalcul.startAnimation(blink_anim);
            // le laisser afficher un peu avant de changer de calcul

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // On enlève l'animation blink
                    TextCalcul.clearAnimation();
                    // On affiche le new calcul avec l'animation fondu

                    AfficheCalculAléatoire();
                    TextCalcul.setAnimation(fadein_anim);

                    TextCalcul.setTextColor(ContextCompat.getColor(context_actuel,R.color.orange));

                   /* Handler handler_fadein = new Handler();
                    handler_fadein.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TextCalcul.clearAnimation();
                        }
                    },1500);*/
                }
            }, 1000);

            // On efface la réponse de l'utilisateur
            ResultatUser = "";
            TextResultatUser.setText(ResultatUser);
        }
    }
}


