package com.example.minijeucalculmental.database;

import android.content.Context;

import java.util.Collections;
import java.util.List;

public class ScoreBaseHelper extends DataBaseHelper{
    public ScoreBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + ScoreDao.tableName + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreDao.pseudoUtilisateur + " VARCHAR(50) NOT NULL," +
                ScoreDao.scoreUtilisateur  + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS "+ ScoreDao.tableName;    }

    @Override
    protected String getBestScores() {
        return "SELECT " + ScoreDao.pseudoUtilisateur + ", MAX(" + ScoreDao.scoreUtilisateur + ")" +
                "FROM " + ScoreDao.tableName + " LIMIT 4";
    }



}
