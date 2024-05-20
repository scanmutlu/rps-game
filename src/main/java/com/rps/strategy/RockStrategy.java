package com.rps.strategy;

import com.rps.game.Move;
import com.rps.game.Result;

public class RockStrategy implements MoveStrategy {
    @Override
    public Result getResult(Move opponentMove) {
        switch (opponentMove) {
            case ROCK: return Result.DRAW;
            case PAPER: return Result.LOSE;
            case SCISSORS: return Result.WIN;
            default: throw new IllegalStateException("Unexpected value: " + opponentMove);
        }
    }
}
