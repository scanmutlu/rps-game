package com.rps.strategy;


import com.rps.game.Move;
import com.rps.game.Result;

public interface MoveStrategy {
    Result getResult(Move opponentMove);
}

