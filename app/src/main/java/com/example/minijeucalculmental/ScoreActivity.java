package com.example.minijeucalculmental;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minijeucalculmental.database.ScoreBaseHelper;
import com.example.minijeucalculmental.database.ScoreDao;
import com.example.minijeucalculmental.entities.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private TextView textScore;

    private TextView txtpseudo;
    private TextView txtscore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ScoreDao scoreDao = new ScoreDao(new ScoreBaseHelper(this,"BDD",1));

        List<Score> ListeScore = new ArrayList<Score>();
        ListeScore = scoreDao.getMesDonnee();

        // Afficher les 4 meilleurs score
        int index = 0 ;

        if (index < ListeScore.size()) {
            txtpseudo = findViewById(R.id.pseudo1);
            txtpseudo.setText(ListeScore.get(0).getPseudo());
            txtscore  = findViewById(R.id.score1);
            txtscore.setText(ListeScore.get(0).getScore());
            index ++;
        }

        if (index < ListeScore.size()) {
            txtpseudo = findViewById(R.id.pseudo2);
            txtpseudo.setText(ListeScore.get(1).getPseudo());
            txtscore  = findViewById(R.id.score2);
            txtscore.setText(ListeScore.get(1).getScore());
            index ++;
        }

        if (index < ListeScore.size()) {
            txtpseudo = findViewById(R.id.pseudo3);
            txtpseudo.setText(ListeScore.get(2).getPseudo());
            txtscore  = findViewById(R.id.score3);
            txtscore.setText(ListeScore.get(2).getScore());
            index ++;
        }

        if (index < ListeScore.size()) {
            txtpseudo = findViewById(R.id.pseudo4);
            txtpseudo.setText(ListeScore.get(3).getPseudo());
            txtscore  = findViewById(R.id.score4);
            txtscore.setText(ListeScore.get(3).getScore());
            index ++;
        }



    }
}
