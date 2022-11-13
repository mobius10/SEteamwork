package com.itheima.module3;


import com.itheima.module3.dto.Sudoku;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.itheima.module3.service.Sudoku.SudokuService.ScoreCount;

public class SudokuTest {

    @Test
    public void testScoreCount(){
        Sudoku s=new Sudoku();
        int[] arr={1,1,2,3,3,6,5,4,4};
        s.setDice(arr);
        Assertions.assertEquals(45,ScoreCount(s));
    }
}
