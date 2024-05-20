package com.rps;

import com.rps.game.Game;
import com.rps.player.ComputerPlayer;
import com.rps.player.HumanPlayer;
import com.rps.player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter your player name: ");

        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.next();

        Player player = new HumanPlayer(playerName);
        Player computerPlayer = new ComputerPlayer("Computer");

        Game game = new Game(player, computerPlayer);

        game.startRound();
    }
}
