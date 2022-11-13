package com.itheima.module3.controller;

import com.itheima.module3.dto.Sudoku;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.itheima.module3.service.Sudoku.SudokuService.*;

@Controller
public class SudokuController {

    @RequestMapping("/dice/1")
    @ResponseBody
    public String[] t1(Sudoku s, int point, int line, int row){
        step(s, point, line, row);
        elimination(s, point, line);
        if(check(s)){

        }
        return new String[] {
                "Hello"
        };
    }
}
