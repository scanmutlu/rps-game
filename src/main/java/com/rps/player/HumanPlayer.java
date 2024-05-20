package com.rps.player;

import com.rps.game.Move;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move getMove() throws IllegalArgumentException {
        System.out.println("Enter move character (R = ROCK, P = PAPER, S = SCISSORS): ");
        String move = scanner.next();
        char moveChar = move.toUpperCase().charAt(0);
        switch (moveChar) {
            case 'R': return Move.ROCK;
            case 'P': return Move.PAPER;
            case 'S': return Move.SCISSORS;
            default: throw new IllegalArgumentException("Invalid input: \"" + move + "\" " + "Input must be one of the (R = ROCK, P = PAPER, S = SCISSORS)");
        }
    }
}

