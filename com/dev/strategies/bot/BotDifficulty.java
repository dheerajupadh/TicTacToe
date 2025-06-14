package com.dev.strategies.bot;

import com.dev.beans.Board;
import com.dev.beans.Move;

public interface BotDifficulty {

    public Move getMove(Board board);
}
