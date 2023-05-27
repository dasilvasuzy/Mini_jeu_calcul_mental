package com.example.minijeucalculmental.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.minijeucalculmental.entities.Score;

import java.util.List;

public class ScoreDao  extends  BaseDao<Score>{

    public static String pseudoUtilisateur = "PSEUDO_UTILISATEUR";
    public static String scoreUtilisateur = "SCORE_UTILISATEUR";
    public static String tableName = "SCORES";

    public ScoreDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return tableName;
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
        values.put(pseudoUtilisateur,entity.getPseudo());
        values.put(String.valueOf(scoreUtilisateur),entity.getScore());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Score score = new Score();
        Integer indexPseudo = cursor.getColumnIndex(pseudoUtilisateur);
        Integer indexScore = cursor.getColumnIndex(String.valueOf(scoreUtilisateur));
        score.setPseudo(cursor.getString(indexPseudo));
        score.setScore(cursor.getString(indexScore)); //cursor.getInt(indexScore));
        return score;
    }






}
