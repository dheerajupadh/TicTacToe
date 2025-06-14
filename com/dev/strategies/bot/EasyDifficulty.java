package com.dev.strategies.bot;

import com.dev.beans.Board;
import com.dev.beans.Cell;
import com.dev.beans.CellState;
import com.dev.beans.Move;

import java.util.List;

public class EasyDifficulty implements BotDifficulty{
    @Override
    public Move getMove(Board board) {
       for(List<Cell> cells: board.getBoard()){
           for(Cell cell : cells){
               if(cell.getCellState().equals(CellState.EMPTY)){
                   return new Move(cell.getRow(), cell.getCol());
               }
           }
       }
       return null;
    }
}
