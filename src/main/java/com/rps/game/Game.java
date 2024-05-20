package com.rps.game;

import com.rps.player.Player;
import com.rps.strategy.*;

import java.util.Scanner;

public class Game {
    private Player player;
    private Player computerPlayer;
    private GameState gameState;
    private Boolean isContinue;

    public Game(Player player, Player computerPlayer) {
        this.player = player;
        this.computerPlayer = computerPlayer;
        this.gameState = new GameState();
        this.isContinue = true;
    }

    public void startRound() {

        while (isContinue){
            System.out.println("ROUND: " + gameState.getRound());

            Move playerMove;
            Move computerMove;

            try {
                playerMove = player.getMove();
                computerMove = computerPlayer.getMove();

                player.setMoveStrategy(getStrategy(playerMove));
                computerPlayer.setMoveStrategy(getStrategy(computerMove));

            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
                continue;
            }

            System.out.println(player.getName() + " played " + playerMove);
            System.out.println(computerPlayer.getName() + " played " + computerMove);

            Result result = player.getResult(computerMove);
            gameState.updateGameStateByResult(result);

            displayRoundResult(result);
            continueToNewRound();
        }
        System.out.println("FINAL SCORE TABLE: ");
        displayGameState();
    }

    private MoveStrategy getStrategy(Move move) {
        switch (move) {
            case ROCK: return new RockStrategy();
            case PAPER: return new PaperStrategy();
            case SCISSORS: return new ScissorsStrategy();
            default: throw new IllegalArgumentException("Invalid move: " + move);
        }
    }

    private void displayRoundResult(Result result) {
        switch (result) {
            case WIN: System.out.println(player.getName() + " wins!"); break;
            case LOSE: System.out.println(computerPlayer.getName() + " wins!"); break;
            case DRAW: System.out.println("It's a tie!"); break;
        }
        displayGameState();
    }

    private void displayGameState(){
        System.out.println(player.getName() + " Score: " + gameState.getPlayerScore());
        System.out.println("Draw Score: " + gameState.getDrawScore());
        System.out.println(computerPlayer.getName() + " Score: " + gameState.getComputerScore());
    }

    private void continueToNewRound(){
        System.out.println("Play again? (y: yes / any other char: no)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        isContinue = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }
}

