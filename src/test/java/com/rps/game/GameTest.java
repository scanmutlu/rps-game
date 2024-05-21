package com.rps.game;

import com.rps.player.ComputerPlayer;
import com.rps.player.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

public class GameTest {

    @Test
    public void testGamePlay() {

        Player player = mock(Player.class);
        ComputerPlayer computerPlayer = mock(ComputerPlayer.class);

        when(player.getMove()).thenReturn(Move.ROCK);
        when(computerPlayer.getMove()).thenReturn(Move.SCISSORS);
        when(player.getResult(computerPlayer.getMove())).thenReturn(Result.WIN);

        String simulatedUserInput = "no"; // Simulates user entering "no" for restart round
        InputStream stdin = System.in;

        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            Game game = new Game(player, computerPlayer);
            game.startRound();

            // Verifying interactions
            verify(player).getMove();
            verify(computerPlayer, atLeastOnce()).getMove(); //computers get moves should be called twice
        } finally {
            System.setIn(stdin); // Reset System.in to its original state
        }

    }
}
