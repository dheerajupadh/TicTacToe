package com.dev.beans;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> board;

    public Board(int dimension){
        board = new ArrayList<>();
        for(int i=0; i < dimension; i++){
            List<Cell> rows = new ArrayList<>();
            for(int j=0; j < dimension; j++){
                rows.add(new Cell(i,j));
            }
            board.add(rows);
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void printBoard(){
        for(List<Cell> boards : board){
            for(Cell cell : boards){
                cell.display();
            }
            System.out.println();

        }
    }
}
