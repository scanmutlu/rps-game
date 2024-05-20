package com.rps.strategy;

import com.rps.game.Move;
import com.rps.game.Result;

public class PaperStrategy implements MoveStrategy {
    @Override
    public Result getResult(Move opponentMove) {
        switch (opponentMove) {
            case ROCK: return Result.WIN;
            case PAPER: return Result.DRAW;
            case SCISSORS: return Result.LOSE;
            default: throw new IllegalStateException("Unexpected value: " + opponentMove);
        }
    }
}

