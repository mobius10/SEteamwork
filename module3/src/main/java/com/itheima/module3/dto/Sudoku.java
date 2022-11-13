package com.itheima.module3.dto;

import java.util.List;

public class Sudoku {
    private int score;
    private int[] dice=new int[9];

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int[] getDice() {
        return dice;
    }

    public void setDice(int[] dice) {
        this.dice = dice;
    }

}
