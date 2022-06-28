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
      char[][] board = {{'.','.','9','7','4','8','.','.','2'},{'7','.','.','6','.','2','.','.','9'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','9','8','6','2','4','1'},{'2','6','4','3','1','7','5','9','8'},{'1','9','8','5','2','4','3','6','7'},{'9','.','.','8','6','3','.','2','.'},{'.','.','2','4','9','1','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
//      char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//      char[][] board = {{'.','.','.','.','.','3','.','.','.'},{'9','.','.','.','8','.','2','3','4'},{'.','.','.','2','5','4','.','.','.'},{'.','.','2','.','7','.','5','.','.'},{'5','.','8','.','.','.','4','.','3'},{'7','.','.','.','.','.','9','.','1'},{'.','.','.','.','4','5','.','9','.'},{'3','.','.','.','.','6','.','.','5'},{'.','.','.','.','.','.','3','4','7'}};
//      char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}}; 
//      char[][] board = {{'.','.','9','.','.','.','.','.','5'},{'.','.','.','.','.','7','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'2','.','.','.','.','.','7','9','8'},{'.','5','.','.','.','.','3','.','2'},{'.','9','7','2','1','3','.','.','6'},{'.','.','5','.','.','1','.','7','4'},{'.','8','2','9','.','4','5','.','.'},{'9','.','1','.','.','.','.','.','.'}};
//        char[][] board = {{'.','.','.','.','.','.','.','.','.'},{'1','.','.','2','.','.','.','.','9'},{'.','.','.','4','5','6','.','.','.'},{'.','.','.','.','4','.','6','.','7'},{'4','5','.','6','.','1','3','9','2'},{'.','.','.','3','.','2','4','1','5'},{'5','.','.','.','6','.','.','3','.'},{'.','.','4','9','2','.','.','5','.'},{'9','7','3','8','1','.','.','6','.'}};
        Sudoku sudoku = new Sudoku(board);
        sudoku.Solve();
        sudoku.showBoard();
        System.out.println(sudoku.count+"   "+sudoku.count2);
        
        

    }
    
}


