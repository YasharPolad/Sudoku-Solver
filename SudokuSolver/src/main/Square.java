/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Arrays;

/**
 *
 * @author yashar
 */
public class Square {
    
    public char value;
    public char[] possibleValues = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; 
    public Sudoku sudoku;
    int row;
    int column;
    
    
    public Square(char value, int row, int column, Sudoku sudoku) {
        
        this.value = value;
        this.row = row;
        this.column = column;
        this.sudoku = sudoku;
        
//        this.cleanPossibleNumbers();
        
        
    }
    
    //***********************************************Value by Elimination*****************************************************************
    
    public char[] possibleNumbers(){
        
        int row = this.row;
        int column = this.column;
        
        Square[] rowArray = this.sudoku.getRow(row);
        Square[] columnArray = this.sudoku.getColumn(column);
        Square[] boxArray = this.sudoku.getBox(row, column);
        char[] allNumbers = Arrays.copyOf(this.sudoku.allNumbers, this.sudoku.allNumbers.length);
        
        for(int i = 0; i < rowArray.length; i++){  //This gives me an array like {'1', '.', '.', '4', '5', '.', '.', '.', '9'}
            for(int j = 0; j < allNumbers.length; j++){
                if(rowArray[i].value == allNumbers[j] || columnArray[i].value == allNumbers[j] || boxArray[i].value == allNumbers[j]){
                    allNumbers[j] = '.';
                }
            }
        }
        
        return allNumbers;
    }
    
    public void cleanPossibleNumbers(){
        
        char[] allNumbers = this.possibleNumbers();
        int size = 0;   
        
        for(int i = 0; i < allNumbers.length; i++){ //This gives me the number of actual digits (4 in this case)
            if(allNumbers[i] != '.')    size += 1;
        }
        
        int count = 0; 
        this.possibleValues = new char[size];  //New array of the size of the number of actual digits (4 in this case)
        for(int i = 0; i < allNumbers.length; i++){ //This gives me an array like {'1', '4', '5', '9'}
            if(allNumbers[i] != '.'){
                this.possibleValues[count] = allNumbers[i];
                ++count;
            }
        }
        
    }
    
    //*************************************************Value by NECESSITY***************************************************
    
    
    public boolean isValuePossible(char value){ //determins whether a given char value is in the list of the possible values of the Square object
        for(int i = 0; i < this.possibleValues.length; i++){
            if(value == this.possibleValues[i]){
                return true;
            }
        }
        return false;
    }
    
    
    
    
}
