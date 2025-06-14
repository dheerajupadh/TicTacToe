package com.dev.strategies.winning;

import com.dev.beans.Board;
import com.dev.beans.Move;
import com.dev.beans.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategies{

    Map<Integer, Map<Symbol, Integer>> map= new HashMap<>();

    @Override
    public boolean isWinning(Board board, Move move) {

        Symbol symbol = move.getPlayer().getSymbol();
        if(!map.containsKey(move.getCol())){
            map.put(move.getCol(), new HashMap<>());

        }

        Map<Symbol, Integer> colMap = map.get(move.getCol());

        colMap.put(symbol, colMap.getOrDefault(symbol, 0) + 1);

        return colMap.get(symbol) == board.getBoard().size();
    }
}
