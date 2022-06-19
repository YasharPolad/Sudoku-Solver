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
    
    int count = 0;
    Square[][] board;
    int size;
    
    public Sudoku(char[][] board) {
        
        this.board = new Square[board.length][board.length]; //Initialize the sudoku to an empty array of the size of board. We will fill it with objects of Square! :)
        this.size = board.length;
        this.populate(board);
        
    }
    
    public void populate(char[][] board){  // populate the board with square objects. They hold the values of board. But they will also hold expected values 
                                            //and other cool things! :) Square also holds the whole sudoku object as a property, as its methods determining 
        for(int i = 0; i < this.board.length; i++){             //its possible values depends on the state of the whole sudoku
            for(int j = 0; j < this.board.length; j++){
                this.board[i][j] = new Square(board[i][j], i, j, this);
            }
        }
        
    }
    
    
    public Square[] getRow(int row){
        
        return this.board[row];
        
    }
    
    public Square[] getColumn(int column){
        
        Square[] columnChars = new Square[this.board.length];
        for(int row = 0; row < this.board.length; row++){
            columnChars[row] = this.board[row][column];
        }
        
        return columnChars;
        
    }
    
    public Square[] getBox(int row, int column){
        
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
    
    
        
    public void Solve(){
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board.length; j++){
                Square square = this.board[i][j];
                if(square.value == '.'){    //if it is an empty square and there can only be one possible number
                    square.cleanPossibleNumbers();
                    if(square.possibleValues.length == 1){
                        
                        square.value = square.possibleValues[0];
                        this.count += 1;
                        this.Solve();
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
