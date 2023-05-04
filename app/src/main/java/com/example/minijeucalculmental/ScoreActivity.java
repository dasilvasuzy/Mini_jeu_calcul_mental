package com.example.minijeucalculmental;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minijeucalculmental.database.ScoreBaseHelper;
import com.example.minijeucalculmental.database.ScoreDao;
import com.example.minijeucalculmental.entities.Score;

public class ScoreActivity extends AppCompatActivity {
    private TextView textScore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ScoreDao scoreDao = new ScoreDao(new ScoreBaseHelper(this,"BDD",1));
        Score lastScore = scoreDao.lastOrNull();

   /*     textScore = findViewById(R.id.);
        String textAAffiché = lastScore.getPseudo() + " : " + lastScore.getScore();
        textScore.setText(textAAffiché);
    */


    }
}
