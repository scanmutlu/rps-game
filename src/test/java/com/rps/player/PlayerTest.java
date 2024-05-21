package com.rps.player;

import com.rps.game.Move;
import com.rps.game.Result;
import com.rps.strategy.RockStrategy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @Test
    public void testComputerPlayerMove() {
        Player computerPlayer = new ComputerPlayer("Computer");
        assertThat(computerPlayer.getMove() ,anyOf(is(Move.ROCK), is(Move.PAPER), is(Move.SCISSORS)));
    }

    @Test
    public void testHumanPlayer_RockMove() {

        String simulatedUserInput = "r"; // Simulates user entering "r" for ROCK move
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            Player humanPlayer = new HumanPlayer("Human");
            assertEquals(Move.ROCK ,humanPlayer.getMove());

        } finally {
            System.setIn(stdin); // Reset System.in to its original state
        }
    }

    @Test
    public void testHumanPlayer_PaperMove() {

        String simulatedUserInput = "p"; // Simulates user entering "p" for PAPER move
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            Player humanPlayer = new HumanPlayer("Human");
            assertEquals(Move.PAPER ,humanPlayer.getMove());

        } finally {
            System.setIn(stdin); // Reset System.in to its original state
        }
    }

    @Test
    public void testHumanPlayer_ScissorsMove() {

        String simulatedUserInput = "s"; // Simulates user entering "s" for SCISSOR move
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            Player humanPlayer = new HumanPlayer("Human");
            assertEquals(Move.SCISSORS ,humanPlayer.getMove());

        } finally {
            System.setIn(stdin); // Reset System.in to its original state
        }
    }

    @Test
    public void testHumanPlayer_InvalidMove() {

        String simulatedUserInput = "invalid-str"; // Simulates user entering any other invalid input for move
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            Player humanPlayer = new HumanPlayer("Human");
            assertThrows(IllegalArgumentException.class , humanPlayer::getMove);

        } finally {
            System.setIn(stdin); // Reset System.in to its original state
        }
    }

    @Test
    public void testHumanPlayer_Result() {
        Player humanPlayer = new HumanPlayer("Human");
        humanPlayer.setMoveStrategy(new RockStrategy());  // human player chose ROCK
        assertEquals(Result.LOSE, humanPlayer.getResult(Move.PAPER)); // opponent move PAPER, result should LOSE
        assertEquals(Result.DRAW, humanPlayer.getResult(Move.ROCK)); // opponent move ROCK, result should DRAW
        assertEquals(Result.WIN, humanPlayer.getResult(Move.SCISSORS)); // opponent move SCISSORS, result should WIN
    }

}
