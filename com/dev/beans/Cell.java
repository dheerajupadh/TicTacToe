package com.dev.beans;

import java.util.List;

public class Cell {

    private Symbol symbol;

    private int row;

    private int col;

    private Player player;

    private CellState cellState;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        player = null;
        cellState = CellState.EMPTY;
        symbol = null;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void display(){
        if(player == null){
            System.out.print( " | - | " );
        }else{
            System.out.print(" | " + symbol.getSymbol() + " | ");
        }
    }


}
