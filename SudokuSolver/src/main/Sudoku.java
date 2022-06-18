/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author yashar
 */
public class Sudoku {
    
    
    public static char[] getRow(char[][] board, int row){
        
        return board[row];
        
    }
    
    public static char[] getColumn(char[][] board, int column){
        
        char[] columnChars = new char[9];
        for(int row = 0; row < board.length; row++){
            columnChars[row] = board[row][column];
        }
        
        return columnChars;
        
    }
    
    public static char[] getBox(char[][] board, int row, int column){
        
        char[] box = new char[9];
        
        int startRow = 3 * (row/3);
        int endRow = startRow + 3;
        int startColumn = 3 * (column/3);
        int endColumn = startColumn + 3;
        int count = 0;
        
        for(int i = startRow; i < endRow; i++){
            for(int j = startColumn; j < endColumn; j++){
                box[count] = board[i][j];
                ++count;
            }
            
        }
        return box;
        
    }
    
    public static char[] possibleNumbers(char[][] board, int row, int column){
        
        char[] rowArray = getRow(board, row);
        char[] columnArray = getColumn(board, column);
        char[] boxArray = getBox(board, row, column);
        char[] allNumbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        
        for(int i = 0; i < rowArray.length; i++){  //This gives me an array like {'1', '.', '.', '4', '5', '.', '.', '.', '9'}
            for(int j = 0; j < allNumbers.length; j++){
                if(rowArray[i] == allNumbers[j] || columnArray[i] == allNumbers[j] || boxArray[i] == allNumbers[j]){
                    allNumbers[j] = '.';
                }
            }
        }
        
        return allNumbers;
    }
    
        
    public static char[] cleanPossibleNumbers(char[][] board, int row, int column){
        
        char[] allNumbers = possibleNumbers(board, row, column);
        int size = 0;   
        
        for(int i = 0; i < allNumbers.length; i++){ //This gives me the number of actual digits (4 in this case)
            if(allNumbers[i] != '.')    size += 1;
        }
        
        int count = 0; 
        char[] possibleNumbers = new char[size];  //New array of the size of the number of actual digits (4 in this case)
        for(int i = 0; i < allNumbers.length; i++){ //This gives me an array like {'1', '4', '5', '9'}
            if(allNumbers[i] != '.'){
                possibleNumbers[count] = allNumbers[i];
                ++count;
            }
        }
        
        return possibleNumbers;
        
    }
    
    public static char[][] sudokuSolver(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){    //if it is an empty square and there can only be one possible number
                    if(cleanPossibleNumbers(board, i, j).length == 1){
                        
                        board[i][j] = cleanPossibleNumbers(board, i, j)[0];
                        board = sudokuSolver(board);
                    }
                }
            }
        }
        return board;
    }
    
    public static void showBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            System.out.println(board[i]);
        }
    }
    
            
}
