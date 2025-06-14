package com.dev.beans;

import java.util.Scanner;

public class Player {

    private String name;

    private Symbol symbol;

    private PlayerType playerType;

    Scanner sc = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){

        System.out.print("Enter the row you want to insert into");
        int row = sc.nextInt();

        System.out.print("Enter the col you want to insert into");
        int col = sc.nextInt();

        Move move = new Move(row, col);

        move.setPlayer(this);
        return move;
    }
}
