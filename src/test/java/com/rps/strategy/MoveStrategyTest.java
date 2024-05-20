package com.rps.strategy;

import com.rps.game.Move;
import com.rps.game.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveStrategyTest {

    @Test
    public void testRockStrategy() {
        MoveStrategy rockStrategy = new RockStrategy();
        assertEquals(Result.DRAW, rockStrategy.getResult(Move.ROCK));
        assertEquals(Result.WIN, rockStrategy.getResult(Move.SCISSORS));
        assertEquals(Result.LOSE, rockStrategy.getResult(Move.PAPER));
    }

    @Test
    public void testPaperStrategy() {
        MoveStrategy paperStrategy = new PaperStrategy();
        assertEquals(Result.DRAW, paperStrategy.getResult(Move.PAPER));
        assertEquals(Result.WIN, paperStrategy.getResult(Move.ROCK));
        assertEquals(Result.LOSE, paperStrategy.getResult(Move.SCISSORS));
    }

    @Test
    public void testScissorsStrategy() {
        MoveStrategy scissorsStrategy = new ScissorsStrategy();
        assertEquals(Result.DRAW, scissorsStrategy.getResult(Move.SCISSORS));
        assertEquals(Result.WIN, scissorsStrategy.getResult(Move.PAPER));
        assertEquals(Result.LOSE, scissorsStrategy.getResult(Move.ROCK));
    }
}
