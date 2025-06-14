package com.dev.strategies.winning;

import com.dev.beans.Board;
import com.dev.beans.Move;
import com.dev.beans.Symbol;

public interface WinningStrategies {

    public boolean isWinning(Board board, Move move);
}
