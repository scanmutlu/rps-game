package com.rps.player;

import com.rps.game.Move;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Move getMove() {
        return Move.values()[(int) (Math.random() * 3)];
    }
}

