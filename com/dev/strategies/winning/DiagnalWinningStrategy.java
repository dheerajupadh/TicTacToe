package com.dev.strategies.winning;

import com.dev.beans.Board;
import com.dev.beans.Move;
import com.dev.beans.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagnalWinningStrategy implements WinningStrategies{

    Map<Symbol, Integer> diagnal = new HashMap<>();
    Map<Symbol, Integer> antiDiagnal = new HashMap<>();
    @Override
    public boolean isWinning(Board board, Move move) {

        int row = move.getRow();
        int col = move.getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            diagnal.put(symbol, diagnal.getOrDefault(symbol,0) +1);

            if(diagnal.get(symbol) == board.getBoard().size()){
                return true;
            }
        }

        if(row + col == board.getBoard().size()){
            antiDiagnal.put(symbol, antiDiagnal.getOrDefault(symbol,0) +1);
            if(antiDiagnal.get(symbol) == board.getBoard().size()){
                return true;
            }
        }

        return false;


    }
}
