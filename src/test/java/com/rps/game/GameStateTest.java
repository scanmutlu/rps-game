package com.rps.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {

    @Test
    public void testCreateGameState() {
        GameState gameState = new GameState();
        assertEquals(0 ,gameState.getPlayerScore());
        assertEquals(0 ,gameState.getComputerScore());
        assertEquals(1 ,gameState.getRound());
        assertEquals(0 ,gameState.getDrawScore());
    }

    @Test
    public void testUpdateGameState() {
        GameState gameState = new GameState();
        assertEquals(0 ,gameState.getPlayerScore());
        assertEquals(0 ,gameState.getComputerScore());
        assertEquals(1 ,gameState.getRound());
        assertEquals(0 ,gameState.getDrawScore());

        gameState.updateGameStateByResult(Result.WIN);

        assertEquals(1 ,gameState.getPlayerScore());
        assertEquals(0 ,gameState.getComputerScore());
        assertEquals(2 ,gameState.getRound());
        assertEquals(0 ,gameState.getDrawScore());

        gameState.updateGameStateByResult(Result.LOSE);

        assertEquals(1 ,gameState.getPlayerScore());
        assertEquals(1 ,gameState.getComputerScore());
        assertEquals(3 ,gameState.getRound());
        assertEquals(0 ,gameState.getDrawScore());

        gameState.updateGameStateByResult(Result.DRAW);

        assertEquals(1 ,gameState.getPlayerScore());
        assertEquals(1 ,gameState.getComputerScore());
        assertEquals(4 ,gameState.getRound());
        assertEquals(1 ,gameState.getDrawScore());

    }
}
