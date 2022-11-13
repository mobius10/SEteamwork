package com.itheima.module3.service.Sudoku;

import com.itheima.module3.dto.Sudoku;
import org.springframework.stereotype.Service;

@Service
public class SudokuService {
    public static int ScoreCount(Sudoku s){
        int[]  dice=s.getDice();
        int count=0;
        for(int i=0;i<9;i+=3){
            if(dice[i]==dice[i+1]&&dice[i+1]==dice[i+2])
                count+=dice[i]*9;
            else if(dice[i]==dice[i+1])
                count+=dice[i]*4+dice[i+2];
            else if(dice[i]==dice[i+2])
                count+=dice[i]*4+dice[i+1];
            else if(dice[i+1]==dice[i+2])
                count+=dice[i+1]*4+dice[i];
        }
        return count;
    }
    public static void elimination(Sudoku s,int point,int line) {
        int[] dice = s.getDice();
        for (int i = 0; i < 3; i++) {
            if (dice[line * 3 + i] == point)
                dice[line * 3 + 1] = 0;
        }
        for (int i = 1; i <= 2; i++) {
            while (i > 0) {
                if (dice[line * 3 + i] > 0 && dice[line * 3 + i - 1] == 0) {
                    dice[line * 3 + i - 1] = dice[line * 3 + i];
                    dice[line * 3 + i] = 0;
                }
                i--;
            }
        }
    }
    public static void step(Sudoku s, int point, int line, int row){
        int[] dice=s.getDice();
        dice[line*3+row]=point;
        s.setDice(dice);
    }
    public static boolean check(Sudoku s){
        int[] dice=s.getDice();
        for(int i=0;i<9;i++){
            if(dice[i]==0)
                return false;
        }
        return true;
    }
    public void UIStep(Sudoku s1, Sudoku s2, int point){
        int[] dice1=s1.getDice();
        int[] dice2=s2.getDice();
        int max=0,mark2=0;
        for(int i=0;i<3;i+=3){
            int count=0;
            if(dice1[i*3+2]>0)
                continue;
            for(int j=0;j<3;j++){
                if(point==dice2[i*3+j])
                    count++;
            }
            if(max<count){
                max=count;
                mark2=i;
            }
        }
        int mark1=0;
        max=0;
        for(int i=0;i<3;i+=3){
            int count=0;
            if(dice1[i*3+2]>0)
                continue;
            else{
                for(int j=0;j<3;j++){
                    if(dice1[i*3+j]==point)
                        count++;
                }
                if(count>max){
                    max=count;
                    mark1=i;
                }
                else if(count==max){
                    if(i==mark2)
                        mark1=i;
                }
            }
        }
        int line=mark1, row=0;
        for(int i=0;i<3;i++){
            if(dice1[line+i]==0)
                row=i;
            else
                continue;
        }
        step(s1, point, line, row);
    }
    public String compareScore(Sudoku s1, Sudoku s2){
        int score_A= ScoreCount(s1);
        int score_B= ScoreCount(s2);
        if(score_A>score_B)
            return "A";
        else if(score_A<score_B)
            return "B";
        else
            return "Equal";
    }
}
