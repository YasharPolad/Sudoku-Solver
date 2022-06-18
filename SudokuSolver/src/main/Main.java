/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author yashar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char[][] board = {{'.','.','.','.','.','3','.','.','.'},{'9','.','.','.','8','.','2','3','4'},{'.','.','.','2','5','4','.','.','.'},{'.','.','2','.','7','.','5','.','.'},{'5','.','8','.','.','.','4','.','3'},{'7','.','.','.','.','.','9','.','1'},{'.','.','.','.','4','5','.','9','.'},{'3','.','.','.','.','6','.','.','5'},{'.','.','.','.','.','.','3','4','7'}};

        char[][] solvedBoard = Sudoku.sudokuSolver(board);
        Sudoku.showBoard(solvedBoard);
        
        

    }
    
}