package com.example.minijeucalculmental.entities;

public class Score extends BaseEntity {
    private String pseudo;
    private String score;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Score() {

    }
}
