package com.rps.player;

import com.rps.game.Move;
import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Move getMove() {
        Random random = new Random();
        return Move.values()[random.nextInt(Move.values().length)];
    }
}