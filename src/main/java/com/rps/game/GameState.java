package com.rps.game;

public class GameState {
    private int playerScore = 0;
    private int computerScore = 0;
    private int drawScore = 0;
    private int round = 1;

    public GameState() {
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getDrawScore() {
        return drawScore;
    }

    public int getRound() {
        return round;
    }

    public void updateGameStateByResult(Result result) {
        switch (result) {
            case WIN: this.playerScore++; break;
            case LOSE: this.computerScore++; break;
            case DRAW: this.drawScore++; break;
        }
        this.round++;
    }

}
