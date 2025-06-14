package com.dev.controllers;

import com.dev.Exceptions.CellAlreadyOccupiedException;
import com.dev.Exceptions.OutOfDimensionException;
import com.dev.beans.Game;
import com.dev.beans.GameState;
import com.dev.beans.Player;
import com.dev.strategies.winning.WinningStrategies;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategies> winningStrategies){
        return Game.getBuilder().setDimension(dimension).
                setPlayers(players).setWinningStrategies(winningStrategies).build();

    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game) throws OutOfDimensionException, CellAlreadyOccupiedException {

        while(game.getGameState().equals(GameState.INPROGRESS)){
            game.makeMove();
            game.printBoard();
        }

        if(game.getGameState().equals(GameState.WIN)){
            System.out.print("Player " + game.getWinner() +  " has won the game");
        }
        if(game.getGameState().equals(GameState.DRAW)){
            System.out.print("Game has ended in a draw");
        }

    }
}
