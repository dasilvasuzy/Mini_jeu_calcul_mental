package com.example.minijeucalculmental.ClasseBackEnd;

import java.util.Arrays;
import java.util.List;

public class Calcul {
    /* -- Attributes -- */
    private Integer operande1;
    private Integer operande2;
    private Character  operateur;

    //private ? symbol;
    private Integer resultat;

    private Integer borne_min;
    private Integer borne_max;

    // Permet de rendre le code plus clair et plus facile à maintenir, car si vous devez ajouter ou supprimer des niveaux à l'avenir,
    // il suffit de les ajouter ou de les supprimer de l'énumération et de la liste (dans InitialiseBorne)
    private enum enum_niveaux {
        FACILE, MOYEN, DIFFICILE
    }

    private Character[] tab_operateur_disponible = {'+','-','÷','x'};



    // Constructor
    public Calcul() {

    }

    /* -- Getter Setter -- */
    public Integer getOperande1() {
        return operande1;
    }

    public void setOperande1(Integer operande1) {
        this.operande1 = operande1;
    }

    public Integer getOperande2() {
        return operande2;
    }

    public void setOperande2(Integer operande2) {
        this.operande2 = operande2;
    }

    public Character getOperateur() {
        return operateur;
    }

    public void setOperateur(Character operateur) {
        this.operateur = operateur;
    }

    public Integer getResultat() {
        return resultat;
    }

    public void setResultat(Integer resultat) {
        this.resultat = resultat;
    }

    /* -- Methods -- */
    public boolean InitialiseBorne(String NiveauChoisi) {
        /* Initialise les bornes selon le choix du niveau */
        /* Renvoie vrai si l'initialisation a réussi, false sinon */

        List<enum_niveaux> NiveauxDisponibles = Arrays.asList(enum_niveaux.FACILE, enum_niveaux.MOYEN, enum_niveaux.DIFFICILE);

        //ancienne instruction + simple : if ((NiveauChoisi.equalsIgnoreCase("Facile")) || (NiveauChoisi.equalsIgnoreCase("Moyen")) || (NiveauChoisi.equalsIgnoreCase("Difficile"))) {
        if (NiveauxDisponibles.contains(enum_niveaux.valueOf(NiveauChoisi.toUpperCase()))) {
            switch (NiveauChoisi){
                case "Facile":
                    borne_min = 1;
                    borne_max = 20;
                    break;
                case "Moyen":
                    borne_min = 20;
                    borne_max = 50;
                    break;
                case "Difficile":
                    borne_min = 50;
                    borne_max = 100;
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    private void Calcul() {
        if ((operande1 != null) && (operande2 != null) && (operateur != null)) {
            switch (operateur){
                case '+':
                    resultat = operande1 + operande2;
                    break;
                case '-':
                    resultat = operande1 - operande2;
                    break;
                case '÷':
                    resultat = operande1 / operande2;
                    break;
                case 'x':
                    resultat = operande1 * operande2;
                    break;
            }
        }
    }
    public boolean GénèreUnCalculAléatoire() {
        /* Génère un calcul aléatoire, génère les nombres selon les bornes min max et un opérateur aléatoire*/

        // Génération d'opérandes aléatoires
        operande1 = borne_min + (int)(Math.random() * ((borne_max - borne_min) + 1));
        operande2 = borne_min + (int)(Math.random() * ((borne_max - borne_min) + 1));

        // Génération de l'opérateur aléaoire
        Integer indice_aleatoire = (int)(Math.random() * 4); //Génère un nb aléatoire entre 0 et 3
        operateur = tab_operateur_disponible[indice_aleatoire];

        // Stocker le résultat du calcul
        Calcul();

        return true;
    }

}