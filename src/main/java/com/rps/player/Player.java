package com.rps.player;

import com.rps.game.Move;
import com.rps.game.Result;
import com.rps.strategy.MoveStrategy;

public abstract class Player {
    protected String name;
    protected MoveStrategy moveStrategy;

    public Player(String name) {
        this.name = name;
    }

    public abstract Move getMove();

    public String getName() {
        return name;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Result getResult(Move opponentMove) {
        return moveStrategy.getResult(opponentMove);
    }
}

