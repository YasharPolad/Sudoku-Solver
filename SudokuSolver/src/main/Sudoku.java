/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Arrays;                            //If something is not in my possible values, it means that it has to be in one of the other empty squares
                                                    //So, we add that to the possible/expected values of the other empty squares, as long as that value isn't in the
/**                                                 //"prohibited" values of the other squares.
 *
 * @author yashar
 */
public class Sudoku {
    
    int count = 0;
    Square[][] board;
    int size;
    final char[] allNumbers;
    
    public Sudoku(char[][] board) {
        
        this.board = new Square[board.length][board.length]; //Initialize the sudoku to an empty array of the size of board. We will fill it with objects of Square! :)
        this.size = board.length;
        this.allNumbers = this.allNumbers();
        this.populate(board);
        //char[27][] missingValues -> A list of all the missingValues of the sudoku. 9 for rows, columns, and boxes. Have them checked and updated at each state of the board
        
    }
    
    
    public char[] allNumbers(){                         //Method for initialize allNumbers constant
        char[] allNumbersTemp = new char[this.size];
        for(int i = 0; i < allNumbersTemp.length; i++){
            allNumbersTemp[i] = Character.forDigit((i + 1), 10);
        }
        return allNumbersTemp;
    }
    
    
    public void populate(char[][] board){  // populate the board with square objects. They hold the values on the board. But they will also hold expected values 
                                            //and other cool things! :) Square also holds the whole sudoku object as a property, as its methods determining 
        for(int i = 0; i < this.board.length; i++){             //its possible values depends on the state of the whole sudoku
            for(int j = 0; j < this.board.length; j++){
                this.board[i][j] = new Square(board[i][j], i, j, this); //because we have initialized the board to an array of empty squares before calling the populate method
            }                                                           //we can pass the empty sudoku to the square. Would this have been possible in python? If I didn't preassign
        }                                                               //the type of this.board. But still ask someone how it is possible to pass this without finishing the constructor call.
        
    }
    
    
    public Square[] getRow(int row){    //Get the row array
        
        return this.board[row];
        
    }
    
    public Square[] getColumn(int column){  //Get the column array 
        
        Square[] columnChars = new Square[this.board.length];
        for(int row = 0; row < this.board.length; row++){
            columnChars[row] = this.board[row][column];
        }
        
        return columnChars;
        
    }
    
    public Square[] getBox(int row, int column){ //Get the box array
        
        Square[] box = new Square[9];
        
        int startRow = 3 * (row/3);
        int endRow = startRow + 3;
        int startColumn = 3 * (column/3);
        int endColumn = startColumn + 3;
        int count = 0;
        
        for(int i = startRow; i < endRow; i++){
            for(int j = startColumn; j < endColumn; j++){
                box[count] = this.board[i][j];
                ++count;
            }
            
        }
        return box;
        
    }
    
    //*********************************************************************************************************************************************************
    
    public char[] missingValues(Square[] arr){ // Given an array (this will be either the row, column, or box array),
                                               //return the missing values.
        char[] missingValues = new char[0];
        
        for(int i = 0; i < this.allNumbers.length; i++){
            boolean charFound = false;
            for(int j = 0; j < arr.length; j++){
                if(arr[j].value == this.allNumbers[i]){
                    charFound = true;
                    break;
                }
            }
            if(charFound == false){  //If char is not in the row, update the missing values list with the new missing value
                missingValues = Arrays.copyOf(missingValues, missingValues.length + 1);
                missingValues[missingValues.length - 1] = this.allNumbers[i];
            }
        }
        
        return missingValues;
        
    }
    
    
    public boolean valuePossibleOnlyForOneSquare(char value, Square[] arr) { //Determines whether only one square in a given row, column, or box is expecting the given char value
       int countPossibleSquares = 0; 
       for(int i = 0; i < arr.length; i++){
           if(arr[i].isValuePossible(value) == true) countPossibleSquares += 1;
       }
       
       return countPossibleSquares == 1;     
    }
    
    
//    public int indexOfSquareContainingValue(char value, Square[] arr){
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j < arr[i].possibleValues.length; j++){
//                if(arr[i].possibleValues[j] == value){
//                    return i;
//                }
//            }
//        }
//        return 10;
//    }
    
    
    //***************************************************************************************************************************************
        
    public void Solve(){
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board.length; j++){
                Square square = this.board[i][j];
                if(square.value == '.'){    
                    square.cleanPossibleNumbers();          //when my possibleValues change, only my row, column, and box are affected. This doesn't change their possible values,
                                                           //only changes whether they now might be the only one that holds a missing value from that row, column, or box as their possible value.
                                                            //But when a square gains a value, it actually changes the possible values in the row, column, and box, which propogate to the whole grid
                                                            //regarding the value by necessity
                    if(square.possibleValues.length == 1){ //if it is an empty square and there can only be one possible number, then the value of that square must be that single possible number
                        
                        square.value = square.possibleValues[0];
                        square.possibleValues = new char[0]; // Reset the possible values of the square to an empty array
                        this.count += 1;
                        this.Solve();
                    } else {
                        square.isValuePossibleOnlyForMe();
                    }
                }
            }
        }
        
    }

    
    public void showBoard(){
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board.length; j++){
                System.out.print(this.board[i][j].value);
            }
            System.out.println("\n");
        }
    }
    
            
}
