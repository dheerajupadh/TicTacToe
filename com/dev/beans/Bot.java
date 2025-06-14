package com.dev.beans;

import com.dev.strategies.bot.BotDifficulty;
import com.dev.strategies.bot.EasyDifficulty;
import com.dev.strategies.bot.HardDifficulty;
import com.dev.strategies.bot.MediumDifficulty;

public class Bot extends Player{


    private BotDifficulty botDifficulty;


    public Bot(String name, Symbol symbol, PlayerType playerType) {
        super(name, symbol, playerType);
    }

    public Bot(String name, Symbol symbol,BotDifficultyLevel botDifficultyLevel){
        super(name,symbol,PlayerType.BOT);

        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            botDifficulty = new EasyDifficulty();
        }else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
            botDifficulty = new MediumDifficulty();
        }else{
            botDifficulty = new HardDifficulty();
        }

    }

    @Override
    public Move makeMove(Board board){
        Move move  = botDifficulty.getMove(board);
        return move;
    }
}
