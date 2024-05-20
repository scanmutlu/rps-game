package com.rps.strategy;

import com.rps.game.Move;
import com.rps.game.Result;

public class ScissorsStrategy implements MoveStrategy {
    @Override
    public Result getResult(Move opponentMove) {
        switch (opponentMove) {
            case ROCK: return Result.LOSE;
            case PAPER: return Result.WIN;
            case SCISSORS: return Result.DRAW;
            default: throw new IllegalStateException("Unexpected value: " + opponentMove);
        }
    }
}
